package ict.android.steamdex.data.repositories

interface GameRepository {
    suspend fun isMostPlayedGamesExpanded(): Boolean
    suspend fun isTrendingGamesExpanded(): Boolean
    suspend fun isOnSaleGamesExpanded(): Boolean
    suspend fun isPopularGamesExpanded(): Boolean

    suspend fun setMostPlayedGamesExpanded(expanded: Boolean)
    suspend fun setTrendingGamesExpanded(expanded: Boolean)
    suspend fun setOnSaleGamesExpanded(expanded: Boolean)
    suspend fun setPopularGamesExpanded(expanded: Boolean)
}
