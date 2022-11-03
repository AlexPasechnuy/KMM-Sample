package com.pasichnyi.cleanarchitecturekmm.UI.presenter

import com.pasichnyi.cleanarchitecturekmm.UI.contract.NewsListPresenterContract
import com.pasichnyi.cleanarchitecturekmm.UI.contract.NewsListViewContract
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.GetAllArticlesInteractor
import kotlinx.coroutines.launch

class NewsListPresenter : BasePresenter<NewsListViewContract>(), NewsListPresenterContract {

    // TODO("Add DI")
    private val getAllArticlesInteractor = GetAllArticlesInteractor()

    override fun showNews() {
        launch {
            val list = getAllArticlesInteractor()
            view?.displayNewsList(list)
        }
    }
}