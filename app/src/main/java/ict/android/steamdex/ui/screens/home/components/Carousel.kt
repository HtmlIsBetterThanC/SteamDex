package ict.android.steamdex.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ict.android.steamdex.models.ui.UiGames
import ict.android.steamdex.ui.preview.PreviewData.games
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun Carousel(
    games: List<UiGames>,
    modifier: Modifier = Modifier,
    variant: Boolean = false
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(games) { game ->
            game.currentPlayers?.let {
                GameCard(
                    name = game.name,
                    currentPlayers = it,
                    iconUrl = game.iconUrl,
                    modifier = if (variant) Modifier.width(300.dp).height(200.dp) else Modifier
                )
            }
        }
    }
}

@PreviewSteam
@Composable
private fun CarouselPreview() {
    SteamDexTheme {
        Surface {
            Carousel(games)
        }
    }
}

@PreviewSteam
@Composable
private fun CarouselVariantPreview() {
    SteamDexTheme {
        Surface {
            Carousel(games = games, variant = true)
        }
    }
}
