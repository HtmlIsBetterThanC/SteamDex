package ict.android.steamdex.ui.preview.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ict.android.steamdex.ui.preview.PreviewData.games
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.screens.library.LibraryUiState

class LibraryPreviewParametersProvider : PreviewParameterProvider<LibraryUiState> {
    override val values = sequenceOf(
        LibraryUiState(
            games = games,
            profile = profiles[0]
        ),
        LibraryUiState(
            games = games.subList(0, 3),
            profile = profiles[2]
        ),
        LibraryUiState()
    )
}
