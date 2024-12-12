package ict.android.steamdex.data.repositories

import ict.android.steamdex.data.preferences.SteamPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Suppress("TooManyFunctions")
class SettingsRepositoryImpl @Inject constructor(private val preferences: SteamPreferences) : SettingsRepository {
    override suspend fun setFirstTime() {
        preferences.setFistTime()
    }

    override suspend fun updateDarkTheme(darkTheme: Boolean?) {
        preferences.setDarkTheme(darkTheme)
    }

    override suspend fun updatePitchBlack(pitchBlack: Boolean) {
        preferences.setPitchBlack(pitchBlack)
    }

    override suspend fun updateMaterialYou(materialYou: Boolean) {
        preferences.setMaterialYou(materialYou)
    }

    override suspend fun updateGradientBackground(gradientBackground: Boolean) {
        preferences.setGradientBackground(gradientBackground)
    }

    override suspend fun updateDefaultStartingScreen(screen: String) {
        preferences.setDefaultStartingScreen(screen)
    }

    override suspend fun isFirstTime(): Boolean {
        return preferences.isFirstTime()
    }

    override suspend fun getDarkTheme(): Boolean? {
        return preferences.getDarkTheme()
    }

    override suspend fun getPitchBlack(): Boolean {
        return preferences.getPitchBlack()
    }

    override suspend fun getMaterialYou(): Boolean {
        return preferences.getMaterialYou()
    }

    override suspend fun getGradientBackground(): Boolean {
        return preferences.getGradientBackground()
    }

    override suspend fun getDefaultStartingScreen(): String {
        return preferences.getDefaultStartingScreen()
    }

    override fun observeDarkTheme(): Flow<Boolean?> {
        return preferences.observableDarkTheme
    }

    override fun observePitchBlack(): Flow<Boolean> {
        return preferences.observablePithBlack
    }

    override fun observeMaterialYou(): Flow<Boolean> {
        return preferences.observableMaterialYou
    }

    override fun observeGradientBackground(): Flow<Boolean> {
        return preferences.observableGradientBackground
    }

    override suspend fun resetSettings() {
        preferences.deleteAll()
    }
}
