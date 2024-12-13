package ict.android.steamdex.ui.screens.explore

import androidx.compose.runtime.Immutable
import ict.android.steamdex.models.ui.UiGames
import ict.android.steamdex.models.ui.UiProfile

@Immutable
data class ExploreUiState(
    val profile: UiProfile = UiProfile(),
    val isMostPlayedGamesExpanded: Boolean = true,
    val isTrendingGamesExpanded: Boolean = false,
    val isOnSaleGamesExpanded: Boolean = false,
    val isPopularGamesExpanded: Boolean = false,
    val mostPlayedGames: List<UiGames> = emptyList(),
    val trendingGames: List<UiGames> = emptyList(),
    val onSaleGames: List<UiGames> = emptyList(),
    val popularGames: List<UiGames> = emptyList()
)
