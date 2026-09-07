package com.example.answerit.ui.game

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.answerit.AnswerItApplication
import com.example.answerit.data.model.AppSettings
import com.example.answerit.data.model.GameStatus
import com.example.answerit.data.model.GameUiState
import com.example.answerit.data.model.Language
import com.example.answerit.data.model.Lifelines
import com.example.answerit.data.model.PlayerProfile
import com.example.answerit.data.model.Question
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private val container = (application as AnswerItApplication).container
    private val preferencesRepository = container.preferencesRepository
    private val questionRepository = container.questionRepository
    private val soundEffectManager = container.soundEffectManager
    private val hapticManager = container.hapticManager

    private val _appSettings = MutableStateFlow(preferencesRepository.getAppSettings())
    val appSettings: StateFlow<AppSettings> = _appSettings.asStateFlow()

    private val _playerProfile = MutableStateFlow(preferencesRepository.getPlayerProfile())
    val playerProfile: StateFlow<PlayerProfile> = _playerProfile.asStateFlow()

    private val _gameUiState = MutableStateFlow(GameUiState())
    val gameUiState: StateFlow<GameUiState> = _gameUiState.asStateFlow()

    private val _eventChannel = Channel<GameUiEvent>(Channel.BUFFERED)
    val events = _eventChannel.receiveAsFlow()

    private var questions: List<Question> = emptyList()

    init {
        val lang = _appSettings.value.language
        questions = questionRepository.getGameQuestions(lang)
        loadQuestion(0)
    }

    fun startNewGame() {
        val lang = _appSettings.value.language
        questions = questionRepository.getGameQuestions(lang)
        _gameUiState.value = GameUiState(
            totalQuestions = questions.size
        )
        loadQuestion(0)
    }

    fun updateQuestionsForLanguage(language: Language) {
        questions = questionRepository.getGameQuestions(language)
        val currentIndex = _gameUiState.value.questionIndex
        if (currentIndex < questions.size) {
            loadQuestion(currentIndex)
        }
    }

    fun loadQuestion(index: Int) {
        if (index < questions.size) {
            val q = questions[index]
            _gameUiState.update { current ->
                current.copy(
                    currentQuestion = q,
                    questionIndex = index,
                    currentPrize = q.prizeMoney,
                    safeHaven = calculateSafeHaven(index),
                    selectedOptionIndex = -1,
                    hiddenOptionIndices = emptySet()
                )
            }
        }
    }

    fun selectAnswerOption(index: Int) {
        _gameUiState.update { it.copy(selectedOptionIndex = index) }
    }

    fun submitAnswer() {
        val currentState = _gameUiState.value
        val question = currentState.currentQuestion ?: return
        val selected = currentState.selectedOptionIndex
        if (selected == -1) return

        val isCorrect = selected == question.correctAnswer
        val settings = _appSettings.value

        if (isCorrect) {
            if (settings.soundEnabled) {
                soundEffectManager.playCorrect()
            }
            val nextIndex = currentState.questionIndex + 1
            if (nextIndex >= questions.size) {
                // Game Won
                val currentProfile = _playerProfile.value
                val updatedProfile = currentProfile.copy(
                    bestScore = maxOf(currentProfile.bestScore, question.prizeMoney),
                    totalWinnings = currentProfile.totalWinnings + question.prizeMoney,
                    gamesPlayed = currentProfile.gamesPlayed + 1,
                    lastPlayedDate = System.currentTimeMillis()
                )
                _playerProfile.value = updatedProfile
                preferencesRepository.savePlayerProfile(updatedProfile)

                _gameUiState.update {
                    it.copy(
                        gameStatus = GameStatus.WON,
                        score = question.prizeMoney
                    )
                }

                viewModelScope.launch {
                    _eventChannel.send(GameUiEvent.ShowGameResult(won = true, prize = question.prizeMoney))
                }
            } else {
                loadQuestion(nextIndex)
            }
        } else {
            // Game Lost
            if (settings.soundEnabled) {
                soundEffectManager.playWrong()
            }
            if (settings.vibrationEnabled) {
                hapticManager.vibrateError(300)
            }

            val safePrize = currentState.safeHaven
            val currentProfile = _playerProfile.value
            val updatedProfile = currentProfile.copy(
                bestScore = maxOf(currentProfile.bestScore, safePrize),
                totalWinnings = currentProfile.totalWinnings + safePrize,
                gamesPlayed = currentProfile.gamesPlayed + 1,
                lastPlayedDate = System.currentTimeMillis()
            )
            _playerProfile.value = updatedProfile
            preferencesRepository.savePlayerProfile(updatedProfile)

            _gameUiState.update {
                it.copy(
                    gameStatus = GameStatus.LOST,
                    score = safePrize
                )
            }

            viewModelScope.launch {
                _eventChannel.send(GameUiEvent.ShowGameResult(won = false, prize = safePrize))
            }
        }
    }

    fun useFiftyFifty() {
        val currentState = _gameUiState.value
        if (!currentState.lifelines.fiftyFifty) return
        val question = currentState.currentQuestion ?: return

        val wrongOptions = question.options.indices.filter { it != question.correctAnswer }
        val toHide = wrongOptions.shuffled().take(2).toSet()

        _gameUiState.update {
            it.copy(
                lifelines = it.lifelines.copy(fiftyFifty = false),
                hiddenOptionIndices = toHide
            )
        }
    }

    fun usePhoneFriend() {
        val currentState = _gameUiState.value
        if (!currentState.lifelines.phoneFriend) return
        val question = currentState.currentQuestion ?: return

        _gameUiState.update {
            it.copy(lifelines = it.lifelines.copy(phoneFriend = false))
        }

        viewModelScope.launch {
            _eventChannel.send(GameUiEvent.ShowPhoneFriendHint(question.options[question.correctAnswer]))
        }
    }

    fun useAudienceHelp() {
        val currentState = _gameUiState.value
        if (!currentState.lifelines.audienceHelp) return
        val question = currentState.currentQuestion ?: return

        _gameUiState.update {
            it.copy(lifelines = it.lifelines.copy(audienceHelp = false))
        }

        val percentages = mutableListOf(0, 0, 0, 0)
        percentages[question.correctAnswer] = (45..70).random()
        val remaining = 100 - percentages[question.correctAnswer]
        val wrongIndices = percentages.indices.filter { it != question.correctAnswer }
        val perOption = remaining / wrongIndices.size

        wrongIndices.forEach { percentages[it] = perOption }
        if (wrongIndices.isNotEmpty()) {
            percentages[wrongIndices.first()] += remaining % wrongIndices.size
        }

        viewModelScope.launch {
            _eventChannel.send(GameUiEvent.ShowAudienceHelp(percentages))
        }
    }

    fun requestQuit() {
        val safeHaven = _gameUiState.value.safeHaven
        viewModelScope.launch {
            _eventChannel.send(GameUiEvent.ShowQuitDialog(formatPrizeMoney(safeHaven)))
        }
    }

    fun confirmQuit() {
        val currentState = _gameUiState.value
        val safeHaven = currentState.safeHaven
        val currentProfile = _playerProfile.value
        val updatedProfile = currentProfile.copy(
            bestScore = maxOf(currentProfile.bestScore, safeHaven),
            totalWinnings = currentProfile.totalWinnings + safeHaven,
            gamesPlayed = currentProfile.gamesPlayed + 1,
            lastPlayedDate = System.currentTimeMillis()
        )
        _playerProfile.value = updatedProfile
        preferencesRepository.savePlayerProfile(updatedProfile)

        _gameUiState.update {
            it.copy(
                gameStatus = GameStatus.QUIT,
                score = safeHaven
            )
        }

        viewModelScope.launch {
            _eventChannel.send(GameUiEvent.ShowGameResult(won = false, prize = safeHaven))
        }
    }

    private fun calculateSafeHaven(index: Int): Int {
        return when {
            index >= 10 -> 32_000
            index >= 5 -> 1_000
            else -> 0
        }
    }

    fun getSafeHaven(): Int = _gameUiState.value.safeHaven

    fun formatPrizeMoney(amount: Number): String {
        val lang = _appSettings.value.language
        val formattedNumber = String.format("%,d", amount.toLong())
        return "${lang.currencySymbol}$formattedNumber"
    }

    fun updatePlayerName(name: String) {
        val currentProfile = _playerProfile.value
        val updated = currentProfile.copy(name = name)
        _playerProfile.value = updated
        preferencesRepository.savePlayerProfile(updated)
    }

    fun resetPlayerStats() {
        preferencesRepository.resetPlayerStats()
        _playerProfile.value = preferencesRepository.getPlayerProfile()
    }

    fun updateAppSettings(settings: AppSettings) {
        val prevLang = _appSettings.value.language
        _appSettings.value = settings
        preferencesRepository.saveAppSettings(settings)

        if (prevLang != settings.language) {
            updateQuestionsForLanguage(settings.language)
        }
    }
}
