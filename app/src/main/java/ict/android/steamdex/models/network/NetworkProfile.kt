package ict.android.steamdex.models.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkProfile(
    @SerialName("name")
    val name: String,
    @SerialName("iconUrl")
    val iconUrl: String,
    @SerialName("level")
    val level: Int,
    @SerialName("totalValue")
    val totalValue: Int,
    @SerialName("totalGames")
    val totalGames: Int,
    @SerialName("totalHours")
    val totalHours: Double,
    @SerialName("playedGames")
    val playedGames: Int,
    @SerialName("countryCode")
    val countryCode: String,
    @SerialName("age")
    val age: String
)

