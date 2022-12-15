package com.pasichnyi.cleanarchitecturekmm.android.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pasichnyi.cleanarchitecturekmm.UI.contract.NewsListPresenterContract
import com.pasichnyi.cleanarchitecturekmm.UI.contract.NewsListViewContract
import com.pasichnyi.cleanarchitecturekmm.UI.presenter.LocalNewsListPresenter
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.FetchArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.GetLocalArticlesInteractor
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
        setContent { ArticlesList(news) }
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        ArticlesList(
            Article.sampleData
        )
    }

    @Composable
    fun ArticlesList(articles: List<Article>) {
        LazyColumn {
            articles.map { item { ArticleCard(it) } }
        }
    }

    @Composable
    fun ArticleCard(article: Article) {
        Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {

            Column {

                Text(
                    text = article.author ?: "Unknown author",
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = article.content ?: "Unknown text",
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
    }
}