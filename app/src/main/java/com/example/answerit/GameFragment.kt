package com.example.answerit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.answerit.R
import com.example.answerit.data.GameStatus
import com.example.answerit.databinding.FragmentGameBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import android.os.Vibrator
import android.os.VibrationEffect
import android.content.Context
import android.media.MediaPlayer

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by activityViewModels()

    private var selectedAnswer: Int = -1
    private var lastAppSettings: com.example.answerit.data.AppSettings? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        setupClickListeners()
        viewModel.startNewGame()
    }

    private fun setupObservers() {
        viewModel.currentQuestion.observe(viewLifecycleOwner) { question ->
            question?.let { updateQuestionUI(it) }
        }

        viewModel.gameState.observe(viewLifecycleOwner) { gameState ->
            updateGameStateUI(gameState)
        }

        viewModel.appSettings.observe(viewLifecycleOwner) { settings ->
            updateBackgroundTheme(settings.backgroundTheme)
            lastAppSettings = settings
        }
    }

    private fun setupClickListeners() {
        binding.answerAButton.setOnClickListener { selectAnswer(0) }
        binding.answerBButton.setOnClickListener { selectAnswer(1) }
        binding.answerCButton.setOnClickListener { selectAnswer(2) }
        binding.answerDButton.setOnClickListener { selectAnswer(3) }

        binding.confirmButton.setOnClickListener {
            if (selectedAnswer != -1) {
                viewModel.submitAnswer(selectedAnswer)
            }
        }

        binding.quitButton.setOnClickListener {
            showQuitConfirmationDialog()
        }

        binding.fiftyFiftyButton.setOnClickListener {
            viewModel.useFiftyFifty()
            applyFiftyFifty()
        }

        binding.phoneFriendButton.setOnClickListener {
            viewModel.usePhoneFriend()
            showPhoneFriendHint()
        }

        binding.audienceHelpButton.setOnClickListener {
            viewModel.useAudienceHelp()
            showAudienceHelp()
        }
    }

    private fun updateQuestionUI(question: com.example.answerit.data.Question) {
        binding.questionText.text = question.question
        binding.answerAButton.text = getString(R.string.answer_a) + " ${question.options[0]}"
        binding.answerBButton.text = getString(R.string.answer_b) + " ${question.options[1]}"
        binding.answerCButton.text = getString(R.string.answer_c) + " ${question.options[2]}"
        binding.answerDButton.text = getString(R.string.answer_d) + " ${question.options[3]}"

        // Reset button colors and visibility
        resetAnswerButtonColors()
        resetAnswerButtonVisibility()
        selectedAnswer = -1
    }

    private fun updateGameStateUI(gameState: com.example.answerit.data.GameState) {
        val questionNumber = gameState.currentQuestionIndex + 1
        binding.questionNumberText.text = getString(R.string.question) + " $questionNumber / 15"
        binding.prizeMoneyText.text = getString(R.string.current_prize, viewModel.formatPrizeMoney(gameState.currentPrize))

        // Update lifeline buttons
        binding.fiftyFiftyButton.isEnabled = gameState.lifelines.fiftyFifty
        binding.phoneFriendButton.isEnabled = gameState.lifelines.phoneFriend
        binding.audienceHelpButton.isEnabled = gameState.lifelines.audienceHelp

        // Check game status
        when (gameState.gameStatus) {
            GameStatus.WON -> {
                handleCorrectAnswerFeedback()
                showGameResult(true, gameState.score)
            }
            GameStatus.LOST -> {
                handleWrongAnswerFeedback()
                showGameResult(false, gameState.currentPrize)
            }
            GameStatus.QUIT -> {
                showGameResult(false, viewModel.getSafeHaven())
            }
            else -> {}
        }
    }

    private fun updateBackgroundTheme(theme: com.example.answerit.data.BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)
    }

    private fun selectAnswer(answerIndex: Int) {
        selectedAnswer = answerIndex
        resetAnswerButtonColors()
        
        when (answerIndex) {
            0 -> binding.answerAButton.setBackgroundColor(resources.getColor(R.color.gold, null))
            1 -> binding.answerBButton.setBackgroundColor(resources.getColor(R.color.gold, null))
            2 -> binding.answerCButton.setBackgroundColor(resources.getColor(R.color.gold, null))
            3 -> binding.answerDButton.setBackgroundColor(resources.getColor(R.color.gold, null))
        }
    }

    private fun resetAnswerButtonColors() {
        binding.answerAButton.setBackgroundColor(resources.getColor(R.color.minimal_dark_primary, null))
        binding.answerBButton.setBackgroundColor(resources.getColor(R.color.minimal_dark_primary, null))
        binding.answerCButton.setBackgroundColor(resources.getColor(R.color.minimal_dark_primary, null))
        binding.answerDButton.setBackgroundColor(resources.getColor(R.color.minimal_dark_primary, null))
    }

    private fun resetAnswerButtonVisibility() {
        binding.answerAButton.visibility = View.VISIBLE
        binding.answerBButton.visibility = View.VISIBLE
        binding.answerCButton.visibility = View.VISIBLE
        binding.answerDButton.visibility = View.VISIBLE
    }

    private fun applyFiftyFifty() {
        val question = viewModel.currentQuestion.value ?: return
        val wrongOptions = question.options.indices.filter { it != question.correctAnswer }
        val optionsToHide = wrongOptions.shuffled().take(2)

        optionsToHide.forEach { index ->
            when (index) {
                0 -> binding.answerAButton.visibility = View.INVISIBLE
                1 -> binding.answerBButton.visibility = View.INVISIBLE
                2 -> binding.answerCButton.visibility = View.INVISIBLE
                3 -> binding.answerDButton.visibility = View.INVISIBLE
            }
        }
    }

    private fun showPhoneFriendHint() {
        val question = viewModel.currentQuestion.value ?: return
        val correctAnswer = question.correctAnswer
        val hint = getString(R.string.phone_friend_hint, question.options[correctAnswer])

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.phone_friend_title))
            .setMessage(hint)
            .setPositiveButton(getString(R.string.thank_you)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun showAudienceHelp() {
        val question = viewModel.currentQuestion.value ?: return
        val correctAnswer = question.correctAnswer
        
        // Generate fake audience percentages
        val percentages = mutableListOf(0, 0, 0, 0)
        percentages[correctAnswer] = (40..60).random() // Correct answer gets 40-60%
        
        val remaining = 100 - percentages[correctAnswer]
        val wrongOptions = percentages.indices.filter { it != correctAnswer }
        val remainingPerOption = remaining / wrongOptions.size
        
        wrongOptions.forEach { index ->
            percentages[index] = remainingPerOption
        }
        
        // Add some randomness to remaining
        if (wrongOptions.isNotEmpty()) {
            percentages[wrongOptions.first()] += remaining % wrongOptions.size
        }

        val audienceText = """
            ${getString(R.string.audience_votes)}
            
            ${getString(R.string.audience_option, "A", percentages[0])}
            ${getString(R.string.audience_option, "B", percentages[1])}
            ${getString(R.string.audience_option, "C", percentages[2])}
            ${getString(R.string.audience_option, "D", percentages[3])}
        """.trimIndent()

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.audience_help_title))
            .setMessage(audienceText)
            .setPositiveButton(getString(R.string.understood)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun showQuitConfirmationDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.quit_game_title))
            .setMessage(getString(R.string.quit_game_message, viewModel.formatPrizeMoney(viewModel.getSafeHaven())))
            .setPositiveButton(getString(R.string.yes_quit)) { _, _ ->
                viewModel.quitGame()
            }
            .setNegativeButton(getString(R.string.no_continue), null)
            .show()
    }

    private fun showGameResult(won: Boolean, prize: Int) {
        val title = if (won) getString(R.string.congratulations) else getString(R.string.game_over)
        val message = if (won) {
            getString(R.string.game_won_message, viewModel.formatPrizeMoney(prize))
        } else {
            getString(R.string.game_lost_message, viewModel.formatPrizeMoney(prize))
        }

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(getString(R.string.back_to_main_menu)) { _, _ ->
                findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
            }
            .setCancelable(false)
            .show()
    }

    private fun handleWrongAnswerFeedback() {
        val settings = lastAppSettings ?: return
        val ctx = context ?: return
        // Vibration
        if (settings.vibrationEnabled) {
            try {
                val vibrator = ctx.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    @Suppress("DEPRECATION")
                    vibrator.vibrate(300)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        // Sound Effect
        if (settings.soundEnabled) {
            try {
                val mediaPlayer = MediaPlayer.create(ctx, R.raw.wrong_answer)
                if (mediaPlayer != null) {
                    mediaPlayer.setOnCompletionListener { it.release() }
                    mediaPlayer.start()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun handleCorrectAnswerFeedback() {
        val settings = lastAppSettings ?: return
        val ctx = context ?: return
        if (settings.soundEnabled) {
            try {
                val mediaPlayer = MediaPlayer.create(ctx, R.raw.correct_answer)
                if (mediaPlayer != null) {
                    mediaPlayer.setOnCompletionListener { it.release() }
                    mediaPlayer.start()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 