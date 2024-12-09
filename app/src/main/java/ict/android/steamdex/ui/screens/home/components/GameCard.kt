package ict.android.steamdex.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    name: String,
    currentPlayers: Double,
    iconUrl: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(150.dp)
            .height(200.dp),
        shape = RoundedCornerShape(28.dp)
    ) {
        Box(Modifier.fillMaxSize()) {
            SteamAsyncImage(
                model = iconUrl,
                modifier = Modifier.fillMaxSize(),
                // TODO is this the better one?
                contentScale = ContentScale.FillHeight
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.5f)
                            )
                        )
                    )
            )
            Column(
                Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Text(
                    text = name,
                    modifier = Modifier.basicMarquee(),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(R.string.home_currently_playing, currentPlayers),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@PreviewSteam
@Composable
private fun GameCardPreview() {
    val game = games.first()
    SteamDexTheme {
        Surface {
            GameCard(
                name = game.name,
                currentPlayers = game.currentPlayers!!,
                iconUrl = game.iconUrl
            )
        }
    }
}
