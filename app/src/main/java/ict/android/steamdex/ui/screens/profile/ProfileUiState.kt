package ict.android.steamdex.ui.screens.profile

import androidx.compose.runtime.Immutable
import ict.android.steamdex.models.ui.UiProfile

@Immutable
data class ProfileUiState(
    val profile: UiProfile,
    val totalFriends: String
)
