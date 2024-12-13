package ict.android.steamdex.data.repositories

import ict.android.steamdex.data.preferences.SteamPreferences
import jakarta.inject.Inject

class GameRepositoryImpl @Inject constructor(private val preferences: SteamPreferences) : GameRepository {
    override suspend fun isMostPlayedGamesExpanded(): Boolean {
        return preferences.getMostPlayedGamesExpanded()
    }

    override suspend fun isTrendingGamesExpanded(): Boolean {
        return preferences.getTrendingGamesExpanded()
    }

    override suspend fun isOnSaleGamesExpanded(): Boolean {
        return preferences.getOnSaleGamesExpanded()
    }

    override suspend fun isPopularGamesExpanded(): Boolean {
        return preferences.getPopularGamesExpanded()
    }

    override suspend fun setMostPlayedGamesExpanded(expanded: Boolean) {
        preferences.setMostPlayedGamesExpanded(expanded)
    }

    override suspend fun setTrendingGamesExpanded(expanded: Boolean) {
        preferences.setTrendingGamesExpanded(expanded)
    }

    override suspend fun setOnSaleGamesExpanded(expanded: Boolean) {
        preferences.setOnSaleGamesExpanded(expanded)
    }

    override suspend fun setPopularGamesExpanded(expanded: Boolean) {
        preferences.setPopularGamesExpanded(expanded)
    }
}
