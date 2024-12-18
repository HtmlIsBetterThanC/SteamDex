package ict.android.steamdex.ui.preview

import ict.android.steamdex.models.ui.UiGame
import ict.android.steamdex.models.ui.UiProfile
import ict.android.steamdex.models.ui.UiPublisher
import kotlinx.datetime.LocalDate

object PreviewData {
    val profiles = listOf(
        UiProfile(
            name = "Davanker",
            iconUrl = "https://avatars.cloudflare.steamstatic.com/f1709bbe276101f1b625f0aaec5a5c347dfb7a70_full.jpg",
            level = 49,
            totalValue = 11223,
            totalGames = 993,
            totalHours = 2927.0,
            playedGames = 289,
            countryCode = "IT",
            age = "12.4 years"
        ),
        UiProfile(
            name = "Asuka_Unit02",
            iconUrl = "https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/" +
                "items/216150/5933160d2b734175fd7e7adbeb894fc1b4a02f08.gif",
            level = 78,
            totalValue = 17654,
            totalGames = 1567,
            totalHours = 4876.2,
            playedGames = 1322,
            countryCode = "DE",
            age = "9.8 years"
        ),
        UiProfile(
            name = "NobodyKnownThatIAmSuS",
            iconUrl = "https://avatars.cloudflare.steamstatic.com/fba2f7ffa02a5501d1fdee81221d87b4504a6159_full.jpg",
            level = 33,
            totalValue = 6789,
            totalGames = 567,
            totalHours = 1845.3,
            playedGames = 156,
            countryCode = "CA",
            age = "11.7 years"
        ),
        UiProfile(
            name = "x%x_st1ll_w4t3t_x%x",
            iconUrl = "https://avatars.cloudflare.steamstatic.com/cf1cd9cddd1a03bc6bbd6aadb67f39ec6cd08e0c_full.jpg",
            level = 2001,
            totalValue = 28345,
            totalGames = 2345,
            totalHours = 7896.7,
            playedGames = 589,
            countryCode = "US",
            age = "12.9 years"
        ),
        UiProfile(
            name = "Shinji_Unit01",
            iconUrl = "https://avatars.cloudflare.steamstatic.com/b765087933ca51334eb486605e0be4d46a135343_full.jpg",
            level = 66,
            totalValue = 14567,
            totalGames = 1314,
            totalHours = 3945.7,
            playedGames = 38,
            countryCode = "JP",
            age = "14.6 years"
        )
    )

    private val gamesNameAndId = listOf<Pair<Long, String>>(
        Pair(730, "Counter-Strike 2"),
        Pair(570, "Dota 2"),
        Pair(578080, "PUBG: BATTLEGROUNDS"),
        Pair(2694490, "Path of Exile 2"),
        Pair(2767030, "Marvel Rivals"),
        Pair(1203220, "NARAKA: BLADEPOINT"),
        Pair(2923300, "Banana"),
        Pair(271590, "Grand Theft Auto V"),
        Pair(252490, "Rust"),
        Pair(1172470, "Apex Legends")

    )

    val publishers = listOf(
        UiPublisher(
            name = "Valve",
            gamesIds = listOf(gamesNameAndId[0].first, gamesNameAndId[1].first)

        ),
        UiPublisher(
            name = "KRAFTON, Inc.",
            gamesIds = listOf(gamesNameAndId[2].first)
        ),
        UiPublisher(
            name = "Grinding Gear Games",
            gamesIds = listOf(gamesNameAndId[3].first)

        ),
        UiPublisher(
            name = "NetEase Games",
            gamesIds = listOf(gamesNameAndId[4].first, gamesNameAndId[5].first)
        ),
        UiPublisher(
            name = "Sky",
            gamesIds = listOf(gamesNameAndId[6].first)

        ),
        UiPublisher(
            name = "Rockstar Games",
            gamesIds = listOf(gamesNameAndId[7].first)
        ),
        UiPublisher(
            name = "Facepunch Studios",
            gamesIds = listOf(gamesNameAndId[8].first)
        ),
        UiPublisher(
            name = "Electronic Arts",
            gamesIds = listOf(gamesNameAndId[9].first)
        ),

    )

