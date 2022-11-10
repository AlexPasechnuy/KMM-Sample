package com.pasichnyi.cleanarchitecturekmm.UI.presenter

import com.pasichnyi.cleanarchitecturekmm.UI.contract.NewsListPresenterContract
import com.pasichnyi.cleanarchitecturekmm.UI.contract.NewsListViewContract
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.FetchArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.GetLocalArticlesInteractor
import kotlinx.coroutines.launch

class LocalNewsListPresenter(
    private val getLocalArticlesInteractor: GetLocalArticlesInteractor,
    private val fetchArticlesInteractor: FetchArticlesInteractor,
) : BasePresenter<NewsListViewContract>(), NewsListPresenterContract {

    override fun showNews() {
        launch {
            fetchArticlesInteractor()
            val list = getLocalArticlesInteractor()
            view?.displayNewsList(list)
        }
    }
}