package ict.android.steamdex.data.repositories

import ict.android.steamdex.models.mappers.toNetworkModel
import ict.android.steamdex.models.network.NetworkProfile
import ict.android.steamdex.ui.preview.PreviewData.profiles
import io.ktor.client.HttpClient
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(httpClient: HttpClient) : ProfileRepository {
    override suspend fun getProfile(): NetworkProfile {
        return profiles[0].toNetworkModel()
    }

    override suspend fun getNumberOfFriends(): Int {
        return 124
    }

    override suspend fun getNextXpToLevelUp(): String {
        return "25"
    }
}
