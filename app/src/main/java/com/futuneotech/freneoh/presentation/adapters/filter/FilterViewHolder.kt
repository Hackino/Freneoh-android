package com.futuneotech.freneoh.presentation.adapters.filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.futuneotech.freneoh.databinding.FilterChipViewholderBinding
import com.futuneotech.freneoh.presentation.fragments.list.Item

class FilterViewHolder(
    val binding: FilterChipViewholderBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItems(filters: List<Item?>, position: Int, listener: OnFilterClickListener) {
        val filter = filters[position]
        if (filter == null) binding.container.visibility = View.GONE
        else {
            binding.filterItem.setText(filter.title)

            binding.container.setOnClickListener {
                listener.onFilterClick(position, filter)
            }
            itemView.setOnClickListener{
                listener.onFilterClick(position, filter)
            }
            binding.filterItem.setOnClickListener{
                listener.onFilterClick(position, filter)

            }
        }
    }

    companion object {
        fun from(parent: ViewGroup) = FilterViewHolder(
            FilterChipViewholderBinding.inflate(
                LayoutInflater
                    .from(parent.context), parent, false
            )
        )

    }
}