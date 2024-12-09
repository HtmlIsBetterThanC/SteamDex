package ict.android.steamdex.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.ScreenTopBar
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.providers.HomePreviewParametersProvider
import ict.android.steamdex.ui.screens.home.components.Carousel
import ict.android.steamdex.ui.screens.home.components.CategoryGamesBar
import ict.android.steamdex.ui.screens.home.components.SearchButton
import ict.android.steamdex.ui.theme.SteamDexTheme

// TODO handles empty games list
@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onCategoryClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val profile = uiState.profile
    val games = uiState.games

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                ScreenTopBar(
                    modifier = Modifier
                        .background(color = Color.Transparent),
                    profileIconUrl = profile.iconUrl,
                    profileName = profile.name,
                    profileLevel = profile.level,
                    onProfileClick = { },
                    actions = {
                        IconButton(
                            {},
                            Modifier.size(40.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
            item {
                CategoryGamesBar(
                    categoryIconId = R.drawable.leaderboard,
                    categoryIconDescriptionId = R.string.most_played_icon_description,
                    categoryTitleId = R.string.home_most_played_category,
                    onClick = { onCategoryClick(Category.MostPlayed.id) }
                )
            }
            item {
                Carousel(games = games, variant = true)
            }
            item {
                Carousel(games)
            }
            item {
                CategoryGamesBar(
                    categoryIconId = R.drawable.trending_up,
                    categoryIconDescriptionId = R.string.trending_up_icon_description,
                    categoryTitleId = R.string.home_trending_category,
                    onClick = { onCategoryClick(Category.Trending.id) }
                )
            }
            item {
                Carousel(games)
            }
            item {
                CategoryGamesBar(
                    categoryIconId = R.drawable.savings,
                    categoryIconDescriptionId = R.string.savings_icon_description,
                    categoryTitleId = R.string.home_on_sale_category,
                    onClick = { onCategoryClick(Category.OnSale.id) }
                )
            }
            item {
                CategoryGamesBar(
                    categoryIconId = R.drawable.popular,
                    categoryIconDescriptionId = R.string.popular_icon_description,
                    categoryTitleId = R.string.home_popular_category,
                    onClick = { onCategoryClick(Category.Popular.id) }
                )
            }
            item {
                Carousel(games)
            }
        }
        SearchButton(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
        )
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
    SteamDexTheme {
        HomeScreen(
            uiState,
            {}
        )
    }
}
