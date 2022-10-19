package com.futuneotech.freneoh.presentation.adapters.bottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.futuneotech.freneoh.databinding.BannerViewholderBinding
import com.futuneotech.freneoh.databinding.RadioButtonViewholderBinding
import com.futuneotech.freneoh.features.feature_article.domain.model.Media
import com.futuneotech.freneoh.presentation.fragments.list.Item

class RadioButtonViewHolder(
    val binding: RadioButtonViewholderBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItems(list: List<Item>,current: Item, position: Int,listener: OnBottomSheetItemListener) {
        val btn = list[position]
        binding.btn.setText(btn.title)

        if (current.title == btn.title){
            binding.btn.isChecked = true
        }
        itemView.setOnClickListener{
            listener.onBottomSheetItemClicked(position,btn)
        }
        binding.btn.setOnClickListener{
            listener.onBottomSheetItemClicked(position,btn)
        }
    }

    companion object {
        fun from(parent: ViewGroup) = RadioButtonViewHolder(
            RadioButtonViewholderBinding.inflate(
                LayoutInflater
                    .from(parent.context), parent, false
            )
        )

    }
}