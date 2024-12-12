package ict.android.steamdex.ui.screens.profile.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamFontSize
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun SettingsList(
    onItemClick: (item: SettingsItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(settingsList) { item ->
            SettingItemRow(
                item = item,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
fun SettingItemRow(
    item: SettingsItem,
    onItemClick: (item: SettingsItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val title = stringResource(item.titleId)
    ListItem(
        headlineContent = { Text(title) },
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .padding(vertical = 10.dp),
        colors =
        ListItemDefaults.colors(
            containerColor = Color.Transparent,
            headlineColor = MaterialTheme.colorScheme.onSurface,
            leadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        leadingContent = {
            Icon(
                painter = painterResource(item.iconId),
                contentDescription = null
            )
        },
        trailingContent = {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = stringResource(
                    R.string.settings_play_arrow_icon_description,
                    title
                ),
                modifier = Modifier.size(12.dp)
            )
        }
    )
}

// TODO --> Move class to another file

@Immutable
data class SettingsItem(
    val id: Int,
    @StringRes val titleId: Int,
    @DrawableRes val iconId: Int
)

@Stable
private val settingsList = listOf(
    SettingsItem(
        id = 1,
        titleId = R.string.settings_language_title,
        iconId = R.drawable.language
    ),
    SettingsItem(
        id = 2,
        titleId = R.string.settings_theme_title,
        iconId = R.drawable.theme
    ),
    SettingsItem(
        id = 3,
        titleId = R.string.settings_pitch_black_title,
        iconId = R.drawable.pitch_black
    ),
    SettingsItem(
        id = 4,
        titleId = R.string.settings_material_you_title,
        iconId = R.drawable.material_you
    ),
    SettingsItem(
        id = 5,
        titleId = R.string.settings_default_startup_page_title,
        iconId = R.drawable.default_startup_page
    ),
    SettingsItem(
        id = 6,
        titleId = R.string.settings_restore_default_title,
        iconId = R.drawable.restore_defaults
    )
)

@PreviewSteam
@PreviewSteamFontSize
@Composable
private fun SettingsListPreview() {
    SteamDexTheme {
        Surface {
            SettingsList({})
        }
    }
}
