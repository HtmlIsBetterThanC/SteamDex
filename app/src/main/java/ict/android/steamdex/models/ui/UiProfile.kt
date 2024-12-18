package ict.android.steamdex.models.ui

import androidx.compose.runtime.Immutable
import ict.android.steamdex.ui.preview.PreviewData.profiles

@Immutable
data class UiProfile(
    val name: String = profiles[0].name,
    val iconUrl: String = profiles[0].iconUrl,
    val level: Int = profiles[0].level,
    val totalValue: Int = profiles[0].totalValue,
    val totalGames: Int = profiles[0].totalGames,
    val totalHours: Double = profiles[0].totalHours,
    val playedGames: Int = profiles[0].playedGames,
    val countryCode: String = profiles[0].countryCode,
    val age: String = profiles[0].age
)
