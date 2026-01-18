package com.example.answerit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.answerit.R
import com.example.answerit.databinding.FragmentProfileBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        setupClickListeners()
    }

    private fun setupObservers() {
        viewModel.playerProfile.observe(viewLifecycleOwner) { profile ->
            updateProfileDisplay(profile)
        }

        viewModel.appSettings.observe(viewLifecycleOwner) { settings ->
            updateBackgroundTheme(settings.backgroundTheme)
        }
    }

    private fun setupClickListeners() {
        binding.editNameButton.setOnClickListener {
            showEditNameDialog()
        }

        binding.resetStatsButton.setOnClickListener {
            showResetStatsDialog()
        }

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun updateProfileDisplay(profile: com.example.answerit.data.PlayerProfile) {
        // Removed all statistics and avatar related code since the UI section was deleted
    }

    private fun updateBackgroundTheme(theme: com.example.answerit.data.BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)
        val textColor = resources.getColor(theme.textColorRes, null)
        binding.profileTitleText.setTextColor(textColor)
        // Removed all statistics and avatar related color updates
    }

    private fun showEditNameDialog() {
        val currentName = viewModel.playerProfile.value?.name ?: "Yarışmacı"
        
        val input = TextInputEditText(requireContext()).apply {
            setText(currentName)
            hint = getString(R.string.enter_name)
        }

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.change_name))
            .setView(input)
            .setPositiveButton(getString(R.string.save)) { _, _ ->
                val newName = input.text?.toString()?.trim()
                if (!newName.isNullOrEmpty()) {
                    viewModel.updatePlayerName(newName)
                }
            }
            .setNegativeButton(getString(R.string.cancel), null)
            .show()
    }

    private fun showResetStatsDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.reset_stats))
            .setMessage(getString(R.string.confirm_reset))
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                viewModel.resetPlayerStats()
            }
            .setNegativeButton(getString(R.string.no), null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 