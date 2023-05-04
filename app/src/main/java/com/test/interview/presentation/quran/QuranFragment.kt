package com.test.interview.presentation.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ListAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.interview.data.model.Dummy
import com.test.interview.databinding.FragmentQuranBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class QuranFragment : Fragment() {

    private var _binding: FragmentQuranBinding? = null
    private val binding get() = _binding!!

    private var _adapter: DummyAdapter? = null
    private val adapter get() = _adapter!!

    private val quranViewModel by viewModels<QuranViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _adapter = DummyAdapter()
        binding.rvDummy.adapter = adapter


        binding.rvDummy.addOnScrollListener(
            quranViewModel.onScrollListener()
        )

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                quranViewModel.isScrolling.collectLatest {
                    if (!it) {
                        when {
                            adapter.currentList.size == 0 -> adapter.submitList(quranViewModel.getDummyData())
                            adapter.currentList.size <= 500 -> {
                                adapter.submitList(adapter.currentList + quranViewModel.getDummyData())
                                Toast.makeText(
                                    requireContext(),
                                    "New Data Loaded",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}