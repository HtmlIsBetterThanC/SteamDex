package ict.android.steamdex.data.repositories

import ict.android.steamdex.models.network.NetworkProfile

interface ProfileRepository {
    suspend fun getProfile(): NetworkProfile
    suspend fun getNumberOfFriends(): Int
    suspend fun getNextXpToLevelUp(): String
}
