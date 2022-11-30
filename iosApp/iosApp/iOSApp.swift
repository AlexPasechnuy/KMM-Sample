import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init() {
        DIInitIOSKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
            NewsListView(viewModel: NewsListView.ViewModel())
		}
	}
}
