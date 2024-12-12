package ict.android.steamdex.ui.screens.profile

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.BottomNavbar
import ict.android.steamdex.ui.components.ProfileAdditionalDetail
import ict.android.steamdex.ui.components.TopAppBarLarge
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamGradient
import ict.android.steamdex.ui.preview.providers.ProfilePreviewParametersProvider
import ict.android.steamdex.ui.screens.profile.components.CalculatorButton
import ict.android.steamdex.ui.screens.profile.components.SettingsItem
import ict.android.steamdex.ui.screens.profile.components.SettingsList
import ict.android.steamdex.ui.screens.profile.components.dialog.PitchBlackDialog
import ict.android.steamdex.ui.screens.profile.components.dialog.ResetDialog
import ict.android.steamdex.ui.screens.profile.components.dialog.ThemeDialog
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    useGradientBackground: Boolean,
    onCalculatorClick: () -> Unit,
    onLanguageChange: (String) -> Unit,
    onThemeChange: (Boolean?) -> Unit,
    onPitchBlackChange: (Boolean) -> Unit,
    onMaterialYouChange: (Boolean) -> Unit,
    onDefaultStartingScreenChange: (String) -> Unit,
    onResetSettingClick: () -> Unit,
    modifier: Modifier = Modifier,
    bottomBar: @Composable () -> Unit = {}
) {
    val profile = uiState.profile
    var showThemeDialog by remember {
        mutableStateOf(false)
    }
    var showPitchBlackDialog by remember {
        mutableStateOf(false)
    }
    var showResetDialog by remember {
        mutableStateOf(false)
    }
    val onSettingItemClick: (item: SettingsItem) -> Unit = {
        when (it.id) {
            1 -> {
                // TODO languages dialog
            }

            2 -> showThemeDialog = true

            3 -> showPitchBlackDialog = true

            4 -> {
                // TODO material you dialog
            }

            5 -> {
                // TODO default starting dialog
            }

            6 -> showResetDialog = true
        }
    }

    Scaffold(
        modifier = modifier,
        containerColor =
        if (useGradientBackground) Color.Transparent else MaterialTheme.colorScheme.background,
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
        },
        bottomBar = bottomBar
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            ProfileAdditionalDetail(
                totalValue = uiState.profile.totalValue,
                playedGames = uiState.profile.playedGames,
                totalGames = uiState.profile.totalGames,
                content = {
                    CalculatorButton(onCalculatorClick)
                }
            )
            Spacer(Modifier.height(8.dp))
            SettingsList(onSettingItemClick)
            ThemeDialog(
                showDialog = showThemeDialog,
                currentTheme = uiState.darkTheme,
                onDismissDialog = {
                    showThemeDialog = false
                },
                onThemeChange = onThemeChange
            )
            PitchBlackDialog(
                showDialog = showPitchBlackDialog,
                onDismissDialog = { showPitchBlackDialog = false },
                onPitchBlackActivateClick = { onPitchBlackChange(true) },
                onPitchBlackDeactivateClick = { onPitchBlackChange(false) }
            )
            ResetDialog(
                showDialog = showResetDialog,
                onDismissDialog = {
                    showResetDialog = false
                },
                onConfirmDialog = onResetSettingClick
            )
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
            uiState = uiState,
            useGradientBackground = false,
            onCalculatorClick = {},
            onLanguageChange = {},
            onThemeChange = {},
            onPitchBlackChange = {},
            onMaterialYouChange = {},
            onDefaultStartingScreenChange = {},
            onResetSettingClick = {},
            bottomBar = { BottomNavbar(rememberNavController()) },
        )
    }
}

@PreviewSteamGradient
@Composable
private fun ProfileScreenGradientPreview(
    @PreviewParameter(ProfilePreviewParametersProvider::class) uiState: ProfileUiState
) {
    SteamDexTheme {
        ProfileScreen(
            uiState = uiState,
            useGradientBackground = true,
            onCalculatorClick = {},
            onLanguageChange = {},
            onThemeChange = {},
            onPitchBlackChange = {},
            onMaterialYouChange = {},
            onDefaultStartingScreenChange = {},
            onResetSettingClick = {},
            modifier = Modifier.gradientBackground(isSystemInDarkTheme()),
            bottomBar = { BottomNavbar(rememberNavController()) }
        )
    }
}
