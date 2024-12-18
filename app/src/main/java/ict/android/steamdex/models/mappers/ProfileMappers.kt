package ict.android.steamdex.models.mappers

import ict.android.steamdex.models.network.NetworkProfile
import ict.android.steamdex.models.ui.UiProfile

fun NetworkProfile.toUiModel(): UiProfile {
    return UiProfile(
        name = name,
        iconUrl = iconUrl,
        level = level,
        totalValue = totalValue,
        totalGames = totalGames,
        totalHours = totalHours,
        playedGames = playedGames,
        countryCode = countryCode,
        age = age
    )
}

fun UiProfile.toNetworkModel(): NetworkProfile {
    return NetworkProfile(
        name = name,
        iconUrl = iconUrl,
        level = level,
        totalValue = totalValue,
        totalGames = totalGames,
        totalHours = totalHours,
        playedGames = playedGames,
        countryCode = countryCode,
        age = age
    )
}
