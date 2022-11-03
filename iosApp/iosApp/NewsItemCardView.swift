//
//  NewsItemCardView.swift
//  iosApp
//
//  Created by Alex Pasechnuy on 07.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation

import SwiftUI
import shared

struct NewsItemCardView: View {
    let article: Article

    var body: some View {
        VStack(alignment: .leading) {
            Text(article.title)
                .font(.headline)
                .accessibilityAddTraits(.isHeader)
            Spacer()
            Text(article.content ?? "")
                .font(.headline)
                .accessibilityAddTraits(.isHeader)
        }
        .padding()
    }
}

struct NewsItemCardView_Previews: PreviewProvider {
    static var newsItem = Article(
        source : "NY Times",
        author : "Mike Tyson",
        title : "Putin died",
        description : "Putin died. Wow.",
        url : "",
        urlToImage : "",
        publishTime : "today",
        content : "Putin was killed tomorrow in Kremlin..."
    )
    static var previews: some View {
        NewsItemCardView(article: newsItem)
            .previewLayout(.fixed(width: 400, height: 60))
    }
}
