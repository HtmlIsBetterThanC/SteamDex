package ict.android.steamdex.ui.screens.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ui.components.ScreenTopBar
import ict.android.steamdex.ui.components.SearchFAB
import ict.android.steamdex.ui.components.buttons.PrimaryButton
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.providers.HomePreviewParametersProvider
import ict.android.steamdex.ui.screens.home.components.MostPlayedCategory
import ict.android.steamdex.ui.screens.home.components.OnSaleCategory
import ict.android.steamdex.ui.screens.home.components.PopularCategory
import ict.android.steamdex.ui.screens.home.components.TrendingCategory
import ict.android.steamdex.ui.theme.SteamDexTheme

// TODO handles empty games list
@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onProfileClick: () -> Unit,
    onEditClick: () -> Unit,
    onCategoryClick: (Int) -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val profile = uiState.profile

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
                        onEditClick,
                        Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            // TODO add contentDescription
                            contentDescription = null
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            SearchFAB(onSearchClick)
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                MostPlayedCategory(
                    uiState.mostPlayedGames,
                    { onCategoryClick(Category.MostPlayed.id) }
                )
            }

            item {
                TrendingCategory(
                    uiState.trendingGames,
                    { onCategoryClick(Category.Trending.id) }
                )
            }

            item {
                OnSaleCategory(
                    uiState.onSaleGames,
                    { onCategoryClick(Category.OnSale.id) }
                )
            }

            item {
                PopularCategory(
                    uiState.popularGames,
                    { onCategoryClick(Category.Popular.id) }
                )
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
private fun HomeScreenPreview(
    @PreviewParameter(HomePreviewParametersProvider::class) uiState: HomeUiState
) {
    val theme = isSystemInDarkTheme()
    SteamDexTheme(theme) {
        HomeScreen(
            uiState = uiState,
            onCategoryClick = {},
            onSearchClick = {},
            onProfileClick = {},
            onEditClick = {},
            modifier = Modifier.gradientBackground(theme)
        )
    }
}
