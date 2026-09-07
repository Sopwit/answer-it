package com.example.answerit.ui.settings

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
import com.example.answerit.data.model.AppSettings
import com.example.answerit.data.model.BackgroundTheme
import com.example.answerit.databinding.FragmentSettingsBinding
import com.example.answerit.ui.game.GameViewModel
import kotlinx.coroutines.launch

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
        setupObservers()
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.appSettings.collect { settings ->
                    updateSettingsDisplay(settings)
                }
            }
        }
    }

    private fun setupClickListeners() {
        binding.themeButton.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_themeFragment)
        }

        binding.languageButton.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_languageFragment)
        }

        binding.soundSwitch.setOnCheckedChangeListener { _, isChecked ->
            updateSoundEnabled(isChecked)
        }
        binding.vibrationSwitch.setOnCheckedChangeListener { _, isChecked ->
            updateVibrationEnabled(isChecked)
        }

        binding.userAgreementCard.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_userAgreementFragment)
        }
        binding.privacyPolicyCard.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_privacyPolicyFragment)
        }

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun updateSettingsDisplay(settings: AppSettings) {
        binding.soundSwitch.isChecked = settings.soundEnabled
        binding.vibrationSwitch.isChecked = settings.vibrationEnabled
        updateBackgroundTheme(settings.backgroundTheme)
    }

    private fun updateSoundEnabled(enabled: Boolean) {
        val currentSettings = viewModel.appSettings.value
        if (currentSettings.soundEnabled != enabled) {
            viewModel.updateAppSettings(currentSettings.copy(soundEnabled = enabled))
        }
    }

    private fun updateVibrationEnabled(enabled: Boolean) {
        val currentSettings = viewModel.appSettings.value
        if (currentSettings.vibrationEnabled != enabled) {
            viewModel.updateAppSettings(currentSettings.copy(vibrationEnabled = enabled))
        }
    }

    private fun updateBackgroundTheme(theme: BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)

        val textColor = ContextCompat.getColor(requireContext(), theme.textColorRes)
        binding.settingsTitleText.setTextColor(textColor)

        val isLightTheme = theme == BackgroundTheme.MINIMAL_LIGHT || theme == BackgroundTheme.GRADIENT_GOLD
        val cardTextColor = if (isLightTheme) {
            ContextCompat.getColor(requireContext(), R.color.text_dark)
        } else {
            textColor
        }

        binding.preferencesTitleText.setTextColor(cardTextColor)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
