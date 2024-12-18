package ict.android.steamdex.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ict.android.steamdex.data.repositories.SettingsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val settingsRepository: SettingsRepository) : ViewModel() {
    private val _isSplashScreenRunning = MutableStateFlow(true)
    val isSplashScreenRunning = _isSplashScreenRunning.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1800L)
            _isSplashScreenRunning.update {
                false
            }
        }
    }

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
