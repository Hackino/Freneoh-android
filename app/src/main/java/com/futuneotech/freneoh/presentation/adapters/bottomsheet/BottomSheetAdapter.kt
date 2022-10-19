package com.futuneotech.freneoh.presentation.adapters.bottomsheet

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.futuneotech.freneoh.presentation.fragments.list.Item

class BottomSheetAdapter(val list: List<Item>,
                         val current: Item,
                         val listener:OnBottomSheetItemListener
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RadioButtonViewHolder.from(parent)

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RadioButtonViewHolder).bindItems(list,current, position,listener)
    }
}
