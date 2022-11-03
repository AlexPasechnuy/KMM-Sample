package com.pasichnyi.cleanarchitecturekmm.UI.contract

import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

interface NewsListViewContract : BaseViewContract {
    fun displayNewsList(news: List<Article>)
}

interface NewsListPresenterContract : BasePresenterContract<NewsListViewContract> {

    fun showNews()
}