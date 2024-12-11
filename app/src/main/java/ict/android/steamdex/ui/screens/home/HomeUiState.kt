package ict.android.steamdex.ui.screens.home

import androidx.compose.runtime.Immutable
import ict.android.steamdex.models.ui.UiGames
import ict.android.steamdex.models.ui.UiProfile

@Immutable
data class HomeUiState(
    val profile: UiProfile,
    val mostPlayedGames: List<UiGames> = emptyList(),
    val trendingGames: List<UiGames> = emptyList(),
    val onSaleGames: List<UiGames> = emptyList(),
    val popularGames: List<UiGames> = emptyList()
)