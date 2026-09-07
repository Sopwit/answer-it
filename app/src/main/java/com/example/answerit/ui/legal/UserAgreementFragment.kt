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
import com.example.answerit.databinding.FragmentUserAgreementBinding
import com.example.answerit.ui.game.GameViewModel
import kotlinx.coroutines.launch

class UserAgreementFragment : Fragment() {

    private var _binding: FragmentUserAgreementBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserAgreementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleText.text = getString(R.string.user_agreement)
        binding.contentText.text = getString(R.string.user_agreement_content)

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
        binding.titleText.setTextColor(textColor)

        val isLightTheme = theme == BackgroundTheme.MINIMAL_LIGHT || theme == BackgroundTheme.GRADIENT_GOLD
        val contentColor = if (isLightTheme) {
            ContextCompat.getColor(requireContext(), R.color.text_dark)
        } else {
            textColor
        }
        binding.contentText.setTextColor(contentColor)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
