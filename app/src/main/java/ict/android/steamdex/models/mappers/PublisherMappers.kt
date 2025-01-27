package ict.android.steamdex.models.mappers

import ict.android.steamdex.models.network.NetworkPublisher
import ict.android.steamdex.models.ui.UiPublisher

fun NetworkPublisher.toUiModel(): UiPublisher {
    return UiPublisher(
        name = name,
        gamesIds = gamesIds
    )
}

fun UiPublisher.toNetworkModel(): NetworkPublisher {
    return NetworkPublisher(
        name = name,
        gamesIds = gamesIds
    )
}
