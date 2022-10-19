package com.futuneotech.freneoh.presentation.adapters.filter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.futuneotech.freneoh.presentation.fragments.list.Item
import com.futuneotech.freneoh.utils.dLog

class FilterAdapter(val listener: OnFilterClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var filters: List<Item?> = emptyList()

    fun updateAdapter(filters: List<Item?>){
        this.filters=filters
        dLog("filters",filters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FilterViewHolder.from(parent)

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position

    override fun getItemCount() = filters.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FilterViewHolder).bindItems(filters, position,listener)
    }
}
