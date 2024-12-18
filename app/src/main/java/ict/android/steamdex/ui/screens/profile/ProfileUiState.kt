package ict.android.steamdex.ui.screens.profile

import androidx.compose.runtime.Immutable
import ict.android.steamdex.models.ui.UiProfile
import ict.android.steamdex.navigation.ExploreRoute

@Immutable
data class ProfileUiState(
    val profile: UiProfile = UiProfile(),
    val totalFriends: String = "",
    val language: String = "",
    val darkTheme: Boolean? = null,
    val defaultStartingScreen: Any = ExploreRoute
)
