
package ict.android.steamdex.ui.screens.calculator

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.HeaderGameList
import ict.android.steamdex.ui.components.ProfileAdditionalDetail
import ict.android.steamdex.ui.components.TopAppBarLarge
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamGradient
import ict.android.steamdex.ui.preview.providers.CalculatorPreviewParametersProvider
import ict.android.steamdex.ui.screens.calculator.components.CalculatorAdditionalDetails
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun CalculatorScreen(
    uiState: CalculatorUiState,
    useGradientBackground: Boolean,
    onBackClick: () -> Unit,
    onGameClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val profile = uiState.profile
    Scaffold(
        modifier = modifier,
        containerColor = if (useGradientBackground) {
            (
                Color.Transparent
                )
        } else {
            MaterialTheme.colorScheme.background
        },
        topBar = {
            TopAppBarLarge(
                profile = profile,
                backEnabled = true,
                firstIconId = R.drawable.age,
                secondIconId = R.drawable.country_code,
                firstIconDescriptionId = R.string.profile_age_icon_description,
                secondIconDescriptionId = R.string.profile_country_code_description,
                firstDetails = profile.age,
                secondDetails = profile.countryCode,
                onBackClick = onBackClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // TODO fix the border of this component
            ProfileAdditionalDetail(
                totalValue = uiState.profile.totalValue,
                playedGames = uiState.profile.playedGames,
                totalGames = uiState.profile.totalGames,
                content = {
                    CalculatorAdditionalDetails(
                        totalHours = uiState.profile.totalHours,
                        todayValue = uiState.todayValue,
                        currentXpToNextLevel = uiState.currentXpToNextLevel,
                    )
                }
            )

            HeaderGameList(
                headerListName = R.string.header_title_owned_games,
                itemTitle = R.string.header_title_owned_games,
                firstParameterTitle = R.string.header_price_hour_parameter,
                secondParameterTitle = R.string.header_price_parameter,
                thirdParameterTitle = R.string.header_time_parameter,

                // TODO stolen from stackoverflow check if it's the correct way
                modifier = Modifier.layout { measurable, constraints ->
                    val placeable = measurable.measure( // this shit measure the component
                        constraints.copy( // this other shit create a new constraint set to be modified
                            maxWidth = constraints.maxWidth + 20.dp.roundToPx(), // the constrain modified in width
                        )
                    )
                    layout(placeable.width, placeable.height) {
                        placeable.place((0).dp.roundToPx(), 0) // where the modified component it's placed
                    }
                }
            )
        }
    }
}

@PreviewSteam
@Composable
private fun CalculatorScreenPreview(
    @PreviewParameter(CalculatorPreviewParametersProvider::class) uiState: CalculatorUiState
) {
    SteamDexTheme {
        CalculatorScreen(
            uiState = uiState,
            useGradientBackground = false,
            onBackClick = {},
            onGameClick = {},
        )
    }
}

@PreviewSteamGradient
@Composable
private fun CalculatorScreenGradientPreview(
    @PreviewParameter(CalculatorPreviewParametersProvider::class) uiState: CalculatorUiState
) {
    SteamDexTheme {
        CalculatorScreen(
            uiState = uiState,
            useGradientBackground = true,
            onBackClick = {},
            onGameClick = {},
            modifier = Modifier.gradientBackground(isSystemInDarkTheme())
        )
    }
}
