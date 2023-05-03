package com.test.interview.presentation.ramazan

import android.database.DatabaseUtils
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.test.interview.databinding.FragmentRamzanBinding


class RamzanFragment : Fragment() {

    private var _binding: FragmentRamzanBinding? = null
    private val binding get() = _binding!!

    private val vm by viewModels<RamazanViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRamzanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DataBindingUtil.bind<FragmentRamzanBinding>(view)?.apply {
            viewModel = vm
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}