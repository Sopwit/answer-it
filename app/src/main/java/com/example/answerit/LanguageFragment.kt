package com.example.answerit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.answerit.data.Language
import com.example.answerit.data.LanguageManager
import com.example.answerit.databinding.FragmentLanguageBinding

class LanguageFragment : Fragment() {
    private var _binding: FragmentLanguageBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by activityViewModels()
    private lateinit var languageManager: LanguageManager

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
        languageManager = LanguageManager(requireContext())
        setupUI()
    }

    private fun setupUI() {
        val currentLanguage = viewModel.appSettings.value?.language ?: Language.TURKISH
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

    private fun selectLanguage(language: Language) {
        val currentSettings = viewModel.appSettings.value?.copy(language = language)
        if (currentSettings != null) {
            viewModel.updateAppSettings(currentSettings)
            languageManager.setLanguage(language)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 