package ict.android.steamdex.data.repositories

import ict.android.steamdex.data.preferences.SteamPreferences
import ict.android.steamdex.di.IoDispatcher
import ict.android.steamdex.models.mappers.toNetworkModel
import ict.android.steamdex.models.network.NetworkGame
import ict.android.steamdex.ui.preview.PreviewData.games
import io.ktor.client.HttpClient
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class GameRepositoryImpl @Inject constructor(
    private val preferences: SteamPreferences,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : GameRepository {
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

    override suspend fun getMostPlayedGames(): List<NetworkGame> {
        return withContext(ioDispatcher) {
            delay(5000L)
            return@withContext games.map { it.toNetworkModel() }
        }
    }

    override suspend fun getTrendingGames(): List<NetworkGame> {
        return withContext(ioDispatcher) {
            return@withContext games.subList(3, games.size).map { it.toNetworkModel() }
        }
    }

    override suspend fun getOnSaleGames(): List<NetworkGame> {
        return withContext(ioDispatcher) {
            return@withContext games.subList(0, 4).map { it.toNetworkModel() }
        }
    }

    override suspend fun getPopularGames(): List<NetworkGame> {
        return withContext(ioDispatcher) {
            return@withContext games.map { it.toNetworkModel() }
        }
    }

    override suspend fun getOwnedGames(): List<NetworkGame> {
        TODO("Not yet implemented")
    }

    override suspend fun getGame(id: Long): NetworkGame {
        TODO("Not yet implemented")
    }
}
