package com.example.answerit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.answerit.R
import com.example.answerit.databinding.FragmentHomeBinding

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
        viewModel.playerProfile.observe(viewLifecycleOwner) {
            updatePlayerProfile()
        }

        viewModel.appSettings.observe(viewLifecycleOwner) { settings ->
            updateBackgroundTheme(settings.backgroundTheme)
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

    private fun updatePlayerProfile() {
        // Bu fonksiyon artık boş çünkü ilgili view'lar kaldırıldı.
    }

    private fun updateBackgroundTheme(theme: com.example.answerit.data.BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)
        // Sadece welcomeText'in rengini güncelle
        val textColor = resources.getColor(theme.textColorRes, null)
        binding.welcomeText.setTextColor(textColor)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 
