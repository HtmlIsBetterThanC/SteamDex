package ict.android.steamdex.data.repositories

import ict.android.steamdex.di.IoDispatcher
import ict.android.steamdex.models.network.NetworkProfile
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ProfileRepository {
    override suspend fun getProfile(): NetworkProfile {
        return withContext(ioDispatcher) {
            return@withContext httpClient.get("profile").body()
        }
    }

    override suspend fun getNumberOfFriends(): Int {
        return 124
    }

    override suspend fun getNextXpToLevelUp(): String {
        return "25"
    }
}
