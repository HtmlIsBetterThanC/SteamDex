package ict.android.steamdex.ui.components

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ict.android.steamdex.models.ui.UiProfile
import ict.android.steamdex.ui.components.buttons.icons.BackArrowButton
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarLarge(
    backEnabled: Boolean,
    profileIconUrl: String,
    profileName: String,
    profileLevel: Int,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable { onProfileClick() },
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.size(80.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        // TODO test with a real image
                        SteamAsyncImage(
                            model = profileIconUrl,
                            modifier = Modifier
                                .clip(CircleShape)
                        )
                    }

                    Text(
                        text = profileName,
                        modifier = Modifier.basicMarquee(),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        },
        modifier = modifier,
        navigationIcon = { if (backEnabled) BackArrowButton(onBackClick) },
        actions = {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = profileLevel.toString(),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        },
        expandedHeight = 80.dp
    )
}

@PreviewSteam
@Composable
private fun TopAppBarLargePreview() {
    val profile = UiProfile(
        name = "allolla",
        iconUrl = "",
        level = 50,
        totalValue = 42069,
        totalGames = 500,
        totalHours = 890.5,
        playedGames = 290,
        countryCode = "CA",
        age = "8.0"
    )
    SteamDexTheme {
        Surface {
            TopAppBarLarge(
                backEnabled = true,
                profileIconUrl = profile.iconUrl,
                profileName = profile.name,
                profileLevel = profile.level,
                onProfileClick = {},
                onBackClick = {}
            )
        }
    }
}
