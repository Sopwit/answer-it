package com.example.answerit.ui.language

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
import com.example.answerit.AnswerItApplication
import com.example.answerit.data.model.BackgroundTheme
import com.example.answerit.data.model.Language
import com.example.answerit.databinding.FragmentLanguageBinding
import com.example.answerit.ui.game.GameViewModel
import kotlinx.coroutines.launch

class LanguageFragment : Fragment() {

    private var _binding: FragmentLanguageBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLanguageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.appSettings.collect { settings ->
                    updateBackgroundTheme(settings.backgroundTheme)
                }
            }
        }
    }

    private fun setupUI() {
        val currentLanguage = viewModel.appSettings.value.language
        when (currentLanguage) {
            Language.TURKISH -> binding.turkishRadio.isChecked = true
            Language.ENGLISH -> binding.englishRadio.isChecked = true
            Language.CHINESE -> binding.chineseRadio.isChecked = true
            Language.SPANISH -> binding.spanishRadio.isChecked = true
            Language.ARABIC -> binding.arabicRadio.isChecked = true
            Language.GERMAN -> binding.germanRadio.isChecked = true
            Language.FRENCH -> binding.frenchRadio.isChecked = true
            Language.RUSSIAN -> binding.russianRadio.isChecked = true
            Language.HINDI -> binding.hindiRadio.isChecked = true
            Language.JAPANESE -> binding.japaneseRadio.isChecked = true
            Language.KOREAN -> binding.koreanRadio.isChecked = true
            Language.PORTUGUESE -> binding.portugueseRadio.isChecked = true
            Language.VIETNAMESE -> binding.vietnameseRadio.isChecked = true
            Language.ITALIAN -> binding.italianRadio.isChecked = true
        }

        binding.turkishRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.TURKISH) }
        binding.englishRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.ENGLISH) }
        binding.chineseRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.CHINESE) }
        binding.spanishRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.SPANISH) }
        binding.arabicRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.ARABIC) }
        binding.germanRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.GERMAN) }
        binding.frenchRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.FRENCH) }
        binding.russianRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.RUSSIAN) }
        binding.hindiRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.HINDI) }
        binding.japaneseRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.JAPANESE) }
        binding.koreanRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.KOREAN) }
        binding.portugueseRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.PORTUGUESE) }
        binding.vietnameseRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.VIETNAMESE) }
        binding.italianRadio.setOnCheckedChangeListener { _, isChecked -> if (isChecked) selectLanguage(Language.ITALIAN) }

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun updateBackgroundTheme(theme: BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)

        val textColor = ContextCompat.getColor(requireContext(), theme.textColorRes)
        val accentColor = ContextCompat.getColor(requireContext(), theme.accentColorRes)
        val secondaryBtnBg = ContextCompat.getColor(requireContext(), theme.secondaryButtonBgRes)
        val secondaryBtnText = ContextCompat.getColor(requireContext(), theme.secondaryButtonTextRes)
        val secondaryBtnStroke = ContextCompat.getColor(requireContext(), theme.secondaryButtonStrokeRes)

        binding.languageTitleText.setTextColor(textColor)

        val radioButtons = listOf(
            binding.turkishRadio,
            binding.englishRadio,
            binding.chineseRadio,
            binding.spanishRadio,
            binding.arabicRadio,
            binding.germanRadio,
            binding.frenchRadio,
            binding.russianRadio,
            binding.hindiRadio,
            binding.japaneseRadio,
            binding.koreanRadio,
            binding.portugueseRadio,
            binding.vietnameseRadio,
            binding.italianRadio
        )

        radioButtons.forEach { radio ->
            radio.setTextColor(textColor)
            radio.buttonTintList = android.content.res.ColorStateList.valueOf(accentColor)
        }

        binding.backButton.backgroundTintList = android.content.res.ColorStateList.valueOf(secondaryBtnBg)
        binding.backButton.setTextColor(secondaryBtnText)
        binding.backButton.strokeColor = android.content.res.ColorStateList.valueOf(secondaryBtnStroke)
        binding.backButton.strokeWidth = (1.5f * resources.displayMetrics.density).toInt()
    }

    private fun selectLanguage(language: Language) {
        val currentSettings = viewModel.appSettings.value.copy(language = language)
        viewModel.updateAppSettings(currentSettings)
        val app = requireActivity().application as AnswerItApplication
        app.container.languageManager.setLanguage(language)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
