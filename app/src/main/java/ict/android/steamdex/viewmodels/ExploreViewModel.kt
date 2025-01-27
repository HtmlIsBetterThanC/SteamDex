package ict.android.steamdex.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ict.android.steamdex.data.repositories.GameRepository
import ict.android.steamdex.data.repositories.ProfileRepository
import ict.android.steamdex.models.mappers.toUiModel
import ict.android.steamdex.ui.screens.explore.ExploreUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val gameRepository: GameRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<ExploreUiState> = MutableStateFlow(ExploreUiState())
    val uiState = _uiState.asStateFlow()

    fun start() {
        _uiState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            _uiState.update {
                ExploreUiState(
                    profile = profileRepository.getProfile().toUiModel(),
                    isMostPlayedGamesExpanded = gameRepository.isMostPlayedGamesExpanded(),
                    isTrendingGamesExpanded = gameRepository.isTrendingGamesExpanded(),
                    isOnSaleGamesExpanded = gameRepository.isOnSaleGamesExpanded(),
                    isPopularGamesExpanded = gameRepository.isPopularGamesExpanded(),
                    mostPlayedGames = gameRepository.getMostPlayedGames().toUiModel(),
                    trendingGames = gameRepository.getTrendingGames().toUiModel(),
                    onSaleGames = gameRepository.getOnSaleGames().toUiModel(),
                    popularGames = gameRepository.getPopularGames().toUiModel(),
                    isLoading = false
                )
            }
        }
    }

    fun updateMostPlayedGamesExpanded(expanded: Boolean) {
        viewModelScope.launch {
            gameRepository.setMostPlayedGamesExpanded(expanded)
            _uiState.update {
                it.copy(isMostPlayedGamesExpanded = expanded)
            }
        }
    }

    fun updateTrendingGamesExpanded(expanded: Boolean) {
        viewModelScope.launch {
            gameRepository.setTrendingGamesExpanded(expanded)
            _uiState.update {
                it.copy(isTrendingGamesExpanded = expanded)
            }
        }
    }

    fun updateOnSaleGamesExpanded(expanded: Boolean) {
        viewModelScope.launch {
            gameRepository.setOnSaleGamesExpanded(expanded)
            _uiState.update {
                it.copy(isOnSaleGamesExpanded = expanded)
            }
        }
    }

    fun updatePopularGamesExpanded(expanded: Boolean) {
        viewModelScope.launch {
            gameRepository.setPopularGamesExpanded(expanded)
            _uiState.update {
                it.copy(isPopularGamesExpanded = expanded)
            }
        }
    }
}
