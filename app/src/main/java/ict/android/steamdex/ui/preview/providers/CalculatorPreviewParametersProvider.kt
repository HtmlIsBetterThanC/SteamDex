package ict.android.steamdex.ui.preview.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.screens.calculator.CalculatorUiState

class CalculatorPreviewParametersProvider : PreviewParameterProvider<CalculatorUiState> {
    override val values = sequenceOf(
        CalculatorUiState(
            profile = profiles[0],
            todayValue = 14542,
            currentXpToNextLevel = 239
        ),
        CalculatorUiState(
            profile = profiles[1],
            todayValue = 18234,
            currentXpToNextLevel = 412
        ),
        CalculatorUiState(
            profile = profiles[2],
            todayValue = 12876,
            currentXpToNextLevel = 186
        ),
        CalculatorUiState(
            profile = profiles[3],
            todayValue = 22345,
            currentXpToNextLevel = 567
        ),
        CalculatorUiState(
            profile = profiles[4],
            todayValue = 9654,
            currentXpToNextLevel = 95
        )
    )
}
