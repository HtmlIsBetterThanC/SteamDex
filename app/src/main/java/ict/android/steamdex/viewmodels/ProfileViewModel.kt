package ict.android.steamdex.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ict.android.steamdex.data.repositories.ProfileRepository
import ict.android.steamdex.data.repositories.SettingsRepository
import ict.android.steamdex.ext.fromRouteToString
import ict.android.steamdex.models.mappers.toUiModel
import ict.android.steamdex.ui.screens.profile.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<ProfileUiState> = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.asStateFlow()

    fun start() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    profile = profileRepository.getProfile().toUiModel(),
                    totalFriends = profileRepository.getNumberOfFriends().toString(),
                    darkTheme = settingsRepository.getDarkTheme(),
                    defaultStartingScreen = settingsRepository.getDefaultStartingScreen()
                )
            }
        }
    }

    fun updateLanguage(language: String) {
        // TODO implement language change
        viewModelScope.launch {
            _uiState.update {
                it.copy(language = language)
            }
        }
    }

    fun updateDarkTheme(darkTheme: Boolean?) {
        viewModelScope.launch {
            settingsRepository.updateDarkTheme(darkTheme)
            _uiState.update {
                it.copy(darkTheme = darkTheme)
            }
        }
    }

    fun updatePitchBlack(pitchBlack: Boolean) {
        viewModelScope.launch {
            settingsRepository.updatePitchBlack(pitchBlack)
        }
    }

    fun updateMaterialYou(materialYou: Boolean) {
        viewModelScope.launch {
            settingsRepository.updateMaterialYou(materialYou)
        }
    }

    fun updateGradientBackground(gradientBackground: Boolean) {
        viewModelScope.launch {
            settingsRepository.updateGradientBackground(gradientBackground)
        }
    }

    fun updateDefaultStartingScreen(screen: Any) {
        viewModelScope.launch {
            settingsRepository.updateDefaultStartingScreen(screen.fromRouteToString())
            _uiState.update {
                it.copy(
                    defaultStartingScreen = screen
                )
            }
        }
    }

    fun resetAllSettings() {
        viewModelScope.launch {
            settingsRepository.resetSettings()
        }
        // TODO is it correct
        start()
    }
}
