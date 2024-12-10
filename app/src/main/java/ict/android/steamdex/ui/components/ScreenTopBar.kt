package ict.android.steamdex.ui.components

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTopBar(
    profileIconUrl: String,
    profileName: String,
    profileLevel: Int,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier,
    actions:
    @Composable
    (RowScope.() -> Unit) = {}
) {
    TopAppBar(
        title = {
            // TODO make clickable area bigger
            Row(
                Modifier
                    .padding(16.dp)
                    .clickable { onProfileClick() },
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SteamAsyncImage(profileIconUrl, Modifier.size(40.dp))
                Column {
                    Text(
                        profileName,
                        modifier = Modifier.basicMarquee(),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        profileLevel.toString(),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        },
        modifier = modifier.padding(end = 10.dp),
        actions = actions,
        expandedHeight = 80.dp,
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
    )
}

@PreviewSteam
@Composable
private fun ScreenTopBarPreview() {
    SteamDexTheme {
        Surface {
            ScreenTopBar(
                profileIconUrl = "",
                profileName = "Profile",
                profileLevel = 15,
                onProfileClick = { }
            )
        }
    }
}

@PreviewSteam
@Composable
private fun ScreenTopBarPreviewWithAction() {
    SteamDexTheme {
        Surface {
            ScreenTopBar(
                profileIconUrl = "",
                profileName = "Profile",
                profileLevel = 15,
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
    }
}
