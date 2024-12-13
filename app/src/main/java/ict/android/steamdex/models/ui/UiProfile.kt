package ict.android.steamdex.models.ui

import androidx.compose.runtime.Immutable

@Immutable
data class UiProfile(
    val name: String = "",
    val iconUrl: String = "",
    val level: Int = 0,
    val totalValue: Int = 0,
    val totalGames: Int = 0,
    val totalHours: Double = 0.0,
    val playedGames: Int = 0,
    val countryCode: String = "",
    val age: String = ""
)
