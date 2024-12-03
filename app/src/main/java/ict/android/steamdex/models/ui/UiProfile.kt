package ict.android.steamdex.models.ui

import androidx.compose.runtime.Immutable

@Immutable
data class UiProfile(
    val name: String,
    val iconUrl: String,
    val level: Int,
    val totalGames: Int,
    val totalHours: Double,
    val playedGames: Int,
    val countryCode: String,
    val age: String
)
