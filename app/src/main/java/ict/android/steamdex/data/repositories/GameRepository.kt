package ict.android.steamdex.data.repositories

import ict.android.steamdex.models.network.NetworkGame

interface GameRepository {
    suspend fun isMostPlayedGamesExpanded(): Boolean
    suspend fun isTrendingGamesExpanded(): Boolean
    suspend fun isOnSaleGamesExpanded(): Boolean
    suspend fun isPopularGamesExpanded(): Boolean

    suspend fun setMostPlayedGamesExpanded(expanded: Boolean)
    suspend fun setTrendingGamesExpanded(expanded: Boolean)
    suspend fun setOnSaleGamesExpanded(expanded: Boolean)
    suspend fun setPopularGamesExpanded(expanded: Boolean)

    suspend fun getMostPlayedGames(): List<NetworkGame>
    suspend fun getTrendingGames(): List<NetworkGame>
    suspend fun getOnSaleGames(): List<NetworkGame>
    suspend fun getPopularGames(): List<NetworkGame>

    suspend fun getOwnedGames(): List<NetworkGame>
    suspend fun getGame(id: Long): NetworkGame
}
