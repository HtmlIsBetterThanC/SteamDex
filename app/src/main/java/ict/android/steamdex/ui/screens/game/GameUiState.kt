package ict.android.steamdex.ui.screens.game

import androidx.compose.runtime.Immutable
import ict.android.steamdex.models.ui.UiGame
import ict.android.steamdex.models.ui.UiProfile
import ict.android.steamdex.ui.preview.PreviewData.games

@Immutable
data class GameUiState(
    val isLoading: Boolean = false,
    val game: UiGame = games[0],
    val profile: UiProfile = UiProfile(),
)
