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
        binding.themeTitleText.setTextColor(textColor)

        val isLightTheme = theme == BackgroundTheme.MINIMAL_LIGHT || theme == BackgroundTheme.GRADIENT_GOLD
        val cardTextColor = if (isLightTheme) {
            ContextCompat.getColor(requireContext(), R.color.text_dark)
        } else {
            textColor
        }

        binding.minimalDarkRadio.setTextColor(cardTextColor)
        binding.minimalLightRadio.setTextColor(cardTextColor)
        binding.gradientBlueRadio.setTextColor(cardTextColor)
        binding.gradientPurpleRadio.setTextColor(cardTextColor)
        binding.gradientGoldRadio.setTextColor(cardTextColor)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
