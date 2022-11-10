package com.pasichnyi.cleanarchitecturekmm.UI.presenter

import com.pasichnyi.cleanarchitecturekmm.UI.contract.NewsListPresenterContract
import com.pasichnyi.cleanarchitecturekmm.UI.contract.NewsListViewContract
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.GetNetworkArticlesInteractor
import kotlinx.coroutines.launch

class RemoteNewsListPresenter(
    private val getNetworkArticlesInteractor: GetNetworkArticlesInteractor,
) : BasePresenter<NewsListViewContract>(), NewsListPresenterContract {

    override fun showNews() {
        launch {
            val list = getNetworkArticlesInteractor()
            view?.displayNewsList(list)
        }
    }
}