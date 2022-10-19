package com.futuneotech.freneoh.presentation.adapters.article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.futuneotech.freneoh.databinding.ArticleItemViewholderBinding
import com.futuneotech.freneoh.features.feature_article.domain.model.Article
import com.futuneotech.freneoh.presentation.fragments.list.ArticlesFragmentDirections

class ArticleViewHolder(
    val binding: ArticleItemViewholderBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItems(articles: List<Article>, position: Int) {
        val article = articles[position]

        if (article.media.size>0){
            binding.image.visibility = View.VISIBLE

            for (media in article.media[0].mediaMetaData) {
            if (media.format == "Standard Thumbnail") {
                binding.image.load(media.url)
            }
        }
        }else{
            binding.image.visibility = View.GONE
        }
        binding.article = article
        binding.container.setOnClickListener {
            val action = article.id.let { id ->
                ArticlesFragmentDirections.actionArticlesFragmentToArticleDetailsFragment(id)
            }
            action.let{ itemView.findNavController().navigate(it)}
        }
    }

    companion object {
        fun from(parent: ViewGroup) = ArticleViewHolder(
            ArticleItemViewholderBinding.inflate(
                LayoutInflater
                    .from(parent.context), parent, false
            )
        )

    }
}