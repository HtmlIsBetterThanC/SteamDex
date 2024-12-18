package ict.android.steamdex.ui.screens.explore.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.carousel.CarouselState
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ict.android.steamdex.models.ui.UiGame
import ict.android.steamdex.ui.preview.PreviewData.games
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HorizontalCarousel(
    games: List<UiGame>,
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    state: CarouselState = rememberCarouselState { games.count() },
    large: Boolean = false
) {
    HorizontalMultiBrowseCarousel(
        state = state,
        preferredItemWidth = if (large) 316.dp else 164.dp,
        modifier = modifier,
        itemSpacing = 8.dp,
        contentPadding = PaddingValues(16.dp)
    ) { i ->
        val game = games[i]
        // TODO what if currentPlayers is null
        game.currentPlayers?.let {
            GameCard(
                currentPlayers = it,
                iconUrl = game.iconUrl,
                onClick = { onClick(game.id) },
                modifier = Modifier
                    .height(205.dp)
                    .maskClip(MaterialTheme.shapes.extraLarge)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@PreviewSteam
@Composable
private fun HorizontalCarouselPreview() {
    SteamDexTheme {
        Surface {
            HorizontalCarousel(games, {})
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@PreviewSteam
@Composable
private fun HorizontalCarouselVariantPreview() {
    SteamDexTheme {
        Surface {
            HorizontalCarousel(games = games, {}, large = true)
        }
    }
}