    val games = listOf(
        UiGame(
            id = gamesNameAndId[0].first,
            name = gamesNameAndId[0].second,
            iconUrl = "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/" +
                "${gamesNameAndId[0].first}/header.jpg",
            developer = "Valve",
            publisher = publishers[0],
            supportedSystems = listOf("Windows", "Linux"),
            releaseDate = LocalDate.parse("2012-08-21"),
            price = "0",
            currentPlayers = 817.141,
            ratings = 86.62,
            genres = listOf("Action", "Free to play")
        ),
        UiGame(
            id = gamesNameAndId[1].first,
            name = gamesNameAndId[1].second,
            iconUrl = "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/" +
                "${gamesNameAndId[1].first}/header.jpg",
            developer = "Valve",
            publisher = publishers[1],
            supportedSystems = listOf("Windows", "macOS", "Linux"),
            releaseDate = LocalDate.parse("2013-07-09"),
            price = "0",
            currentPlayers = 333.253,
            ratings = 81.27,
            genres = listOf("Action", "Strategy", "Free to play")
        ),
        UiGame(
            id = gamesNameAndId[2].first,
            name = gamesNameAndId[2].second,
            iconUrl = "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/" +
                "${gamesNameAndId[2].first}/header.jpg",
            developer = "PUBG Corporation",
            publisher = publishers[1],
            supportedSystems = listOf("Windows"),
            releaseDate = LocalDate.parse("2017-12-21"),
            price = "0",
            currentPlayers = 359.693,
            ratings = 58.87,
            genres = listOf("Action", "Adventure", "Massively Multiplayer", "Free to play")
        ),
        UiGame(
            id = gamesNameAndId[3].first,
            name = gamesNameAndId[3].second,
            iconUrl = "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/" +
                "${gamesNameAndId[3].first}/header.jpg",
            developer = "Grinding Gear Games",
            publisher = publishers[2],
            supportedSystems = listOf("Windows"),
            releaseDate = LocalDate.parse("2024-12-31"),
            price = "0",
            currentPlayers = 214.281,
            ratings = 80.29,
            genres = listOf("Action", "Adventure", "Massively Multiplayer", "RPG", "Early Access")
        ),
        UiGame(
            id = gamesNameAndId[4].first,
            name = gamesNameAndId[4].second,
            iconUrl = "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/" +
                "${gamesNameAndId[4].first}/header.jpg",
            developer = "NetEase Games",
            publisher = publishers[3],
            supportedSystems = listOf("Windows"),
            releaseDate = LocalDate.parse("2024-12-06"),
            price = "0",
            currentPlayers = 200.081,
            ratings = 75.15,
            genres = listOf("Action", "Free To Play")
        ),
        UiGame(
            id = gamesNameAndId[5].first,
            name = gamesNameAndId[5].second,
            iconUrl = "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/" +
                "${gamesNameAndId[5].first}/header.jpg",
            developer = "24 Entertainment",
            publisher = publishers[3],
            supportedSystems = listOf("Windows, Linux"),
            releaseDate = LocalDate.parse("2021-08-12"),
            price = "0",
            currentPlayers = 140.793,
            ratings = 69.70,
            genres = listOf("Action", "Adventure", "Massively Multiplayer")
        ),
        UiGame(
            id = gamesNameAndId[6].first,
            name = gamesNameAndId[6].second,
            iconUrl = "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/" +
                "${gamesNameAndId[6].first}/header.jpg",
            developer = "Sky, AestheticSpartan, O'Brian",
            publisher = publishers[4],
            supportedSystems = listOf("Windows, Linux"),
            releaseDate = LocalDate.parse("2024-04-23"),
            price = "0",
            currentPlayers = 99.209,
            ratings = 81.84,
            genres = listOf("Adventure, Casual", "Simulation", "Strategy", "Free To Play")
        ),
        UiGame(
            id = gamesNameAndId[7].first,
            name = gamesNameAndId[7].second,
            iconUrl = "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/" +
                "${gamesNameAndId[7].first}/header.jpg",
            developer = "Rockstar North",
            publisher = publishers[5],
            supportedSystems = listOf("Windows"),
            releaseDate = LocalDate.parse("2015-04-15"),
            price = "29,98€",
            currentPlayers = 92.764,
            ratings = 86.61,
            genres = listOf("Action", "Adventure")
        ),
        UiGame(
            id = gamesNameAndId[8].first,
            name = gamesNameAndId[8].second,
            iconUrl = "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/" +
                "${gamesNameAndId[8].first}/header.jpg",
            developer = "Facepunch Studios",
            publisher = publishers[6],
            supportedSystems = listOf("Windows, macOS"),
            releaseDate = LocalDate.parse("2018-02-08"),
            price = "39,99€",
            currentPlayers = 71.383,
            ratings = 86.67,
            genres = listOf("Action", "Adventure", "Indie", "Massively Multiplayer", "RPG")
        ),
        UiGame(
            id = gamesNameAndId[9].first,
            name = gamesNameAndId[9].second,
            iconUrl = "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/" +
                "${gamesNameAndId[9].first}/header.jpg",
            developer = "Respawn",
            publisher = publishers[7],
            supportedSystems = listOf("Windows"),
            releaseDate = LocalDate.parse("2020-11-05"),
            price = "0",
            currentPlayers = 66.070,
            ratings = 67.35,
            genres = listOf("Action", "Adventure", "Free To Play")
        ),
    )
}
