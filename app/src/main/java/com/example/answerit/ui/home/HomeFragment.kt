package com.example.answerit.ui.home

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
import com.example.answerit.databinding.FragmentHomeBinding
import com.example.answerit.ui.game.GameViewModel
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        setupClickListeners()
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

    private fun setupClickListeners() {
        binding.playButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_gameFragment)
        }

        binding.profileButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }

        binding.settingsButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }

        binding.exitButton.setOnClickListener {
            requireActivity().finish()
        }
    }

    private fun updateBackgroundTheme(theme: BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)

        val textColor = ContextCompat.getColor(requireContext(), theme.textColorRes)
        val primaryBtnBg = ContextCompat.getColor(requireContext(), theme.primaryButtonBgRes)
        val primaryBtnText = ContextCompat.getColor(requireContext(), theme.primaryButtonTextRes)
        val secondaryBtnBg = ContextCompat.getColor(requireContext(), theme.secondaryButtonBgRes)
        val secondaryBtnText = ContextCompat.getColor(requireContext(), theme.secondaryButtonTextRes)
        val secondaryBtnStroke = ContextCompat.getColor(requireContext(), theme.secondaryButtonStrokeRes)

        binding.welcomeText.setTextColor(textColor)

        binding.playButton.backgroundTintList = android.content.res.ColorStateList.valueOf(primaryBtnBg)
        binding.playButton.setTextColor(primaryBtnText)

        binding.profileButton.backgroundTintList = android.content.res.ColorStateList.valueOf(secondaryBtnBg)
        binding.profileButton.setTextColor(secondaryBtnText)
        binding.profileButton.strokeColor = android.content.res.ColorStateList.valueOf(secondaryBtnStroke)
        binding.profileButton.strokeWidth = (2 * resources.displayMetrics.density).toInt()

        binding.settingsButton.backgroundTintList = android.content.res.ColorStateList.valueOf(secondaryBtnBg)
        binding.settingsButton.setTextColor(secondaryBtnText)
        binding.settingsButton.strokeColor = android.content.res.ColorStateList.valueOf(secondaryBtnStroke)
        binding.settingsButton.strokeWidth = (2 * resources.displayMetrics.density).toInt()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
