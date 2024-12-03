package ict.android.steamdex.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.TopAppBarLarge
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.screens.profile.components.SettingsItem
import ict.android.steamdex.ui.screens.profile.components.SettingsList
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onSettingsItemClick: (SettingsItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val profile = uiState.profile
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarLarge(
                profile = profile,
                backEnabled = false,
                firstIconId = R.drawable.games_number,
                secondIconId = R.drawable.friends_number,
                firstIconDescriptionId = R.string.games_number_icon_description,
                secondIconDescriptionId = R.string.games_number_icon_description,
                firstDetails = profile.totalGames.toString(),
                secondDetails = uiState.totalFriends
            )
        }
    ) { innerPadding ->
        Column(
            Modifier.padding(innerPadding)
                .fillMaxSize()
        ) {
            SettingsList(onSettingsItemClick)
        }
    }
}

@PreviewSteam
@Composable
private fun ProfileScreenPreview() {
    SteamDexTheme {
        ProfileScreen(
            uiState = ProfileUiState(profiles.first(), "5"),
            {}
        )
    }
}
