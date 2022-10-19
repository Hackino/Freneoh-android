package com.futuneotech.freneoh.presentation.adapters.banner

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.futuneotech.freneoh.features.feature_article.domain.model.Media
import com.futuneotech.freneoh.presentation.fragments.list.Item

class BannerAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var banners: List<Media> = emptyList()

    fun updateAdapter(banners: List<Media>){
        this.banners=banners
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BannerViewHolder.from(parent)

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position

    override fun getItemCount() = banners.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BannerViewHolder).bindItems(banners, position)
    }
}
