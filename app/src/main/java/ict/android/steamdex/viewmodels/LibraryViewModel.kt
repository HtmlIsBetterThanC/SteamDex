package ict.android.steamdex.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ict.android.steamdex.data.repositories.GameRepository
import ict.android.steamdex.data.repositories.ProfileRepository
import ict.android.steamdex.models.mappers.toUiModel
import ict.android.steamdex.ui.screens.library.LibraryUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val gamesRepository: GameRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(LibraryUiState())
    val uiState = _uiState.asStateFlow()

    fun start() {
        _uiState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    profile = profileRepository.getProfile().toUiModel(),
                    games = gamesRepository.getOwnedGames().toUiModel(),
                    isLoading = false
                )
            }
        }
    }
}
