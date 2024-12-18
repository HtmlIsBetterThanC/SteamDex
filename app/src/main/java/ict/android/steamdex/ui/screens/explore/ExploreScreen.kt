package ict.android.steamdex.ui.screens.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import ict.android.steamdex.ui.components.BottomNavbar
import ict.android.steamdex.ui.components.SearchFAB
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamGradient
import ict.android.steamdex.ui.preview.providers.ExplorePreviewParametersProvider
import ict.android.steamdex.ui.screens.explore.components.ExploreTopBar
import ict.android.steamdex.ui.screens.explore.components.MostPlayedCategory
import ict.android.steamdex.ui.screens.explore.components.OnSaleCategory
import ict.android.steamdex.ui.screens.explore.components.PopularCategory
import ict.android.steamdex.ui.screens.explore.components.TrendingCategory
import ict.android.steamdex.ui.theme.SteamDexTheme

// TODO handles empty games list
@Composable
fun ExploreScreen(
    uiState: ExploreUiState,
    useGradientBackground: Boolean,
    onProfileClick: () -> Unit,
    onCategoryClick: (Int) -> Unit,
    onCarouselExpandedClick: (Int, Boolean) -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
    bottomBar: @Composable () -> Unit = {}
) {
    if (uiState.isLoading) {
        Row(
            modifier = Modifier.fillMaxSize().background(
                if (useGradientBackground) Color.Transparent else MaterialTheme.colorScheme.background
            ).safeContentPadding(),
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        val profile = uiState.profile
        var editMode by remember {
            mutableStateOf(false)
        }
        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = {
                ExploreTopBar(
                    useGradientBackground = useGradientBackground,
                    editMode = editMode,
                    iconUrl = profile.iconUrl,
                    name = profile.name,
                    level = profile.level,
                    onProfileClick = onProfileClick,
                    onEditClick = {
                        editMode = !editMode
                    }
                )
            },
            bottomBar = bottomBar,
            floatingActionButton = {
                SearchFAB(onSearchClick)
            },
            containerColor =
            if (useGradientBackground) Color.Transparent else MaterialTheme.colorScheme.background
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    MostPlayedCategory(
                        mostPlayedGames = uiState.mostPlayedGames,
                        editMode = editMode,
                        isExpanded = uiState.isMostPlayedGamesExpanded,
                        onCategoryClick = { onCategoryClick(Category.MostPlayed.id) },
                        onIsExpandedClick = { onCarouselExpandedClick(Category.MostPlayed.id, it) }
                    )
                }

                item {
                    TrendingCategory(
                        trendingGames = uiState.trendingGames,
                        editMode = editMode,
                        isExpanded = uiState.isTrendingGamesExpanded,
                        onCategoryClick = { onCategoryClick(Category.Trending.id) },
                        onIsExpandedClick = { onCarouselExpandedClick(Category.Trending.id, it) }
                    )
                }

                item {
                    OnSaleCategory(
                        onSaleGames = uiState.onSaleGames,
                        editMode = editMode,
                        isExpanded = uiState.isOnSaleGamesExpanded,
                        onCategoryClick = { onCategoryClick(Category.OnSale.id) },
                        onIsExpandedClick = { onCarouselExpandedClick(Category.OnSale.id, it) }
                    )
                }

                item {
                    PopularCategory(
                        popularGames = uiState.popularGames,
                        editMode = editMode,
                        isExpanded = uiState.isPopularGamesExpanded,
                        onCategoryClick = { onCategoryClick(Category.Popular.id) },
                        onIsExpandedClick = { onCarouselExpandedClick(Category.Popular.id, it) }
                    )
                }
            }
        }
    }
}

enum class Category(val id: Int) {
    MostPlayed(0),
    Trending(1),
    OnSale(2),
    Popular(3)
}

@PreviewSteam
@Composable
private fun ExploreScreenPreview(
    @PreviewParameter(ExplorePreviewParametersProvider::class) uiState: ExploreUiState
) {
    SteamDexTheme {
        ExploreScreen(
            uiState = uiState,
            useGradientBackground = false,
            onCategoryClick = {},
            onSearchClick = {},
            onProfileClick = {},
            onCarouselExpandedClick = { _: Int, _: Boolean -> },
            bottomBar = {
                BottomNavbar(rememberNavController())
            }
        )
    }
}

@PreviewSteamGradient
@Composable
private fun ExploreScreenGradientPreview(
    @PreviewParameter(ExplorePreviewParametersProvider::class) uiState: ExploreUiState
) {
    SteamDexTheme {
        ExploreScreen(
            uiState = uiState,
            useGradientBackground = true,
            onCategoryClick = {},
            onSearchClick = {},
            onProfileClick = {},
            onCarouselExpandedClick = { _: Int, _: Boolean -> },
            modifier = Modifier.gradientBackground(isSystemInDarkTheme()),
            bottomBar = {
                BottomNavbar(rememberNavController())
            }
        )
    }
}
