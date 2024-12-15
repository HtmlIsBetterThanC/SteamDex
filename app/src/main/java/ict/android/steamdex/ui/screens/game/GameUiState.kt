package ict.android.steamdex.ui.screens.game

import androidx.compose.runtime.Immutable
import ict.android.steamdex.models.ui.UiGames
import ict.android.steamdex.models.ui.UiProfile

@Immutable
data class GameUiState(
    val game: UiGames,
    val profile: UiProfile,
)
