package com.example.answerit.ui.legal

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
import com.example.answerit.databinding.FragmentPrivacyPolicyBinding
import com.example.answerit.ui.game.GameViewModel
import kotlinx.coroutines.launch

class PrivacyPolicyFragment : Fragment() {

    private var _binding: FragmentPrivacyPolicyBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPrivacyPolicyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleText.text = getString(R.string.privacy_policy)
        binding.contentText.text = getString(R.string.privacy_policy_content)

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

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

    private fun updateBackgroundTheme(theme: BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)

        val textColor = ContextCompat.getColor(requireContext(), theme.textColorRes)
        val cardBg = ContextCompat.getColor(requireContext(), theme.cardBgColorRes)
        val cardTextColor = ContextCompat.getColor(requireContext(), theme.cardTextColorRes)
        val secondaryBtnBg = ContextCompat.getColor(requireContext(), theme.secondaryButtonBgRes)
        val secondaryBtnText = ContextCompat.getColor(requireContext(), theme.secondaryButtonTextRes)
        val secondaryBtnStroke = ContextCompat.getColor(requireContext(), theme.secondaryButtonStrokeRes)

        binding.titleText.setTextColor(textColor)
        binding.contentCard.setCardBackgroundColor(cardBg)
        binding.contentText.setTextColor(cardTextColor)

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
