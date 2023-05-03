package com.test.interview.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.test.interview.R
import com.test.interview.databinding.FragmentHomeBinding
import com.test.interview.presentation.utils.showExitDialog
import com.test.interview.presentation.utils.onBackPressed

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


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

        requireActivity().apply {

            onBackPressed {
                requireContext().showExitDialog("Confirmation", "Do you want to exit?") {
                    finishAffinity()
                }
            }
        }

        setupBottomSheet()

    }

    private fun setupBottomSheet() {


        binding.bottomBar.setupWithNavController(( childFragmentManager.findFragmentById(
            R.id.nav_host_home
        ) as NavHostFragment).navController)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}