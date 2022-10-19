package com.futuneotech.freneoh.presentation.adapters.article

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.futuneotech.freneoh.features.feature_article.domain.model.Article

class ArticleAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var articles: List<Article> = emptyList()

    fun updateAdapter(articles:List<Article>){
        this.articles=articles
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArticleViewHolder.from(parent)

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ArticleViewHolder).bindItems(articles, position)
    }
}
