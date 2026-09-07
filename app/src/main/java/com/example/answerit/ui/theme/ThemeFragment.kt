package com.example.answerit.ui.theme

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
import com.example.answerit.databinding.FragmentThemeBinding
import com.example.answerit.ui.game.GameViewModel
import kotlinx.coroutines.launch

class ThemeFragment : Fragment() {

    private var _binding: FragmentThemeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThemeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        binding.minimalDarkRadio.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) updateTheme(BackgroundTheme.MINIMAL_DARK)
        }
        binding.minimalLightRadio.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) updateTheme(BackgroundTheme.MINIMAL_LIGHT)
        }
        binding.gradientBlueRadio.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) updateTheme(BackgroundTheme.GRADIENT_BLUE)
        }
        binding.gradientPurpleRadio.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) updateTheme(BackgroundTheme.GRADIENT_PURPLE)
        }
        binding.gradientGoldRadio.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) updateTheme(BackgroundTheme.GRADIENT_GOLD)
        }

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.appSettings.collect { settings ->
                    when (settings.backgroundTheme) {
                        BackgroundTheme.MINIMAL_DARK -> binding.minimalDarkRadio.isChecked = true
                        BackgroundTheme.MINIMAL_LIGHT -> binding.minimalLightRadio.isChecked = true
                        BackgroundTheme.GRADIENT_BLUE -> binding.gradientBlueRadio.isChecked = true
                        BackgroundTheme.GRADIENT_PURPLE -> binding.gradientPurpleRadio.isChecked = true
                        BackgroundTheme.GRADIENT_GOLD -> binding.gradientGoldRadio.isChecked = true
                    }
                    updateBackgroundTheme(settings.backgroundTheme)
                }
            }
        }
    }

    private fun updateTheme(theme: BackgroundTheme) {
        val currentSettings = viewModel.appSettings.value
        if (currentSettings.backgroundTheme != theme) {
            viewModel.updateAppSettings(currentSettings.copy(backgroundTheme = theme))
        }
    }

    private fun updateBackgroundTheme(theme: BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)

        val textColor = ContextCompat.getColor(requireContext(), theme.textColorRes)
        val cardBg = ContextCompat.getColor(requireContext(), theme.cardBgColorRes)
        val accentColor = ContextCompat.getColor(requireContext(), theme.accentColorRes)
        val secondaryBtnBg = ContextCompat.getColor(requireContext(), theme.secondaryButtonBgRes)
        val secondaryBtnText = ContextCompat.getColor(requireContext(), theme.secondaryButtonTextRes)
        val secondaryBtnStroke = ContextCompat.getColor(requireContext(), theme.secondaryButtonStrokeRes)

        binding.themeTitleText.setTextColor(textColor)
        binding.themeCard.setCardBackgroundColor(cardBg)

        val radioButtons = listOf(
            binding.minimalDarkRadio,
            binding.minimalLightRadio,
            binding.gradientBlueRadio,
            binding.gradientPurpleRadio,
            binding.gradientGoldRadio
        )

        radioButtons.forEach { radio ->
            radio.setTextColor(textColor)
            radio.buttonTintList = android.content.res.ColorStateList.valueOf(accentColor)
        }

        binding.backButton.backgroundTintList = android.content.res.ColorStateList.valueOf(secondaryBtnBg)
        binding.backButton.setTextColor(secondaryBtnText)
        binding.backButton.iconTint = android.content.res.ColorStateList.valueOf(secondaryBtnText)
        binding.backButton.strokeColor = android.content.res.ColorStateList.valueOf(secondaryBtnStroke)
        binding.backButton.strokeWidth = (1.5f * resources.displayMetrics.density).toInt()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
