package ict.android.steamdex.ui.screens.home.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.screens.home.GamesCarousel

@Composable
fun Carousel(
    modifier: Modifier = Modifier
) {
    val games = listOf(
        GamesCarousel("Game title", 10, 1),
        GamesCarousel("Game title", 20, 2),
        GamesCarousel("Game title", 15, 3),
        GamesCarousel("Game title", 35, 4),
        GamesCarousel("Game title", 7, 5)
    )

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(games) { game ->
            GameCard(game)
        }
    }
}

@PreviewSteam
@Composable
private fun CarouselPreview() {
    val theme = isSystemInDarkTheme()
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .gradientBackground(theme)
        ) {
            Carousel()
        }
    }
}
