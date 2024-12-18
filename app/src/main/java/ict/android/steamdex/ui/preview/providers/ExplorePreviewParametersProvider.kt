package ict.android.steamdex.ui.preview.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ict.android.steamdex.ui.preview.PreviewData.games
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.screens.explore.ExploreUiState

class ExplorePreviewParametersProvider : PreviewParameterProvider<ExploreUiState> {
    override val values = sequenceOf(
        ExploreUiState(
            profile = profiles[0],
            mostPlayedGames = games,
            trendingGames = games,
            onSaleGames = games.subList(0, 3),
            popularGames = games.subList(3, games.size - 1)
        ),
        ExploreUiState(
            profile = profiles[1],
            mostPlayedGames = games.subList(0, 3),
            trendingGames = games.subList(3, games.size - 1),
            onSaleGames = games,
            popularGames = games
        ),
        ExploreUiState(
            profile = profiles[2]
        )
    )
}
