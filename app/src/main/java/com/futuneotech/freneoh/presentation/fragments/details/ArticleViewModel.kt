package com.futuneotech.freneoh.presentation.fragments.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.futuneotech.freneoh.features.feature_article.data.utils.ArticleUseCases
import com.futuneotech.freneoh.features.feature_article.domain.model.Article
import com.futuneotech.freneoh.utils.dLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel
@Inject constructor(
    private val articleUseCases: ArticleUseCases,
) : ViewModel() {

    private val data = MutableLiveData<Article>()
    fun getData() = data

    fun getArticleById(id: Long) {
        viewModelScope.launch {
            articleUseCases.getArticleById.invoke(id).onEach { result ->
                data.setValue(result)
            }.launchIn(this)
        }
    }

    override fun onCleared() {
        super.onCleared()
        dLog("viewmodelcleared")
    }
}