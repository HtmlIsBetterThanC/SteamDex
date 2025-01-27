package ict.android.steamdex.ui.screens.game

import GamePreviewParameterProvider
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.ScreenTopBar
import ict.android.steamdex.ui.components.SteamAsyncImage
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamGradient
import ict.android.steamdex.ui.screens.game.components.AssistiveChipsRow
import ict.android.steamdex.ui.screens.game.components.GameTitleHeader
import ict.android.steamdex.ui.screens.game.components.LineChart
import ict.android.steamdex.ui.screens.game.components.PrimaryButtonRow
import ict.android.steamdex.ui.screens.game.components.SecondaryButtonRow
import ict.android.steamdex.ui.screens.game.components.generateRandomFloats
import ict.android.steamdex.ui.theme.SteamDexTheme

@Suppress("LongParameterList")
@Composable
fun GameScreen(
    uiState: GameUiState,
    useGradientBackground: Boolean,
    charHorizontalAxisData: List<Number>,
    charVerticalAxisData: List<Number>,
    onClickWhitelist: () -> Unit,
    onClickFollow: () -> Unit,
    onClickIgnore: () -> Unit,
    onClickWatch: () -> Unit,
    onProfileClick: () -> Unit,
    onClickReviews: () -> Unit,
    onClickInGame: () -> Unit,
    onClickGameInfo: () -> Unit,
    onClickStore: () -> Unit,
    onClickHub: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ScreenTopBar(
                backEnabled = true,
                useGradientBackground = useGradientBackground,
                profileIconUrl = uiState.profile.iconUrl,
                profileName = uiState.profile.name,
                profileLevel = uiState.profile.level,
                onProfileClick = onProfileClick,
                onBackClick = onBackClick
            )
        },
        containerColor =
        if (useGradientBackground) {
            Color.Transparent
        } else {
            MaterialTheme.colorScheme.background
        },
        contentColor =
        if (useGradientBackground) {
            MaterialTheme.colorScheme.onBackground
        } else {
            contentColorFor(MaterialTheme.colorScheme.background)
        }
    ) { innerPadding ->
        if (uiState.isLoading) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(innerPadding),
                horizontalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AssistiveChipsRow(
                    onClickWhislist = onClickWhitelist,
                    onClickFollow = onClickFollow,
                    onClickIgnore = onClickIgnore,
                    onClickWatch = onClickWatch
                )
                SteamAsyncImage(
                    model = uiState.game.iconUrl,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                GameTitleHeader(
                    gameTitle = uiState.game.name,
                    modifier = Modifier.layout { measurable, constraints ->
                        val placeable = measurable.measure(
                            constraints.copy(
                                maxWidth = constraints.maxWidth + 20.dp.roundToPx(),
                            )
                        )
                        layout(placeable.width, placeable.height) {
                            placeable.place((0).dp.roundToPx(), 0)
                        }
                    }
                )
                PrimaryButtonRow(
                    leftButtonIconId = R.drawable.gamepad, // TODO put the right icon
                    rightButtonIconId = R.drawable.gamepad,
                    leftButtonLabel = R.string.reviews_button_label,
                    rightButtonLabel = R.string.in_game_counter,
                    leftButtonValue = "${uiState.game.ratings ?: "--.--"}%",
                    rightButtonValue = uiState.game.currentPlayers ?: 0,
                    onClickLeftButton = onClickReviews,
                    onClickRightButton = onClickInGame,
                )
                LineChart(
                    horizontalAxisData = charHorizontalAxisData,
                    verticalAxisData = charVerticalAxisData
                )

                SecondaryButtonRow(
                    firstLabel = R.string.game_screen_info, // TODO put the info icon
                    secondLabel = R.string.game_screen_store,
                    thirdLabel = R.string.game_screen_hub,
                    onClickFirst = onClickGameInfo,
                    onClickSecond = onClickStore,
                    onClickThird = onClickHub,
                )
            }
        }
    }
}

@PreviewSteam
@Composable
private fun GameScreenPreview(
    @PreviewParameter(GamePreviewParameterProvider::class) uiState: GameUiState
) {
    val year = (1..365).toList()
    val priceHistory = generateRandomFloats(365, 9.99f, 69.99f)
    SteamDexTheme {
        GameScreen(
            uiState = uiState,
            useGradientBackground = false,
            onClickWhitelist = {},
            onClickFollow = {},
            onClickIgnore = {},
            onClickWatch = {},
            onProfileClick = {},
            onClickReviews = {},
            onClickInGame = {},
            onClickGameInfo = {},
            onClickStore = {},
            onClickHub = {},
            onBackClick = {},
            charHorizontalAxisData = year,
            charVerticalAxisData = priceHistory
        )
    }
}

@PreviewSteamGradient
@Composable
private fun GameScreenGradientPreview(
    @PreviewParameter(GamePreviewParameterProvider::class) uiState: GameUiState
) {
    val year = (1..365).toList()
    val priceHistory = generateRandomFloats(365, 9.99f, 69.99f)
    SteamDexTheme {
        GameScreen(
            uiState = uiState,
            useGradientBackground = true,
            onClickWhitelist = {},
            onClickFollow = {},
            onClickIgnore = {},
            onClickWatch = {},
            onProfileClick = {},
            onClickReviews = {},
            onClickInGame = {},
            onClickGameInfo = {},
            onClickStore = {},
            onClickHub = {},
            onBackClick = {},
            charHorizontalAxisData = year,
            charVerticalAxisData = priceHistory,
            modifier = Modifier.gradientBackground(isSystemInDarkTheme())
        )
    }
}
