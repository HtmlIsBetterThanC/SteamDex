package ict.android.steamdex.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ict.android.steamdex.data.repositories.SettingsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val settingsRepository: SettingsRepository) : ViewModel() {
    val darkTheme = settingsRepository.observeDarkTheme().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = runBlocking { settingsRepository.getDarkTheme() }
    )

    val pitchBlack = settingsRepository.observePitchBlack().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = runBlocking { settingsRepository.getPitchBlack() }
    )

    val materialYou = settingsRepository.observeMaterialYou().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = runBlocking { settingsRepository.getMaterialYou() }
    )

    val gradientBackground = settingsRepository.observeGradientBackground().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = runBlocking { settingsRepository.getGradientBackground() }
    )
}
