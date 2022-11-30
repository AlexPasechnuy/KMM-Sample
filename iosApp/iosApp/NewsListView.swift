import SwiftUI
import shared

struct NewsListView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    
    var body: some View {
        List {
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
            let getLocalArticlesInteractor = DIHelperIOS().getLocalArticlesInteractor;
            let fetchArticlesInteractor = DIHelperIOS().fetchArticlesInteractor;
            presenter = LocalNewsListPresenter(
                getLocalArticlesInteractor : getLocalArticlesInteractor,
                fetchArticlesInteractor: fetchArticlesInteractor
            )
            presenter?.attach(view: self)
            presenter?.showNews()
        }
    }
}

