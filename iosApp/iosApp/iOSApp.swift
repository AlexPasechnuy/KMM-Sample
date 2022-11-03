import SwiftUI

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
            NewsListView(viewModel: NewsListView.ViewModel())
		}
	}
}
