package ict.android.steamdex.ui.screens.library

import androidx.compose.runtime.Immutable
import ict.android.steamdex.models.ui.UiGames
import ict.android.steamdex.models.ui.UiProfile

@Immutable
data class LibraryUiState(
    val isLoading: Boolean = false,
    val profile: UiProfile = UiProfile(),
    val games: List<UiGames> = emptyList()
)
