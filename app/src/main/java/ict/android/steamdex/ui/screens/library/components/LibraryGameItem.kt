package ict.android.steamdex.ui.screens.library.components

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.SteamAsyncImage
import ict.android.steamdex.ui.preview.PreviewData.games
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun LibraryGameItem(
    iconUrl: String,
    name: String,
    hoursPlayed: Double,
    onGameClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ListItem(
        headlineContent = {
            Column {
                Text(
                    text = name,
                    modifier = Modifier.basicMarquee(),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = stringResource(
                        R.string.library_screen_game_card_hours_played,
                        hoursPlayed
                    ),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        },
        leadingContent = {
            SteamAsyncImage(
                model = iconUrl,
                modifier = Modifier
                    .width(150.dp)
                    .height(80.dp),
                contentScale = ContentScale.Crop
            )
        },

        trailingContent = {
            Icon(
                Icons.Default.PlayArrow,
                contentDescription = stringResource(R.string.play_arrow_icon_description)
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .clickable { onGameClick() }
    )
}

@PreviewSteam
@Composable
private fun LibraryGameItemPreview() {
    val game = games[0]
    SteamDexTheme {
        Surface {
            game.hoursPlayed?.let {
                LibraryGameItem(
                    iconUrl = game.iconUrl,
                    name = game.name,
                    hoursPlayed = it,
                    onGameClick = {}
                )
            }
        }
    }
}
