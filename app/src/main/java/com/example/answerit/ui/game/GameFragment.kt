package com.example.answerit.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.answerit.R
import com.example.answerit.data.model.BackgroundTheme
import com.example.answerit.data.model.GameUiState
import com.example.answerit.data.model.Question
import com.example.answerit.databinding.FragmentGameBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by activityViewModels()

    private lateinit var answerButtons: List<MaterialButton>

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

        answerButtons = listOf(
            binding.answerAButton,
            binding.answerBButton,
            binding.answerCButton,
            binding.answerDButton
        )

        setupBackHandler()
        setupClickListeners()
        setupObservers()
        viewModel.startNewGame()
    }

    private fun setupBackHandler() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    viewModel.requestQuit()
                }
            }
        )
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.gameUiState.collect { state ->
                        renderGameUiState(state)
                    }
                }
                launch {
                    viewModel.appSettings.collect { settings ->
                        updateBackgroundTheme(settings.backgroundTheme)
                    }
                }
                launch {
                    viewModel.events.collect { event ->
                        handleUiEvent(event)
                    }
                }
            }
        }
    }

    private fun setupClickListeners() {
        answerButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                viewModel.selectAnswerOption(index)
            }
        }

        binding.confirmButton.setOnClickListener {
            viewModel.submitAnswer()
        }

        binding.quitButton.setOnClickListener {
            viewModel.requestQuit()
        }

        binding.fiftyFiftyButton.setOnClickListener {
            viewModel.useFiftyFifty()
        }

        binding.phoneFriendButton.setOnClickListener {
            viewModel.usePhoneFriend()
        }

        binding.audienceHelpButton.setOnClickListener {
            viewModel.useAudienceHelp()
        }
    }

    private fun renderGameUiState(state: GameUiState) {
        val question = state.currentQuestion
        if (question != null) {
            binding.questionText.text = question.question
            binding.answerAButton.text = "${getString(R.string.answer_a)} ${question.options[0]}"
            binding.answerBButton.text = "${getString(R.string.answer_b)} ${question.options[1]}"
            binding.answerCButton.text = "${getString(R.string.answer_c)} ${question.options[2]}"
            binding.answerDButton.text = "${getString(R.string.answer_d)} ${question.options[3]}"
        }

        val questionNumber = state.questionIndex + 1
        binding.questionNumberText.text = "${getString(R.string.question)} $questionNumber / ${state.totalQuestions}"
        binding.prizeMoneyText.text = getString(
            R.string.current_prize,
            viewModel.formatPrizeMoney(state.currentPrize)
        )

        val theme = viewModel.appSettings.value.backgroundTheme
        updateLifelineButton(binding.fiftyFiftyButton, state.lifelines.fiftyFifty, theme)
        updateLifelineButton(binding.phoneFriendButton, state.lifelines.phoneFriend, theme)
        updateLifelineButton(binding.audienceHelpButton, state.lifelines.audienceHelp, theme)

        val primaryColor = ContextCompat.getColor(requireContext(), theme.secondaryButtonBgRes)
        val normalTextColor = ContextCompat.getColor(requireContext(), theme.secondaryButtonTextRes)
        val normalStrokeColor = ContextCompat.getColor(requireContext(), theme.secondaryButtonStrokeRes)
        val selectedBgColor = if (theme == BackgroundTheme.GRADIENT_GOLD) {
            ContextCompat.getColor(requireContext(), R.color.gold_primary_button)
        } else {
            ContextCompat.getColor(requireContext(), R.color.gold)
        }
        val selectedTextColor = if (theme == BackgroundTheme.GRADIENT_GOLD) {
            ContextCompat.getColor(requireContext(), R.color.white)
        } else {
            ContextCompat.getColor(requireContext(), R.color.black)
        }

        answerButtons.forEachIndexed { index, button ->
            if (state.hiddenOptionIndices.contains(index)) {
                button.visibility = View.INVISIBLE
                button.isEnabled = false
            } else {
                button.visibility = View.VISIBLE
                button.isEnabled = true
                if (state.selectedOptionIndex == index) {
                    button.backgroundTintList = android.content.res.ColorStateList.valueOf(selectedBgColor)
                    button.setTextColor(selectedTextColor)
                    button.strokeWidth = 0
                } else {
                    if (theme.isLight) {
                        button.backgroundTintList = android.content.res.ColorStateList.valueOf(primaryColor)
                        button.setTextColor(normalTextColor)
                        button.strokeColor = android.content.res.ColorStateList.valueOf(normalStrokeColor)
                        button.strokeWidth = (1.5f * resources.displayMetrics.density).toInt()
                    } else {
                        val darkPrimary = ContextCompat.getColor(requireContext(), R.color.minimal_dark_primary)
                        button.backgroundTintList = android.content.res.ColorStateList.valueOf(darkPrimary)
                        button.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                        button.strokeWidth = 0
                    }
                }
            }
        }
    }

    private fun updateLifelineButton(button: MaterialButton, isAvailable: Boolean, theme: BackgroundTheme) {
        button.isEnabled = isAvailable
        if (isAvailable) {
            val lifelineBg = ContextCompat.getColor(requireContext(), theme.lifelineBgRes)
            val lifelineText = ContextCompat.getColor(requireContext(), theme.lifelineTextRes)
            button.backgroundTintList = android.content.res.ColorStateList.valueOf(lifelineBg)
            button.setTextColor(lifelineText)
            button.iconTint = android.content.res.ColorStateList.valueOf(lifelineText)
            button.strokeWidth = 0
            button.alpha = 1.0f
            button.elevation = (3f * resources.displayMetrics.density)
        } else {
            val disabledBg = ContextCompat.getColor(requireContext(), R.color.minimal_dark_surface)
            val disabledText = ContextCompat.getColor(requireContext(), R.color.text_secondary)
            val disabledStroke = ContextCompat.getColor(requireContext(), R.color.stroke_dark)
            button.backgroundTintList = android.content.res.ColorStateList.valueOf(disabledBg)
            button.setTextColor(disabledText)
            button.iconTint = android.content.res.ColorStateList.valueOf(disabledText)
            button.strokeColor = android.content.res.ColorStateList.valueOf(disabledStroke)
            button.strokeWidth = (1.5f * resources.displayMetrics.density).toInt()
            button.alpha = 0.38f
            button.elevation = 0f
        }
    }

    private fun handleUiEvent(event: GameUiEvent) {
        when (event) {
            is GameUiEvent.ShowGameResult -> showGameResult(event.won, event.prize)
            is GameUiEvent.ShowPhoneFriendHint -> showPhoneFriendDialog(event.hint)
            is GameUiEvent.ShowAudienceHelp -> showAudienceDialog(event.percentages)
            is GameUiEvent.ShowQuitDialog -> showQuitConfirmationDialog(event.safeHavenAmount)
        }
    }

    private fun updateBackgroundTheme(theme: BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)

        val cardBg = ContextCompat.getColor(requireContext(), theme.cardBgColorRes)
        val cardStroke = ContextCompat.getColor(requireContext(), theme.cardStrokeColorRes)
        val cardTextColor = ContextCompat.getColor(requireContext(), theme.cardTextColorRes)
        val accentColor = ContextCompat.getColor(requireContext(), theme.accentColorRes)

        binding.questionNumberText.setTextColor(cardTextColor)
        binding.prizeMoneyText.setTextColor(accentColor)
        binding.prizeIcon.imageTintList = android.content.res.ColorStateList.valueOf(accentColor)

        // Question Card
        val questionCardShape = android.graphics.drawable.GradientDrawable().apply {
            setColor(cardBg)
            cornerRadius = 16 * resources.displayMetrics.density
            setStroke((1.5f * resources.displayMetrics.density).toInt(), cardStroke)
        }
        binding.questionText.background = questionCardShape
        binding.questionText.setTextColor(cardTextColor)

        // Pill Badges (Question number & Prize pill)
        val pillShape = android.graphics.drawable.GradientDrawable().apply {
            setColor(cardBg)
            cornerRadius = 20 * resources.displayMetrics.density
            setStroke((1.2f * resources.displayMetrics.density).toInt(), cardStroke)
        }
        binding.questionNumberText.background = pillShape
        binding.prizeContainer.background = pillShape

        // Lifelines
        val state = viewModel.gameUiState.value
        updateLifelineButton(binding.fiftyFiftyButton, state.lifelines.fiftyFifty, theme)
        updateLifelineButton(binding.phoneFriendButton, state.lifelines.phoneFriend, theme)
        updateLifelineButton(binding.audienceHelpButton, state.lifelines.audienceHelp, theme)
    }

    private fun showPhoneFriendDialog(answer: String) {
        val hint = getString(R.string.phone_friend_hint, answer)
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.phone_friend_title))
            .setMessage(hint)
            .setPositiveButton(getString(R.string.thank_you)) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun showAudienceDialog(percentages: List<Int>) {
        val audienceText = """
            ${getString(R.string.audience_votes)}
            
            ${getString(R.string.audience_option, "A", percentages.getOrElse(0) { 0 })}
            ${getString(R.string.audience_option, "B", percentages.getOrElse(1) { 0 })}
            ${getString(R.string.audience_option, "C", percentages.getOrElse(2) { 0 })}
            ${getString(R.string.audience_option, "D", percentages.getOrElse(3) { 0 })}
        """.trimIndent()

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.audience_help_title))
            .setMessage(audienceText)
            .setPositiveButton(getString(R.string.understood)) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun showQuitConfirmationDialog(safeHavenAmount: String) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.quit_game_title))
            .setMessage(getString(R.string.quit_game_message, safeHavenAmount))
            .setPositiveButton(getString(R.string.yes_quit)) { _, _ -> viewModel.confirmQuit() }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
