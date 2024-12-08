package ict.android.steamdex.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ui.components.ScreenTopBar
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.screens.home.components.Carousel
import ict.android.steamdex.ui.screens.home.components.CarouselVariant
import ict.android.steamdex.ui.screens.home.components.GamesOnSaleTopBar
import ict.android.steamdex.ui.screens.home.components.MostPlayedTopBar
import ict.android.steamdex.ui.screens.home.components.PopularGamesTopBar
import ict.android.steamdex.ui.screens.home.components.SearchButton
import ict.android.steamdex.ui.screens.home.components.TrendingGamesTopBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
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
                    profileIconUrl = "your_profile_icon_url",
                    profileName = "Steam User",
                    profileLevel = 25,
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
                MostPlayedTopBar()
            }
            item {
                CarouselVariant()
            }
            item {
                TrendingGamesTopBar()
            }
            item {
                Carousel()
            }
            item {
                GamesOnSaleTopBar()
            }
            item {
                Carousel()
            }
            item {
                PopularGamesTopBar()
            }
            item {
                Carousel()
            }
        }
        SearchButton(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
        )
    }
}

@PreviewSteam
@Composable
private fun HomeScreenPreview() {
    val theme = isSystemInDarkTheme()
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .gradientBackground(theme)
        ) {
            HomeScreen()
        }
    }
}
