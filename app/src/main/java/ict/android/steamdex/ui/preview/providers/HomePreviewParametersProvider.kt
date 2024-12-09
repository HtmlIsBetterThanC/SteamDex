package ict.android.steamdex.ui.preview.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ict.android.steamdex.ui.preview.PreviewData.games
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.screens.home.HomeUiState

class HomePreviewParametersProvider : PreviewParameterProvider<HomeUiState> {
    override val values = sequenceOf(
        HomeUiState(
            profile = profiles[0],
            games = games
        ),
        HomeUiState(
            profile = profiles[1],
            games = games.subList(0, 2)
        ),
        HomeUiState(
            profile = profiles[2],
            games = emptyList()
        ),
    )
}
