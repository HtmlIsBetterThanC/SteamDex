package ict.android.steamdex.ui.screens.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import ict.android.steamdex.ui.components.buttons.SecondaryButton
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.ScreenTopBar
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.screens.components.AssistiveChipsRow
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun GameScreen(
    uiState: GameUiState,
    onClickWhislist: () -> Unit,
    onClickFollow: () -> Unit,
    onClickIgnore: () -> Unit,
    onClickWatch: () -> Unit,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ScreenTopBar(
                useGradientBackground = true,
                profileIconUrl = uiState.profile.iconUrl,
                profileName = uiState.profile.name,
                profileLevel = uiState.profile.level,
                onProfileClick = onProfileClick,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AssistiveChipsRow(
                onClickWhislist = onClickWhislist,
                onClickFollow = onClickFollow,
                onClickIgnore = onClickIgnore,
                onClickWatch = onClickWatch
            )
        }
    }
}

@PreviewSteam
@Composable
private fun GameScreenPreview(
    @PreviewParameter(GamePreviewParameterProvider::class) uiState: GameUiState
) {
    SteamDexTheme {
        GameScreen(
            uiState = uiState,
            onClickWhislist = {},
            onClickFollow = {},
            onClickIgnore = {},
            onClickWatch = {},
            onProfileClick = {}
        )
    }
}