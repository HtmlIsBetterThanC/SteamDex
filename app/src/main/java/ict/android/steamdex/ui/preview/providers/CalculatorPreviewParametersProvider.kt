package ict.android.steamdex.ui.preview.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.screens.calculator.CalculatorUiState

class CalculatorPreviewParametersProvider : PreviewParameterProvider<CalculatorUiState> {
    override val values = sequenceOf(
        CalculatorUiState(
            profile = profiles[0],
            todayValue = 2000.0,
            currentXpToNextLevel = 128
        ),
        CalculatorUiState(
            profile = profiles[1],
            todayValue = 1750.5,
            currentXpToNextLevel = 256
        ),
        CalculatorUiState(
            profile = profiles[2],
            todayValue = 2350.75,
            currentXpToNextLevel = 92
        ),
        CalculatorUiState(
            profile = profiles[3],
            todayValue = 1450.25,
            currentXpToNextLevel = 175
        ),
        CalculatorUiState(
            profile = profiles[4],
            todayValue = 2200.0,
            currentXpToNextLevel = 210
        )
    )
}
