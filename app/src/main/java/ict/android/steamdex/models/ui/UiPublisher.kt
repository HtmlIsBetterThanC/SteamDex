package ict.android.steamdex.models.ui

import androidx.compose.runtime.Immutable

@Immutable
data class UiPublisher(
    val name: String,
    val gamesIds: List<Long>
)
