package ict.android.steamdex.ui.screens.profile

import androidx.compose.runtime.Immutable
import ict.android.steamdex.models.ui.UiProfile
import ict.android.steamdex.navigation.ExploreRoute

@Immutable
data class ProfileUiState(
    val profile: UiProfile = UiProfile(),
    val totalFriends: String = "",
    val darkTheme: Boolean? = null,
    val pitchBlack: Boolean = false,
    val materialYou: Boolean = false,
    val gradientBackground: Boolean = true,
    val defaultStartingScreen: String = ExploreRoute.javaClass.name
)
