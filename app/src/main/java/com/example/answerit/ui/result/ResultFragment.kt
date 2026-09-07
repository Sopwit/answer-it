package com.example.answerit.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.answerit.R
import com.example.answerit.data.model.BackgroundTheme
import com.example.answerit.data.model.GameStatus
import com.example.answerit.data.model.GameUiState
import com.example.answerit.databinding.FragmentResultBinding
import com.example.answerit.ui.game.GameViewModel
import kotlinx.coroutines.launch

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        setupClickListeners()
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.gameUiState.collect { state ->
                        updateResultDisplay(state)
                    }
                }
                launch {
                    viewModel.appSettings.collect { settings ->
                        updateBackgroundTheme(settings.backgroundTheme)
                    }
                }
            }
        }
    }

    private fun setupClickListeners() {
        binding.playAgainButton.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
        }

        binding.backToMenuButton.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
        }
    }

    private fun updateResultDisplay(state: GameUiState) {
        when (state.gameStatus) {
            GameStatus.WON -> {
                binding.resultTitleText.text = getString(R.string.result_won_title)
                binding.resultMessageText.text = getString(R.string.result_won_message)
                binding.resultIcon.setImageResource(android.R.drawable.ic_dialog_info)
            }
            GameStatus.LOST -> {
                binding.resultTitleText.text = getString(R.string.result_lost_title)
                binding.resultMessageText.text = getString(R.string.result_lost_message)
                binding.resultIcon.setImageResource(android.R.drawable.ic_dialog_alert)
            }
            GameStatus.QUIT -> {
                binding.resultTitleText.text = getString(R.string.result_quit_title)
                binding.resultMessageText.text = getString(R.string.result_quit_message)
                binding.resultIcon.setImageResource(android.R.drawable.ic_menu_send)
            }
            else -> {
                binding.resultTitleText.text = getString(R.string.result_default_title)
                binding.resultMessageText.text = getString(R.string.result_default_message)
                binding.resultIcon.setImageResource(android.R.drawable.ic_dialog_info)
            }
        }

        binding.prizeWonText.text = getString(
            R.string.prize_won,
            viewModel.formatPrizeMoney(state.score)
        )

        val reachedQuestion = state.questionIndex + 1
        binding.reachedQuestionText.text = "$reachedQuestion / ${state.totalQuestions}"

        val usedLifelines = 3 - (if (state.lifelines.fiftyFifty) 1 else 0) -
                (if (state.lifelines.phoneFriend) 1 else 0) -
                (if (state.lifelines.audienceHelp) 1 else 0)
        binding.usedLifelinesText.text = usedLifelines.toString()

        binding.safeHavenText.text = viewModel.formatPrizeMoney(state.safeHaven)
    }

    private fun updateBackgroundTheme(theme: BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)

        val textColor = ContextCompat.getColor(requireContext(), theme.textColorRes)
        val subTextColor = ContextCompat.getColor(requireContext(), theme.subTextColorRes)
        val cardBg = ContextCompat.getColor(requireContext(), theme.cardBgColorRes)
        val cardStroke = ContextCompat.getColor(requireContext(), theme.cardStrokeColorRes)
        val cardTextColor = ContextCompat.getColor(requireContext(), theme.cardTextColorRes)
        val accentColor = ContextCompat.getColor(requireContext(), theme.accentColorRes)
        val primaryBtnBg = ContextCompat.getColor(requireContext(), theme.primaryButtonBgRes)
        val primaryBtnText = ContextCompat.getColor(requireContext(), theme.primaryButtonTextRes)
        val secondaryBtnBg = ContextCompat.getColor(requireContext(), theme.secondaryButtonBgRes)
        val secondaryBtnText = ContextCompat.getColor(requireContext(), theme.secondaryButtonTextRes)
        val secondaryBtnStroke = ContextCompat.getColor(requireContext(), theme.secondaryButtonStrokeRes)

        binding.resultTitleText.setTextColor(textColor)
        binding.resultCard.setCardBackgroundColor(cardBg)
        binding.resultIcon.imageTintList = android.content.res.ColorStateList.valueOf(accentColor)
        binding.resultMessageText.setTextColor(cardTextColor)
        binding.prizeWonText.setTextColor(accentColor)

        val statsShape = android.graphics.drawable.GradientDrawable().apply {
            setColor(secondaryBtnBg)
            cornerRadius = 14 * resources.displayMetrics.density
            setStroke((1.2f * resources.displayMetrics.density).toInt(), cardStroke)
        }
        binding.statsBox.background = statsShape

        binding.reachedQuestionLabel.setTextColor(subTextColor)
        binding.usedLifelinesLabel.setTextColor(subTextColor)
        binding.safeHavenLabel.setTextColor(subTextColor)

        binding.reachedQuestionText.setTextColor(cardTextColor)
        binding.usedLifelinesText.setTextColor(cardTextColor)
        binding.safeHavenText.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))

        binding.playAgainButton.backgroundTintList = android.content.res.ColorStateList.valueOf(primaryBtnBg)
        binding.playAgainButton.setTextColor(primaryBtnText)
        binding.playAgainButton.iconTint = android.content.res.ColorStateList.valueOf(primaryBtnText)

        binding.backToMenuButton.backgroundTintList = android.content.res.ColorStateList.valueOf(secondaryBtnBg)
        binding.backToMenuButton.setTextColor(secondaryBtnText)
        binding.backToMenuButton.iconTint = android.content.res.ColorStateList.valueOf(secondaryBtnText)
        binding.backToMenuButton.strokeColor = android.content.res.ColorStateList.valueOf(secondaryBtnStroke)
        binding.backToMenuButton.strokeWidth = (1.5f * resources.displayMetrics.density).toInt()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
