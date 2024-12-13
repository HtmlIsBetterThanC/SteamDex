package ict.android.steamdex.ui.screens.explore

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.BottomNavbar
import ict.android.steamdex.ui.components.ScreenTopBar
import ict.android.steamdex.ui.components.SearchFAB
import ict.android.steamdex.ui.components.buttons.PrimaryButton
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamGradient
import ict.android.steamdex.ui.preview.providers.ExplorePreviewParametersProvider
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
            modifier = Modifier.fillMaxWidth(),
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
                ScreenTopBar(
                    profileIconUrl = profile.iconUrl,
                    profileName = profile.name,
                    profileLevel = profile.level,
                    onProfileClick = onProfileClick,
                    actions = {
                        PrimaryButton(
                            onClick = {
                                editMode = !editMode
                            },
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(10.dp))
                        ) {
                            if (editMode) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = stringResource(R.string.close_icon_description)
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = stringResource(R.string.edit_icon_description)
                                )
                            }
                        }
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
