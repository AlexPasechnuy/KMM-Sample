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
import com.pasichnyi.cleanarchitecturekmm.UI.presenter.NewsListPresenter
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

class NewsListActivity : BaseActivity<NewsListViewContract, NewsListPresenterContract>(),
    NewsListViewContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Fetching news...")
        }
        presenter.showNews()
    }

    override fun initPresenter(): NewsListPresenterContract {
        return NewsListPresenter()
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
//        Row(modifier = Modifier.padding(all = 8.dp)) {
//            Image(
//                painter = painterResource(R.drawable.profile_picture),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(40.dp)
//                    .clip(CircleShape)
//                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
//            )
//            Spacer(modifier = Modifier.width(8.dp))
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
//        }
    }
}