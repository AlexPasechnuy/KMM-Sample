package com.pasichnyi.cleanarchitecturekmm.android.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.pasichnyi.cleanarchitecturekmm.UI.contract.NewsListPresenterContract
import com.pasichnyi.cleanarchitecturekmm.UI.contract.NewsListViewContract
import com.pasichnyi.cleanarchitecturekmm.UI.presenter.LocalNewsListPresenter
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.FetchArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.GetLocalArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.view.MainView
import org.koin.android.ext.android.inject

class NewsListActivity : BaseActivity<NewsListViewContract, NewsListPresenterContract>(),
    NewsListViewContract {

    private val getLocalArticlesInteractor : GetLocalArticlesInteractor by inject()
    private val fetchArticlesInteractor : FetchArticlesInteractor by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Fetching news...")
        }
        presenter.showNews()
    }

    override fun initPresenter(): NewsListPresenterContract {
        return LocalNewsListPresenter(
            getLocalArticlesInteractor = getLocalArticlesInteractor,
            fetchArticlesInteractor = fetchArticlesInteractor,
        )
    }

    override fun displayNewsList(news: List<Article>) {
        setContent { MainView() }
    }
}