package ict.android.steamdex.data.repositories

import ict.android.steamdex.models.mappers.toNetworkModel
import ict.android.steamdex.models.network.NetworkProfile
import ict.android.steamdex.ui.preview.PreviewData.profiles
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor() : ProfileRepository {
    override suspend fun getProfile(): NetworkProfile {
        return profiles[3].toNetworkModel()
    }

    override suspend fun getNumberOfFriends(): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getTotalValue(): Double {
        TODO("Not yet implemented")
    }

    override suspend fun getCountry(): String {
        TODO("Not yet implemented")
    }

    override suspend fun getNextXpToLevelUp(): String {
        TODO("Not yet implemented")
    }
}
