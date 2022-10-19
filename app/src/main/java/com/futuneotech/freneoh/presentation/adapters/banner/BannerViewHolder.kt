package com.futuneotech.freneoh.presentation.adapters.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.futuneotech.freneoh.databinding.BannerViewholderBinding
import com.futuneotech.freneoh.features.feature_article.domain.model.Media

class BannerViewHolder(
    val binding: BannerViewholderBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItems(banners: List<Media>, position: Int) {
        val banner = banners[position]

        for (mediaData in banner.mediaMetaData) {
            if (mediaData.format == "mediumThreeByTwo440") {
                binding.image.load(mediaData.url)
            }
        }
    }

    companion object {
        fun from(parent: ViewGroup) = BannerViewHolder(
            BannerViewholderBinding.inflate(
                LayoutInflater
                    .from(parent.context), parent, false
            )
        )

    }
}