package com.test.interview.presentation.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.test.interview.data.model.AlarmItem
import com.test.interview.data.util.currentDay
import com.test.interview.databinding.FragmentFavouriteBinding
import java.util.Calendar

class FavouriteFragment : Fragment() {

    private var _binding: FragmentFavouriteBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<FavViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = AlarmItem(
            day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK).currentDay(),
            body = "Wow what a beautiful day"
        )

        binding.btnStart.setOnClickListener {
            viewModel.startAlarm(item)
        }

        binding.btnCancel.setOnClickListener {
            viewModel.cancel(item)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}