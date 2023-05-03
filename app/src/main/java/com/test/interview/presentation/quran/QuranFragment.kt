package com.test.interview.presentation.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.interview.data.model.Dummy
import com.test.interview.databinding.FragmentQuranBinding

class QuranFragment : Fragment() {

    private var _binding: FragmentQuranBinding? = null
    private val binding get() = _binding!!

    private var _adapter: DummyAdapter? = null
    private val adapter get() = _adapter!!

    private var isScrolling = false

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
        adapter.submitList(getDummyData())

        binding.rvDummy.addOnScrollListener(
            onScrollListener()
        )

    }

    private fun onScrollListener() =
        object : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)

            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                isScrolling = true
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val currentItems = recyclerView.layoutManager!!.childCount
            val totalItems = recyclerView.layoutManager!!.itemCount
            val scrollOutItems =
                (binding.rvDummy.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

            if (isScrolling && (scrollOutItems + currentItems == totalItems) && adapter.currentList.size <= 500) {

                isScrolling = false
                Toast.makeText(requireContext(), "New Data Loaded", Toast.LENGTH_SHORT)
                    .show()
                adapter.submitList(getDummyData() + adapter.currentList)
            }
        }
    }


    private fun getDummyData(): List<Dummy> {
        val newData = mutableListOf<Dummy>()
        for (i in 1..50) {
            newData.add(Dummy(text = "Dummy $i*$i", num = 0))
        }
        return newData
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}