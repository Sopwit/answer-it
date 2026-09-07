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
        val cardBg = ContextCompat.getColor(requireContext(), theme.cardBgColorRes)
        val cardTextColor = ContextCompat.getColor(requireContext(), theme.cardTextColorRes)
        val accentColor = ContextCompat.getColor(requireContext(), theme.accentColorRes)
        val secondaryBtnBg = ContextCompat.getColor(requireContext(), theme.secondaryButtonBgRes)
        val secondaryBtnText = ContextCompat.getColor(requireContext(), theme.secondaryButtonTextRes)
        val secondaryBtnStroke = ContextCompat.getColor(requireContext(), theme.secondaryButtonStrokeRes)

        binding.settingsTitleText.setTextColor(textColor)

        // Buttons
        val buttons = listOf(binding.themeButton, binding.languageButton, binding.backButton)
        buttons.forEach { btn ->
            btn.backgroundTintList = android.content.res.ColorStateList.valueOf(secondaryBtnBg)
            btn.setTextColor(secondaryBtnText)
            btn.iconTint = android.content.res.ColorStateList.valueOf(secondaryBtnText)
            btn.strokeColor = android.content.res.ColorStateList.valueOf(secondaryBtnStroke)
            btn.strokeWidth = (1.5f * resources.displayMetrics.density).toInt()
        }

        // Preferences Card & Switches
        binding.preferencesCard.setCardBackgroundColor(cardBg)
        binding.preferencesTitleText.setTextColor(accentColor)
        binding.soundSwitch.setTextColor(cardTextColor)
        binding.vibrationSwitch.setTextColor(cardTextColor)

        // Legal Cards
        binding.userAgreementCard.setCardBackgroundColor(cardBg)
        binding.userAgreementText.setTextColor(accentColor)
        binding.userAgreementIcon.imageTintList = android.content.res.ColorStateList.valueOf(accentColor)

        binding.privacyPolicyCard.setCardBackgroundColor(cardBg)
        binding.privacyPolicyText.setTextColor(accentColor)
        binding.privacyPolicyIcon.imageTintList = android.content.res.ColorStateList.valueOf(accentColor)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
