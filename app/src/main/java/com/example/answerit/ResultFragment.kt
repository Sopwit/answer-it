package com.example.answerit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.answerit.R
import com.example.answerit.databinding.FragmentResultBinding

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
        updateResultDisplay()
    }

    private fun setupObservers() {
        viewModel.gameState.observe(viewLifecycleOwner) { gameState ->
            updateResultDisplay()
        }

        viewModel.appSettings.observe(viewLifecycleOwner) { settings ->
            updateBackgroundTheme(settings.backgroundTheme)
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

    private fun updateResultDisplay() {
        val gameState = viewModel.gameState.value ?: return
        val currentQuestion = viewModel.currentQuestion.value
        
        // Update result title and message
        when (gameState.gameStatus) {
            com.example.answerit.data.GameStatus.WON -> {
                binding.resultTitleText.text = getString(R.string.result_won_title)
                binding.resultMessageText.text = getString(R.string.result_won_message)
                binding.resultIcon.setImageResource(android.R.drawable.ic_dialog_info)
            }
            com.example.answerit.data.GameStatus.LOST -> {
                binding.resultTitleText.text = getString(R.string.result_lost_title)
                binding.resultMessageText.text = getString(R.string.result_lost_message)
                binding.resultIcon.setImageResource(android.R.drawable.ic_dialog_alert)
            }
            com.example.answerit.data.GameStatus.QUIT -> {
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

        // Update prize won
        val prizeWon = when (gameState.gameStatus) {
            com.example.answerit.data.GameStatus.WON -> gameState.score
            com.example.answerit.data.GameStatus.LOST -> gameState.currentPrize
            com.example.answerit.data.GameStatus.QUIT -> viewModel.getSafeHaven()
            else -> 0
        }
        binding.prizeWonText.text = getString(R.string.prize_won, viewModel.formatPrizeMoney(prizeWon))

        // Update statistics
        val reachedQuestion = gameState.currentQuestionIndex + 1
        binding.reachedQuestionText.text = "$reachedQuestion / 15"

        val usedLifelines = 3 - (if (gameState.lifelines.fiftyFifty) 1 else 0) - 
                           (if (gameState.lifelines.phoneFriend) 1 else 0) - 
                           (if (gameState.lifelines.audienceHelp) 1 else 0)
        binding.usedLifelinesText.text = usedLifelines.toString()

        val safeHaven = viewModel.getSafeHaven()
        binding.safeHavenText.text = viewModel.formatPrizeMoney(safeHaven)
    }

    private fun updateBackgroundTheme(theme: com.example.answerit.data.BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)
        
        // Update text colors based on theme
        val textColor = resources.getColor(theme.textColorRes, null)
        val isLightTheme = theme == com.example.answerit.data.BackgroundTheme.MINIMAL_LIGHT || theme == com.example.answerit.data.BackgroundTheme.GRADIENT_GOLD
        val cardTextColor = if (isLightTheme) resources.getColor(R.color.white, null) else textColor

        binding.resultTitleText.setTextColor(textColor)
        binding.resultMessageText.setTextColor(cardTextColor)
        binding.prizeWonText.setTextColor(cardTextColor)
        binding.reachedQuestionText.setTextColor(cardTextColor)
        binding.usedLifelinesText.setTextColor(cardTextColor)
        binding.safeHavenText.setTextColor(cardTextColor)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 