package com.futuneotech.freneoh.presentation.fragments.list

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.futuneotech.freneoh.R
import com.futuneotech.freneoh.databinding.FragmentArticlesBinding
import com.futuneotech.freneoh.features.feature_article.domain.model.Article
import com.futuneotech.freneoh.presenta.ArticlesViewModel
import com.futuneotech.freneoh.presentation.adapters.article.ArticleAdapter
import com.futuneotech.freneoh.presentation.adapters.bottomsheet.BottomSheetAdapter
import com.futuneotech.freneoh.presentation.adapters.bottomsheet.OnBottomSheetItemListener
import com.futuneotech.freneoh.presentation.adapters.filter.FilterAdapter
import com.futuneotech.freneoh.presentation.adapters.filter.OnFilterClickListener
import com.futuneotech.freneoh.presentation.base.fragment.BaseFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticlesFragment: BaseFragment(R.layout.fragment_articles)
    ,OnFilterClickListener,OnBottomSheetItemListener{
    private val binding: FragmentArticlesBinding by viewBinding()
    private val viewModel: ArticlesViewModel by viewModels()
    private val mArticlesAdapter: ArticleAdapter by lazy { ArticleAdapter() }
    private val mFiltersAdapter: FilterAdapter by lazy { FilterAdapter(this) }
    private val bottomSheetDialog: BottomSheetDialog by lazy {  BottomSheetDialog(requireContext()) }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getArticles()
        init()
    }

    private fun init() {
        initObservers()
        initSearchView()
        reloadAdapters()
        setupFilterBtn()
    }

    private fun updateArticles(articles:List<Article>){
        if (articles.isEmpty())binding.noData.visibility = View.VISIBLE
        else binding.noData.visibility = View.GONE
        mArticlesAdapter.updateAdapter(articles)
    }

    private fun initObservers(){
        viewModel.getData().observe(viewLifecycleOwner) { articles ->
            if (articles != null)
                updateArticles(articles)
        }

        viewModel.isLoading().observe(viewLifecycleOwner) { isLoading ->
            if (isLoading != null)
                if (isLoading) mLoader.show() else mLoader.dismiss()
        }

        viewModel.dataQuery().observe(viewLifecycleOwner) { articles ->
            if (articles != null) {
                updateArticles(articles)
            }
        }
        viewModel.searchQuery().observe(viewLifecycleOwner) { query ->
            if (query == null || query == "")
                viewModel.getArticles()
        }

        viewModel.isFiltersVisible().observe(viewLifecycleOwner) { isVisible ->
            if (isVisible == null) {
                viewModel.updateFiltersVisibility(true)
            }
            if (isVisible) {
                binding.filters.visibility = View.VISIBLE
                binding.filterBtn.setText(R.string.hide_filters)
            } else {
                binding.filters.visibility = View.GONE
                binding.filterBtn.setText(R.string.empty)
            }
        }
    }
    private fun initSearchView(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    viewModel.updateSearchQuery(newText)
                    viewModel.filterWithQueries(newText)
                }
                return false
            }
        })
    }

    private fun setupFilterBtn() {
        binding.filterBtn.setOnClickListener{
            if(viewModel.isFiltersVisible().value == null){
                viewModel.updateFiltersVisibility(true)
            }else{
                viewModel.updateFiltersVisibility(
                    !viewModel.isFiltersVisible().value!!
                )
            }
        }
    }

    private fun reloadAdapters() {
        reloadFiltersAdapter()
        reloadArticlesAdapter()
    }

    private fun reloadFiltersAdapter() {
        binding.filters.adapter = mFiltersAdapter
        mFiltersAdapter.updateAdapter(viewModel.getFiltersItem())
    }

    private fun reloadArticlesAdapter() {
        binding.list.adapter = mArticlesAdapter
    }

    override fun onFilterClick(position: Int, filter: Item) {
        if (filter is ArticleSection){
            bottomSheet(sectionsList,viewModel.getSectionFilter().value!!)
        }
        if (filter is PublishedDateItems){
            bottomSheet(publishedDateList,viewModel.getPublishedDateFilter().value!!)
        }
    }

    private fun bottomSheet(list:List<Item>,current:Item){
       val  bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_layout, null);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
        val sheetListView:RecyclerView=  bottomSheetView.findViewById(R.id.bottom_sheet_listview);
        val adapter= BottomSheetAdapter(list,current,this);
        sheetListView.adapter = adapter
    }

    override fun onBottomSheetItemClicked(position: Int, item: Item) {
        if (item is ArticleSection){
           viewModel.updateSectionFilter(item)
        }
        if (item is PublishedDateItems){
            viewModel.updatePublishedDateFilter(item)
        }
        viewModel.getArticles()
        mFiltersAdapter.updateAdapter(viewModel.getFiltersItem())

        bottomSheetDialog.dismiss()
    }

}