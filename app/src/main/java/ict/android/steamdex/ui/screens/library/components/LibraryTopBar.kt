package ict.android.steamdex.ui.screens.library.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.models.ui.UiProfile
import ict.android.steamdex.ui.components.ScreenTopBar
import ict.android.steamdex.ui.components.buttons.PrimaryButton
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun LibraryTopBar(
    useGradientBackground: Boolean,
    profile: UiProfile,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ScreenTopBar(
        useGradientBackground = useGradientBackground,
        profileIconUrl = profile.iconUrl,
        profileName = profile.name,
        profileLevel = profile.level,
        onProfileClick = onProfileClick,
        modifier = modifier.fillMaxWidth(),
        actions = {
            PrimaryButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(10.dp)
            ) {
                Text(
                    stringResource(R.string.library_screen_all_games, profile.totalGames),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    )
}

@PreviewSteam
@Composable
private fun LibraryTopBarPreview() {
    val profile = profiles[2]
    SteamDexTheme {
        Surface {
            LibraryTopBar(
                useGradientBackground = false,
                profile = profile,
                onProfileClick = {}
            )
        }
    }
}
