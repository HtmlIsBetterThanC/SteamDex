package ict.android.steamdex.ui.preview.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.screens.calculator.CalculatorUiState

class CalculatorPreviewParametersProvider : PreviewParameterProvider<CalculatorUiState> {
    override val values = sequenceOf(
        CalculatorUiState(
            profiles[0],
            todayValue = 2000.0,
            totalValue = 4500.0,
            gamesPlayed = 300,
            currentXpToNextLevel = 128
        ),
        CalculatorUiState(
            profiles[1],
            todayValue = 1750.5,
            totalValue = 5200.0,
            gamesPlayed = 275,
            currentXpToNextLevel = 214
        ),
        CalculatorUiState(
            profiles[2],
            todayValue = 3100.2,
            totalValue = 6800.5,
            gamesPlayed = 412,
            currentXpToNextLevel = 87
        ),
        CalculatorUiState(
            profiles[3],
            todayValue = 1250.7,
            totalValue = 3675.3,
            gamesPlayed = 189,
            currentXpToNextLevel = 256
        ),
        CalculatorUiState(
            profiles[4],
            todayValue = 2450.3,
            totalValue = 5900.1,
            gamesPlayed = 347,
            currentXpToNextLevel = 173
        )
    )
}