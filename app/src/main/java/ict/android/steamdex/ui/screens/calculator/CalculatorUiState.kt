package ict.android.steamdex.ui.screens.calculator

import androidx.compose.runtime.Immutable
import ict.android.steamdex.models.ui.UiProfile

@Immutable
data class CalculatorUiState(
    val profile: UiProfile,
    val totalValue: Double,
    val todayValue: Double,
    val gamesPlayed: Int,
    val currentXpToNextLevel: Int
    // TODO add game list
)
