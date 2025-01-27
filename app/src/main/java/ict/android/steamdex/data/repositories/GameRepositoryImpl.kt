package ict.android.steamdex.data.repositories

import ict.android.steamdex.data.preferences.SteamPreferences
import ict.android.steamdex.di.IoDispatcher
import ict.android.steamdex.models.network.NetworkGame
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GameRepositoryImpl @Inject constructor(
    private val preferences: SteamPreferences,
    private val httpClient: HttpClient,
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
            return@withContext httpClient.get("games/mostplayed").body()
        }
    }

    override suspend fun getTrendingGames(): List<NetworkGame> {
        return withContext(ioDispatcher) {
            return@withContext httpClient.get("games/trending").body()
        }
    }

    override suspend fun getOnSaleGames(): List<NetworkGame> {
        return withContext(ioDispatcher) {
            return@withContext httpClient.get("games/onsale").body()
        }
    }

    override suspend fun getPopularGames(): List<NetworkGame> {
        return withContext(ioDispatcher) {
            return@withContext httpClient.get("games/popular").body()
        }
    }

    override suspend fun getOwnedGames(): List<NetworkGame> {
        return withContext(ioDispatcher) {
            return@withContext httpClient.get("games/owned").body()
        }
    }

    override suspend fun getGame(id: Long): NetworkGame {
        return withContext(ioDispatcher) {
            return@withContext httpClient.get("game/$id").body()
        }
    }
}
