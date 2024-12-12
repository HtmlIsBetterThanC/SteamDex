package ict.android.steamdex.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ict.android.steamdex.data.repositories.SettingsRepository
import ict.android.steamdex.ext.fromRouteToString
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.screens.profile.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val settingsRepository: SettingsRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<ProfileUiState> = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.value

    fun start() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    // TODO get from api client
                    profile = profiles[0],
                    totalFriends = "5",
                    darkTheme = settingsRepository.getDarkTheme(),
                    defaultStartingScreen = settingsRepository.getDefaultStartingScreen()
                )
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
            val routeString = screen.fromRouteToString()
            settingsRepository.updateDefaultStartingScreen(routeString)
            _uiState.update {
                it.copy(
                    defaultStartingScreen = routeString
                )
            }
        }
    }

    fun resetAllSettings() {
        viewModelScope.launch {
            settingsRepository.resetSettings()
            _uiState.update {
                ProfileUiState()
            }
        }
    }
}
