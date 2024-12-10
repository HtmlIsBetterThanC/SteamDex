package ict.android.steamdex.ui.screens.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.ScreenTopBar
import ict.android.steamdex.ui.components.SearchFAB
import ict.android.steamdex.ui.components.buttons.PrimaryButton
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.providers.HomePreviewParametersProvider
import ict.android.steamdex.ui.screens.home.components.CategoryGamesBar
import ict.android.steamdex.ui.screens.home.components.HorizontalCarousel
import ict.android.steamdex.ui.theme.SteamDexTheme

// TODO handles empty games list
@OptIn(ExperimentalMaterial3Api::class)
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
                Column {
                    CategoryGamesBar(
                        categoryIconId = R.drawable.leaderboard,
                        categoryIconDescriptionId = R.string.most_played_icon_description,
                        categoryTitleId = R.string.home_most_played_category,
                        onClick = { onCategoryClick(Category.MostPlayed.id) }
                    )
                }
            }

            item {
                Column {
                    CategoryGamesBar(
                        categoryIconId = R.drawable.trending_up,
                        categoryIconDescriptionId = R.string.trending_up_icon_description,
                        categoryTitleId = R.string.home_trending_category,
                        onClick = { onCategoryClick(Category.Trending.id) }
                    )
                    HorizontalCarousel(uiState.trendingGames)
                }
            }

            item {
                Column {
                    CategoryGamesBar(
                        categoryIconId = R.drawable.savings,
                        categoryIconDescriptionId = R.string.savings_icon_description,
                        categoryTitleId = R.string.home_on_sale_category,
                        onClick = { onCategoryClick(Category.OnSale.id) }
                    )
                    HorizontalCarousel(uiState.onSaleGames)
                }
            }

            item {
                Column {
                    CategoryGamesBar(
                        categoryIconId = R.drawable.popular,
                        categoryIconDescriptionId = R.string.popular_icon_description,
                        categoryTitleId = R.string.home_popular_category,
                        onClick = { onCategoryClick(Category.Popular.id) }
                    )
                    HorizontalCarousel(uiState.popularGames)
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
