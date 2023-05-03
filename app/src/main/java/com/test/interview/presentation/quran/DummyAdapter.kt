package com.test.interview.presentation.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.interview.data.model.Dummy
import com.test.interview.databinding.SingleDummyBinding

/*
 * Created by Shahid Iqbal on 5/4/2023.
 */

class DummyAdapter : ListAdapter<Dummy, DummyAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            SingleDummyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null)
            holder.onBind(dummy = currentItem)
    }

    inner class ViewHolder(private val binding: SingleDummyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(dummy: Dummy) {

            binding.tvNum.text = adapterPosition.toString()
            binding.tvText.text = dummy.text
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Dummy>() {
        override fun areItemsTheSame(oldItem: Dummy, newItem: Dummy) =
            oldItem.num == newItem.num

        override fun areContentsTheSame(oldItem: Dummy, newItem: Dummy) =
            oldItem == newItem
    }
}