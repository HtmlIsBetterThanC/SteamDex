package ict.android.steamdex.ui.screens.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.SteamAsyncImage
import ict.android.steamdex.ui.preview.PreviewData.games
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun GameCard(
    currentPlayers: Double,
    iconUrl: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize().clickable { onClick() }) {
        SteamAsyncImage(
            model = iconUrl,
            modifier = Modifier.fillMaxSize(),
            // TODO is this the better one?
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.5F)
                        )
                    )
                )
        )
        Column(
            Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
                .clip(MaterialTheme.shapes.medium)
        ) {
            // TODO add background color to column or remove text
            Text(
                text = stringResource(R.string.explore_screen_currently_playing, currentPlayers),
                color = MaterialTheme.colorScheme.primaryContainer,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@PreviewSteam
@Composable
private fun GameCardPreview() {
    val game = games.first()
    SteamDexTheme {
        Surface {
            game.currentPlayers?.let {
                GameCard(
                    currentPlayers = it,
                    iconUrl = game.iconUrl,
                    onClick = {}
                )
            }
        }
    }
}
