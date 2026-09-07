package com.example.answerit.ui.profile

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
import com.example.answerit.databinding.FragmentProfileBinding
import com.example.answerit.ui.game.GameViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

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
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.appSettings.collect { settings ->
                        updateBackgroundTheme(settings.backgroundTheme)
                    }
                }
            }
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

    private fun updateBackgroundTheme(theme: BackgroundTheme) {
        binding.root.setBackgroundResource(theme.drawableRes)

        val textColor = ContextCompat.getColor(requireContext(), theme.textColorRes)
        val primaryBtnBg = ContextCompat.getColor(requireContext(), theme.primaryButtonBgRes)
        val primaryBtnText = ContextCompat.getColor(requireContext(), theme.primaryButtonTextRes)
        val secondaryBtnBg = ContextCompat.getColor(requireContext(), theme.secondaryButtonBgRes)
        val secondaryBtnText = ContextCompat.getColor(requireContext(), theme.secondaryButtonTextRes)
        val secondaryBtnStroke = ContextCompat.getColor(requireContext(), theme.secondaryButtonStrokeRes)

        binding.profileTitleText.setTextColor(textColor)

        binding.editNameButton.backgroundTintList = android.content.res.ColorStateList.valueOf(primaryBtnBg)
        binding.editNameButton.setTextColor(primaryBtnText)

        binding.backButton.backgroundTintList = android.content.res.ColorStateList.valueOf(secondaryBtnBg)
        binding.backButton.setTextColor(secondaryBtnText)
        binding.backButton.strokeColor = android.content.res.ColorStateList.valueOf(secondaryBtnStroke)
        binding.backButton.strokeWidth = (1.5f * resources.displayMetrics.density).toInt()
    }

    private fun showEditNameDialog() {
        val currentName = viewModel.playerProfile.value.name

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
