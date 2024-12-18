package ict.android.steamdex.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import ict.android.steamdex.ext.getValue
import ict.android.steamdex.ext.observeValue
import ict.android.steamdex.ext.setValue
import ict.android.steamdex.ext.toNullableBoolean
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Suppress("TooManyFunctions")
@Singleton
class SteamPreferences @Inject constructor(@ApplicationContext private val context: Context) {
    private val dataStore = context.dataStore

    val observableDarkTheme = dataStore.observeValue(DARK_THEME_KEY).map { it?.toNullableBoolean() }
    val observablePithBlack = dataStore.observeValue(PITCH_BLACK_KEY).map { it ?: false }
    val observableMaterialYou = dataStore.observeValue(MATERIAL_YOU_KEY).map { it ?: false }
    val observableGradientBackground = dataStore.observeValue(GRADIENT_BACKGROUND_KEY).map { it ?: true }

    suspend fun isFirstTime() = dataStore.getValue(FIRST_TIME_KEY, true)
    suspend fun setFistTime() = dataStore.setValue(FIRST_TIME_KEY, false)

    suspend fun getDarkTheme() = dataStore.getValue(DARK_THEME_KEY, "null").toNullableBoolean()
    suspend fun setDarkTheme(darkTheme: Boolean?) = dataStore.setValue(DARK_THEME_KEY, darkTheme.toString())

    suspend fun getPitchBlack() = dataStore.getValue(PITCH_BLACK_KEY, false)
    suspend fun setPitchBlack(pitchBlack: Boolean) = dataStore.setValue(PITCH_BLACK_KEY, pitchBlack)

    suspend fun getMaterialYou() = dataStore.getValue(MATERIAL_YOU_KEY, false)
    suspend fun setMaterialYou(materialYou: Boolean) = dataStore.setValue(MATERIAL_YOU_KEY, materialYou)

    suspend fun getGradientBackground() = dataStore.getValue(GRADIENT_BACKGROUND_KEY, true)
    suspend fun setGradientBackground(gradientBackground: Boolean) = dataStore.setValue(
        GRADIENT_BACKGROUND_KEY,
        gradientBackground
    )
    suspend fun getDefaultStartingScreen() = dataStore.getValue(DEFAULT_STARTING_SCREEN_KEY, "")
    suspend fun setDefaultStartingScreen(screen: String) = dataStore.setValue(
        DEFAULT_STARTING_SCREEN_KEY,
        screen
    )

    suspend fun getMostPlayedGamesExpanded() = dataStore.getValue(MOST_PLAYED_GAMES_EXPANDED_KEY, true)
    suspend fun setMostPlayedGamesExpanded(expanded: Boolean) =
        dataStore.setValue(MOST_PLAYED_GAMES_EXPANDED_KEY, expanded)

    suspend fun getTrendingGamesExpanded() = dataStore.getValue(TRENDING_GAMES_EXPANDED_KEY, false)
    suspend fun setTrendingGamesExpanded(expanded: Boolean) =
        dataStore.setValue(TRENDING_GAMES_EXPANDED_KEY, expanded)

    suspend fun getOnSaleGamesExpanded() = dataStore.getValue(ON_SALE_GAMES_EXPANDED_KEY, false)
    suspend fun setOnSaleGamesExpanded(expanded: Boolean) =
        dataStore.setValue(ON_SALE_GAMES_EXPANDED_KEY, expanded)

    suspend fun getPopularGamesExpanded() = dataStore.getValue(POPULAR_GAMES_EXPANDED_KEY, false)
    suspend fun setPopularGamesExpanded(expanded: Boolean) =
        dataStore.setValue(POPULAR_GAMES_EXPANDED_KEY, expanded)

    suspend fun deleteAll() {
        dataStore.edit { it.clear() }
    }

    private companion object {
        private val FIRST_TIME_KEY = booleanPreferencesKey("firstTime")
        private val DARK_THEME_KEY = stringPreferencesKey("darkTheme")
        private val PITCH_BLACK_KEY = booleanPreferencesKey("pitchBlack")
        private val MATERIAL_YOU_KEY = booleanPreferencesKey("materialYou")
        private val GRADIENT_BACKGROUND_KEY = booleanPreferencesKey("gradientBackground")
        private val DEFAULT_STARTING_SCREEN_KEY = stringPreferencesKey("defaultStartingScreen")
        private val MOST_PLAYED_GAMES_EXPANDED_KEY = booleanPreferencesKey("mostPlayedGamesExpanded")
        private val TRENDING_GAMES_EXPANDED_KEY = booleanPreferencesKey("trendingGamesExpanded")
        private val ON_SALE_GAMES_EXPANDED_KEY = booleanPreferencesKey("onSaleGamesExpanded")
        private val POPULAR_GAMES_EXPANDED_KEY = booleanPreferencesKey("popularGamesExpanded")
    }
}
