package ict.android.steamdex.models.network

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkGame(
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("iconUrl")
    val iconUrl: String,
    @SerialName("developer")
    val developer: String,
    @SerialName("publisher")
    val publisher: NetworkPublisher,
    @SerialName("supportedSystems")
    val supportedSystems: List<String>,
    @SerialName("releaseDate")
    val releaseDate: LocalDate,
    @SerialName("price")
    val price: String,
    @SerialName("currentPlayers")
    val currentPlayers: Double? = null,
    @SerialName("ratings")
    val ratings: Double? = null,
    @SerialName("hoursPlayed")
    val hoursPlayed: Double? = null,
    @SerialName("genres")
    val genres: List<String> = emptyList()
)
