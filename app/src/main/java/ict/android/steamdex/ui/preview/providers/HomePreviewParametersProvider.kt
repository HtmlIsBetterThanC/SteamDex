package ict.android.steamdex.ui.preview.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ict.android.steamdex.ui.preview.PreviewData.games
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.screens.home.HomeUiState

class HomePreviewParametersProvider : PreviewParameterProvider<HomeUiState> {
    override val values = sequenceOf(
        HomeUiState(
            profile = profiles[0],
            mostPlayedGames = games,
            trendingGames = games,
            onSaleGames = games.subList(0, 3),
            popularGames = games.subList(3, games.size - 1)
        ),
        HomeUiState(
            profile = profiles[1],
            mostPlayedGames = games.subList(0, 3),
            trendingGames = games.subList(3, games.size - 1),
            onSaleGames = games,
            popularGames = games
        ),
        HomeUiState(
            profile = profiles[2]
        )
    )
}
