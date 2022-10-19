package com.futuneotech.freneoh.presenta

import com.futuneotech.freneoh.presentation.fragments.list.ArticleSection
import com.futuneotech.freneoh.presentation.fragments.list.PublishedDateItems
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.futuneotech.freneoh.application.FreneohApp
import com.futuneotech.freneoh.core.data.utils.Resource
import com.futuneotech.freneoh.features.feature_article.data.utils.ArticleUseCases
import com.futuneotech.freneoh.features.feature_article.domain.model.Article
import com.futuneotech.freneoh.utils.dLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar
import javax.inject.Inject


@HiltViewModel
class ArticlesViewModel
@Inject constructor(app: FreneohApp, val articleUseCases: ArticleUseCases) : AndroidViewModel(app) {

    private val data = MutableLiveData<List<Article>?>()
    fun getData() = data

    private val loading = MutableLiveData<Boolean>()
    fun isLoading() = loading

    private val publishedDateFilter = MutableLiveData<PublishedDateItems>()
    fun getPublishedDateFilter() = publishedDateFilter
    fun updatePublishedDateFilter(status:PublishedDateItems) {publishedDateFilter.value =status }

    private val sectionFilter = MutableLiveData<ArticleSection>()
    fun getSectionFilter() = sectionFilter
    fun updateSectionFilter(status:ArticleSection) {sectionFilter.value =status }

    private val isFiltersVisible = MutableLiveData<Boolean>()
    fun isFiltersVisible() = isFiltersVisible
    fun updateFiltersVisibility(status:Boolean) {isFiltersVisible.value =status }

    private val searchQuery = MutableLiveData<String>()
    fun searchQuery() = searchQuery
    fun updateSearchQuery(query:String) {searchQuery.value =query }

    private val dataQuery = MutableLiveData<List<Article>>()
    fun dataQuery() = dataQuery

    init {
        publishedDateFilter.value = PublishedDateItems.Weekly
        sectionFilter.value = ArticleSection.All
    }

    fun getFiltersItem() = listOf(
        sectionFilter.value,
        publishedDateFilter.value,
    )

    fun getArticles() {
        viewModelScope.launch {
            articleUseCases.getArticles.invoke(
                publishedDateFilter.value!!.type,
                sectionFilter.value!!.type
            ).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        data.value = filterData(result)
                        applyQueries()
                        loading.value = false
                    }

                    is Resource.Error -> {
                        dLog("error")
                        data.value = filterData(result)
                        applyQueries()
                        loading.value = false
                    }

                    is Resource.Loading -> {
                        dLog("loading")
                        loading.value = true
                    }
                }

            }.launchIn(this)
        }
    }

    private fun applyQueries(){
        if (searchQuery.value!=null && searchQuery.value != "" )
            filterWithQueries(searchQuery.value!!)
    }

    private fun filterData(result:Resource<List<Article>>):List<Article>{
        var list:ArrayList<Article> = ArrayList()
        if (result.data != null){
          if (sectionFilter.value!= ArticleSection.All){
                result.data.forEach { article->
                    if (article.section == sectionFilter.value!!.section){
                        list.add(article)
                    }
                }
            }else{
              result.data.forEach { article-> list.add(article) }
            }

            val df = SimpleDateFormat("yyyy-MM-dd")
           val current =  df.parse(df.format(getPeriod(publishedDateFilter.value!!.type)))
            val dateFilteredList:ArrayList<Article> = ArrayList()
            for(article in list){
                if (current != null) {
                    if (current.equals( df.parse(article.publishedDate)) || current.before(df.parse(article.publishedDate))){
                        dateFilteredList.add(article)
                    }
                }
            }
            list = dateFilteredList
        }
        return list
    }

    private fun getPeriod(period:Int):Date{
        val today = Date()
        val cal: Calendar = GregorianCalendar()
        cal.time = today
        if (period == 1){
            return cal.time
        }
        cal.add(Calendar.DAY_OF_MONTH, -period)
        return cal.time
    }

    fun filterWithQueries(query: String){
        dataQuery.value = data.value?.filter {
            it.title.lowercase().contains(query.lowercase())
                || it.byLine.lowercase().contains(query.lowercase())
        }
    }
}