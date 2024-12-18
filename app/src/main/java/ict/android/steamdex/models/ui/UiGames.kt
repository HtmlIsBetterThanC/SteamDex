package ict.android.steamdex.models.ui

import androidx.compose.runtime.Immutable
import kotlinx.datetime.LocalDate

// TODO maybe also add languages and franchise
@Immutable
data class UiGames(
    val id: Long,
    val name: String,
    val iconUrl: String,
    val developer: String,
    val publisher: UiPublisher,
    val supportedSystems: List<String>,
    val releaseDate: LocalDate,
    val price: String,
    val currentPlayers: Double? = null,
    val ratings: Double? = null,
    val hoursPlayed: Double? = null,
    // TODO might remove this
    val genres: List<String> = emptyList()
)
