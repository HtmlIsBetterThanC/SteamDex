package ict.android.steamdex.ui.preview.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.screens.profile.ProfileUiState

class ProfilePreviewParametersProvider : PreviewParameterProvider<ProfileUiState> {
    override val values = sequenceOf(
        ProfileUiState(
            profile = profiles[0],
            totalFriends = "22"
        ),
        ProfileUiState(
            profile = profiles[1],
            totalFriends = "45"
        ),
        ProfileUiState(
            profile = profiles[2],
            totalFriends = "1434"
        ),
        ProfileUiState(
            profile = profiles[3],
            totalFriends = "267"
        ),
        ProfileUiState(
            profile = profiles[4],
            totalFriends = "8"
        )
    )
}
