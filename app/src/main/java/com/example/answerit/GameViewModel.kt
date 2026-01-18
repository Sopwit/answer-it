package com.example.answerit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.answerit.data.*
import android.app.Application
import android.content.Context
import java.util.Locale

class GameViewModel : ViewModel() {
    private val _appSettings = MutableLiveData(AppSettings())
    val appSettings: LiveData<AppSettings> = _appSettings

    private val _gameState = MutableLiveData(GameState())
    val gameState: LiveData<GameState> = _gameState

    private val _currentQuestion = MutableLiveData<Question?>()
    val currentQuestion: LiveData<Question?> = _currentQuestion

    private val _playerProfile = MutableLiveData(PlayerProfile())
    val playerProfile: LiveData<PlayerProfile> = _playerProfile

    private var questions: List<Question> = emptyList()

    init {
        // Always load questions in the current language
        val lang = _appSettings.value?.language ?: Language.ENGLISH
        questions = QuestionRepository.getQuestions(lang)
        loadQuestion(0)
    }

    fun startNewGame() {
        val lang = _appSettings.value?.language ?: Language.ENGLISH
        questions = QuestionRepository.getQuestions(lang)
        _gameState.value = GameState()
        loadQuestion(0)
    }

    fun updateQuestionsForLanguage(language: Language) {
        questions = QuestionRepository.getQuestions(language)
        // Reload current question if there is one
        val currentIndex = _gameState.value?.currentQuestionIndex ?: 0
        if (currentIndex < questions.size) {
            loadQuestion(currentIndex)
        }
    }

    fun loadQuestion(index: Int) {
        if (index < questions.size) {
            _currentQuestion.value = questions[index]
            _gameState.value = _gameState.value?.copy(
                currentQuestionIndex = index,
                currentPrize = questions[index].prizeMoney
            )
        }
    }

    fun submitAnswer(selectedAnswer: Int) {
        val question = _currentQuestion.value ?: return
        val isCorrect = selectedAnswer == question.correctAnswer

        if (isCorrect) {
            val nextIndex = _gameState.value?.currentQuestionIndex?.plus(1) ?: 0
            if (nextIndex >= questions.size) {
                // Player won!
                val currentProfile = _playerProfile.value ?: PlayerProfile()
                val newBestScore = maxOf(currentProfile.bestScore, question.prizeMoney)
                val newTotalWinnings = currentProfile.totalWinnings + question.prizeMoney
                val newGamesPlayed = currentProfile.gamesPlayed + 1
                
                _playerProfile.value = currentProfile.copy(
                    bestScore = newBestScore,
                    totalWinnings = newTotalWinnings,
                    gamesPlayed = newGamesPlayed,
                    lastPlayedDate = System.currentTimeMillis()
                )
                
                _gameState.value = _gameState.value?.copy(
                    gameStatus = GameStatus.WON,
                    score = question.prizeMoney
                )
            } else {
                // Move to next question
                loadQuestion(nextIndex)
            }
        } else {
            // Game over
            val currentProfile = _playerProfile.value ?: PlayerProfile()
            val newGamesPlayed = currentProfile.gamesPlayed + 1
            
            _playerProfile.value = currentProfile.copy(
                gamesPlayed = newGamesPlayed,
                lastPlayedDate = System.currentTimeMillis()
            )
            
            _gameState.value = _gameState.value?.copy(
                gameStatus = GameStatus.LOST
            )
        }
    }

    fun useFiftyFifty() {
        val currentState = _gameState.value ?: return
        if (!currentState.lifelines.fiftyFifty) return

        _gameState.value = currentState.copy(
            lifelines = currentState.lifelines.copy(fiftyFifty = false)
        )
    }

    fun usePhoneFriend() {
        val currentState = _gameState.value ?: return
        if (!currentState.lifelines.phoneFriend) return

        _gameState.value = currentState.copy(
            lifelines = currentState.lifelines.copy(phoneFriend = false)
        )
    }

    fun useAudienceHelp() {
        val currentState = _gameState.value ?: return
        if (!currentState.lifelines.audienceHelp) return

        _gameState.value = currentState.copy(
            lifelines = currentState.lifelines.copy(audienceHelp = false)
        )
    }

    fun quitGame() {
        val currentProfile = _playerProfile.value ?: PlayerProfile()
        val newGamesPlayed = currentProfile.gamesPlayed + 1
        val safeHaven = getSafeHaven()
        
        _playerProfile.value = currentProfile.copy(
            gamesPlayed = newGamesPlayed,
            lastPlayedDate = System.currentTimeMillis()
        )
        
        _gameState.value = _gameState.value?.copy(
            gameStatus = GameStatus.QUIT,
            score = safeHaven
        )
    }

    fun getSafeHaven(): Int {
        val currentIndex = _gameState.value?.currentQuestionIndex ?: 0
        return when {
            currentIndex >= 10 -> 32000  // ₺32,000 safe haven
            currentIndex >= 5 -> 1000    // ₺1,000 safe haven
            else -> 0
        }
    }

    fun formatPrizeMoney(amount: Int): String {
        val currentLanguage = _appSettings.value?.language ?: Language.TURKISH
        return when (amount) {
            1000000 -> when (currentLanguage) {
                Language.TURKISH -> "₺1,000,000"
                Language.CHINESE -> "¥1,000,000"
                Language.SPANISH, Language.GERMAN, Language.FRENCH -> "€1,000,000"
                Language.ARABIC -> "ر.س1,000,000"
                Language.RUSSIAN -> "₽1,000,000"
                Language.HINDI -> "₹1,000,000"
                Language.JAPANESE -> "¥1,000,000"
                Language.KOREAN -> "₩1,000,000"
                Language.PORTUGUESE -> "R$1,000,000"
                Language.VIETNAMESE -> "₫1,000,000"
                else -> "$1,000,000"
            }
            else -> when (currentLanguage) {
                Language.TURKISH -> "₺${String.format("%,d", amount)}"
                Language.CHINESE -> "¥${String.format("%,d", amount)}"
                Language.SPANISH, Language.GERMAN, Language.FRENCH -> "€${String.format("%,d", amount)}"
                Language.ARABIC -> "ر.س${String.format("%,d", amount)}"
                Language.RUSSIAN -> "₽${String.format("%,d", amount)}"
                Language.HINDI -> "₹${String.format("%,d", amount)}"
                Language.JAPANESE -> "¥${String.format("%,d", amount)}"
                Language.KOREAN -> "₩${String.format("%,d", amount)}"
                Language.PORTUGUESE -> "R$${String.format("%,d", amount)}"
                Language.VIETNAMESE -> "₫${String.format("%,d", amount)}"
                else -> "$${String.format("%,d", amount)}"
            }
        }
    }

    fun updatePlayerName(name: String) {
        val currentProfile = _playerProfile.value ?: PlayerProfile()
        _playerProfile.value = currentProfile.copy(name = name)
    }

    fun resetPlayerStats() {
        _playerProfile.value = PlayerProfile(
            name = _playerProfile.value?.name ?: "Yarışmacı"
        )
    }

    fun updateAppSettings(settings: AppSettings) {
        val previousLanguage = _appSettings.value?.language
        _appSettings.value = settings
        
        // If language changed, update questions
        if (previousLanguage != settings.language) {
            updateQuestionsForLanguage(settings.language)
        }
    }
} 