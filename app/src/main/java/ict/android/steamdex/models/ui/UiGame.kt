package ict.android.steamdex.models.ui

import androidx.compose.runtime.Immutable
import kotlinx.datetime.LocalDate

// TODO maybe also add languages and franchise
@Immutable
data class UiGame(
    val id: Long = 1,
    val name: String = "",
    val iconUrl: String = "",
    val developer: String = "",
    val publisher: UiPublisher = UiPublisher(),
    val supportedSystems: List<String> = emptyList(),
    val releaseDate: LocalDate = LocalDate.parse("1970-01-01"),
    val price: String = "0",
    val currentPlayers: Double? = null,
    val ratings: Double? = null,
    val hoursPlayed: Double? = null,
    val genres: List<String> = emptyList()
)
