package ict.android.steamdex.ui.screens.profile

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.TopAppBarLarge
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.providers.ProfilePreviewParametersProvider
import ict.android.steamdex.ui.screens.profile.components.CalculatorWidget
import ict.android.steamdex.ui.screens.profile.components.GradientBackground
import ict.android.steamdex.ui.screens.profile.components.SettingsItem
import ict.android.steamdex.ui.screens.profile.components.SettingsList
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onSettingsItemClick: (SettingsItem) -> Unit,
    onCalculatorWidgetButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // TODO change to the other gradient
    // Applying gradient on the whole screen for Dark Theme - DG
    // If it bugs out, remove and put it back on
    val isDarkTheme = isSystemInDarkTheme()
    val finalModifier = if (isDarkTheme) {
        modifier.then(GradientBackground.gameDetailsBackground)
    } else {
        modifier
    }

    val profile = uiState.profile
    Scaffold(
        modifier = finalModifier,
        containerColor = Color.Transparent,
        topBar = {
            TopAppBarLarge(
                profile = profile,
                backEnabled = false,
                firstIconId = R.drawable.games_number, // TODO discuss the usefulness of this data
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
                .padding(horizontal = 10.dp)
        ) {
            CalculatorWidget(
                profile = profile,
                onClickButton = onCalculatorWidgetButtonClick,
            )
            Spacer(modifier = Modifier.height(8.dp))
            SettingsList(onSettingsItemClick)
        }
    }
}

@PreviewSteam
@Composable
private fun ProfileScreenPreview(
    @PreviewParameter(ProfilePreviewParametersProvider::class) uiState: ProfileUiState
) {
    SteamDexTheme {
        ProfileScreen(
            uiState,
            {},
            {}
        )
    }
}
