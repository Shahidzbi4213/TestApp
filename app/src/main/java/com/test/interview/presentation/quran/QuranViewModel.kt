package com.test.interview.presentation.quran

import android.widget.AbsListView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.interview.data.model.Dummy
import kotlinx.coroutines.flow.MutableStateFlow

/*
 * Created by Shahid Iqbal on 5/4/2023.
 */

class QuranViewModel : ViewModel() {

    var isScrolling = MutableStateFlow(false)
        private set


    fun onScrollListener() =
        object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                    isScrolling.value = true
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val currentItems = recyclerView.layoutManager!!.childCount
                val totalItems = recyclerView.layoutManager!!.itemCount
                val scrollOutItems =
                    (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                if (isScrolling.value && (scrollOutItems + currentItems == totalItems))
                    isScrolling.value = false

            }
        }


    fun getDummyData(): List<Dummy> {
        val newData = mutableListOf<Dummy>()
        for (i in 1..50) {
            newData.add(Dummy(text = "Dummy $i*$i", num = 0))
        }
        return newData
    }
}