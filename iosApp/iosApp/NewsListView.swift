import SwiftUI
import shared

struct NewsListView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    
    var body: some View {
        List {
            // ID is title - BAD!
            ForEach(viewModel.articles, id: \.title) { article in
                NewsItemCardView(article: article)
            }
        }
    }
}

extension NewsListView {
    class ViewModel: ObservableObject, NewsListViewContract {
        
        @Published var articles : [Article] = [
            Article(
                source : "",
                author : "",
                title : "Loading...",
                description: "",
                url : "",
                urlToImage : "",
                publishTime : "today",
                content : "Now loading..."
                        )
        ]
        
        var presenter: NewsListPresenterContract? = nil
        
        
        func displayNewsList(news: [Article]) {
            articles = news
        }
        
        func showUnexpectedError() {
            // TODO("Implement during deeper IOS investigate")
        }

        init() {
            // TODO("DI")
            let articlesRepository = ArticlesRepositoryImpl(
                localArticlesDatasource : LocalArticlesDatasource(
                    database : Database(databaseDriverFactory : DatabaseDriverFactory())
                ),
                remoteArticlesDatasource : RemoteArticlesDatasource(),
                dataArticleMapper : DataArticleToDomainMapper()
            )
            presenter = LocalNewsListPresenter(
                getLocalArticlesInteractor : GetLocalArticlesInteractor(
                    articlesRepository :articlesRepository
                ),
                fetchArticlesInteractor: FetchArticlesInteractor(articlesRepository : articlesRepository)
            )
            presenter?.attach(view: self)
            presenter?.showNews()
        }
    }
}

