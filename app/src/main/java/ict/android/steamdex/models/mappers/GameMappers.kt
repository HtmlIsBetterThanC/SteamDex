package ict.android.steamdex.models.mappers

import ict.android.steamdex.models.network.NetworkGame
import ict.android.steamdex.models.ui.UiGame

fun NetworkGame.toUiModel(): UiGame {
    return UiGame(
        id = id,
        name = name,
        iconUrl = iconUrl,
        developer = developer,
        publisher = publisher.toUiModel(),
        supportedSystems = supportedSystems,
        releaseDate = releaseDate,
        price = price,
        currentPlayers = currentPlayers,
        ratings = ratings,
        hoursPlayed = hoursPlayed,
        genres = genres
    )
}

fun UiGame.toNetworkModel(): NetworkGame {
    return NetworkGame(
        id = id,
        name = name,
        iconUrl = iconUrl,
        developer = developer,
        publisher = publisher.toNetworkModel(),
        supportedSystems = supportedSystems,
        releaseDate = releaseDate,
        price = price,
        currentPlayers = currentPlayers,
        ratings = ratings,
        hoursPlayed = hoursPlayed,
        genres = genres
    )
}

fun List<NetworkGame>.toUiModel() = this.map { it.toUiModel() }

fun List<UiGame>.toNetworkModel() = this.map { it.toNetworkModel() }
