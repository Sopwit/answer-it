package com.example.answerit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.answerit.data.AppSettings
import com.example.answerit.data.BackgroundTheme
import com.example.answerit.data.Language
import com.example.answerit.data.LanguageManager
import com.example.answerit.databinding.FragmentSettingsBinding
import com.example.answerit.R

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by activityViewModels()
    private lateinit var languageManager: LanguageManager

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

        languageManager = LanguageManager(requireContext())
        setupObservers()
        setupClickListeners()
    }

    private fun setupObservers() {
        viewModel.appSettings.observe(viewLifecycleOwner) { settings ->
            updateSettingsDisplay(settings)
        }
    }

    private fun setupClickListeners() {
        // Theme selection
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

        // Language selection
        binding.languageButton.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_languageFragment)
        }

        // Preferences (Switches)
        binding.soundSwitch.setOnCheckedChangeListener { _, isChecked ->
            updateSoundEnabled(isChecked)
        }
        binding.vibrationSwitch.setOnCheckedChangeListener { _, isChecked ->
            updateVibrationEnabled(isChecked)
        }

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        // User Agreement click
        binding.userAgreementCard.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_userAgreementFragment)
        }
        // Privacy Policy click
        binding.privacyPolicyCard.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_privacyPolicyFragment)
        }
    }

    private fun updateSettingsDisplay(settings: AppSettings) {
        // Update theme radio buttons
        when (settings.backgroundTheme) {
            BackgroundTheme.MINIMAL_DARK -> binding.minimalDarkRadio.isChecked = true
            BackgroundTheme.MINIMAL_LIGHT -> binding.minimalLightRadio.isChecked = true
            BackgroundTheme.GRADIENT_BLUE -> binding.gradientBlueRadio.isChecked = true
            BackgroundTheme.GRADIENT_PURPLE -> binding.gradientPurpleRadio.isChecked = true
            BackgroundTheme.GRADIENT_GOLD -> binding.gradientGoldRadio.isChecked = true
        }

        // Update switches
        binding.soundSwitch.isChecked = settings.soundEnabled
        binding.vibrationSwitch.isChecked = settings.vibrationEnabled

        // Update background theme
        updateBackgroundTheme(settings.backgroundTheme)
    }

    private fun updateTheme(theme: BackgroundTheme) {
        val currentSettings = viewModel.appSettings.value ?: AppSettings()
        val newSettings = currentSettings.copy(backgroundTheme = theme)
        viewModel.updateAppSettings(newSettings)
    }

    private fun updateSoundEnabled(enabled: Boolean) {
        val currentSettings = viewModel.appSettings.value ?: AppSettings()
        val newSettings = currentSettings.copy(soundEnabled = enabled)
        viewModel.updateAppSettings(newSettings)
    }
    private fun updateVibrationEnabled(enabled: Boolean) {
        val currentSettings = viewModel.appSettings.value ?: AppSettings()
        val newSettings = currentSettings.copy(vibrationEnabled = enabled)
        viewModel.updateAppSettings(newSettings)
    }

    private fun updateLanguage(language: Language) {
        val currentSettings = viewModel.appSettings.value ?: AppSettings()
        val newSettings = currentSettings.copy(language = language)
        viewModel.updateAppSettings(newSettings)
        
        // Update the app's language
        languageManager.setLanguage(language)
        
        // Note: Questions will be updated automatically through the ViewModel
        // when the language setting changes
    }

    private fun updateBackgroundTheme(theme: BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)
        
        // Update text colors based on theme
        val textColor = resources.getColor(theme.textColorRes, null)
        binding.settingsTitleText.setTextColor(textColor)

        // Kart içi başlık ve seçenekler için özel renk (açık temada beyaz)
        val isLightTheme = theme == BackgroundTheme.MINIMAL_LIGHT || theme == BackgroundTheme.GRADIENT_GOLD
        val cardTextColor = if (isLightTheme) resources.getColor(R.color.white, null) else textColor

        // Tema kartı başlığı
        binding.themeTitleText.setTextColor(cardTextColor)
        // Tema seçenekleri
        binding.minimalDarkRadio.setTextColor(cardTextColor)
        binding.minimalLightRadio.setTextColor(cardTextColor)
        binding.gradientBlueRadio.setTextColor(cardTextColor)
        binding.gradientPurpleRadio.setTextColor(cardTextColor)
        binding.gradientGoldRadio.setTextColor(cardTextColor)

        // Dil kartı başlığı
        // binding.languageTitleText.setTextColor(cardTextColor) // Remove this line, view no longer exists
        // Dil seçenekleri
        // This section is removed as per the edit hint to remove all logic related to language radio buttons.

        // Tercihler kartı başlığı
        binding.preferencesTitleText.setTextColor(cardTextColor)
        // Tercihler seçenekleri
        // (Switchlerin yanındaki TextView'lar doğrudan binding ile erişilemiyorsa, gerekirse ek id verilebilir)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Show info dialog for user agreement and privacy policy
    private fun showInfoDialog(title: String, message: String) {
        val dialog = androidx.appcompat.app.AlertDialog.Builder(requireContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(android.R.string.ok, null)
            .create()
        dialog.show()
    }
} 
