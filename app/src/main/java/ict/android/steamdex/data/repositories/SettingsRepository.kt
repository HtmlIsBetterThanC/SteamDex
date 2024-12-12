package ict.android.steamdex.data.repositories

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun setFirstTime()
    suspend fun updateDarkTheme(darkTheme: Boolean?)
    suspend fun updatePitchBlack(pitchBlack: Boolean)
    suspend fun updateMaterialYou(materialYou: Boolean)
    suspend fun updateGradientBackground(gradientBackground: Boolean)

    suspend fun isFirstTime(): Boolean
    suspend fun getDarkTheme(): Boolean?
    suspend fun getPitchBlack(): Boolean
    suspend fun getMaterialYou(): Boolean
    suspend fun getGradientBackground(): Boolean

    fun observeDarkTheme(): Flow<Boolean?>
    fun observePitchBlack(): Flow<Boolean>
    fun observeMaterialYou(): Flow<Boolean>
    fun observeGradientBackground(): Flow<Boolean>
}
