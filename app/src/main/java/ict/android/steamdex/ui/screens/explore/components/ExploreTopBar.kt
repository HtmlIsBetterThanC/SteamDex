package ict.android.steamdex.ui.screens.explore.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.ScreenTopBar
import ict.android.steamdex.ui.components.buttons.PrimaryButton
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun ExploreTopBar(
    useGradientBackground: Boolean,
    editMode: Boolean,
    iconUrl: String,
    name: String,
    level: Int,
    onProfileClick: () -> Unit,
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ScreenTopBar(
        backEnabled = false,
        useGradientBackground = useGradientBackground,
        profileIconUrl = iconUrl,
        profileName = name,
        profileLevel = level,
        onProfileClick = onProfileClick,
        modifier = modifier,
        actions = {
            PrimaryButton(
                onClick = onEditClick,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                if (editMode) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close_icon_description)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = stringResource(R.string.edit_icon_description)
                    )
                }
            }
        }
    )
}

@PreviewSteam
@Composable
private fun ExploreTopBarPreview() {
    val profile = profiles[1]
    SteamDexTheme {
        Surface {
            ExploreTopBar(
                useGradientBackground = false,
                editMode = false,
                iconUrl = profile.iconUrl,
                name = profile.name,
                level = profile.level,
                onProfileClick = {},
                onEditClick = {},
            )
        }
    }
}
