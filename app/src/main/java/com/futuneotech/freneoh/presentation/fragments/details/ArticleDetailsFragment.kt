package com.futuneotech.freneoh.presentation.fragments.details

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.futuneotech.freneoh.R
import com.futuneotech.freneoh.presentation.base.fragment.BaseFragment
import com.futuneotech.freneoh.databinding.FragmentArticleDetailsBinding
import com.futuneotech.freneoh.features.feature_article.domain.model.Article
import com.futuneotech.freneoh.features.feature_article.domain.model.Media
import com.futuneotech.freneoh.presentation.adapters.banner.BannerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailsFragment : BaseFragment(R.layout.fragment_article_details) {

    private val binding: FragmentArticleDetailsBinding by viewBinding()
    private val viewModel: ArticleViewModel by viewModels()
    private val args by navArgs<ArticleDetailsFragmentArgs>()
    private val mBannerAdapter: BannerAdapter by lazy { BannerAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this;
        init()
    }

    private fun init() {
        reloadBanners()
        initObservers()
        viewModel.getArticleById(args.articleId)
    }

    private fun initObservers() {
        val dataObserver = Observer<Article> { article ->
            if (article != null)
                initComponents(article)
        }
        viewModel.getData().observe(viewLifecycleOwner, dataObserver)
    }

    private fun reloadBanners() {
        binding.banners.adapter = mBannerAdapter
    }

    private fun initComponents(article: Article) {
        binding.header.apply {
            if (isExpanded()) {
                headerContainer.visibility = View.GONE
            } else {
                headerContainer.visibility = View.VISIBLE
                title.text = article.title
                back.setOnClickListener {
                    findNavController().navigateUp()
                }
            }
        }

        val mediaList: ArrayList<Media> = ArrayList()
        for (media in article.media) {
            if (media.type == "image") {
                mediaList.add(media)
            }
        }

        if (mediaList.size > 0) {
            binding.banners.visibility = View.VISIBLE
            mBannerAdapter.updateAdapter(mediaList)
        } else {
            binding.banners.visibility = View.GONE
        }

        binding.title.text = article.title
        binding.articleAbstract.text = article.abstract
        binding.author.text = article.byLine
        binding.calendar.text = article.publishedDate

    }

}