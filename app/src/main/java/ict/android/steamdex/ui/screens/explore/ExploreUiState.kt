package ict.android.steamdex.ui.screens.explore

import androidx.compose.runtime.Immutable
import ict.android.steamdex.models.ui.UiGame
import ict.android.steamdex.models.ui.UiProfile

@Immutable
data class ExploreUiState(
    val profile: UiProfile = UiProfile(),
    val isMostPlayedGamesExpanded: Boolean = true,
    val isTrendingGamesExpanded: Boolean = false,
    val isOnSaleGamesExpanded: Boolean = false,
    val isPopularGamesExpanded: Boolean = false,
    val mostPlayedGames: List<UiGame> = emptyList(),
    val trendingGames: List<UiGame> = emptyList(),
    val onSaleGames: List<UiGame> = emptyList(),
    val popularGames: List<UiGame> = emptyList(),
    val isLoading: Boolean = false
)
