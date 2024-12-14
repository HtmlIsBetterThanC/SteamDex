package ict.android.steamdex.models.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPublisher(
    @SerialName("name")
    val name: String,
    @SerialName("gamesId")
    val gamesIds: List<Long>
)
