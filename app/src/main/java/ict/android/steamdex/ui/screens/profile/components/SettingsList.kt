package ict.android.steamdex.ui.screens.profile.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamFontSize
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun SettingsList(
    settingsItems: List<SettingsItem>,
    onItemClick: (item: SettingsItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(settingsItems) { item -> SettingItemRow(item, onItemClick) }
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
            .padding(vertical = 12.dp),
        leadingContent = {
            Icon(
                painter = painterResource(item.iconId),
                contentDescription = null,
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
    val name: String,
    @StringRes val titleId: Int,
    @DrawableRes val iconId: Int,
)

@PreviewSteam
@PreviewSteamFontSize
@Composable
fun SettingsListPreview() {
    SteamDexTheme {
        Surface(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .safeContentPadding()
                .fillMaxSize(),
        ) {
            SettingsList(
                settingsItems = listOf(
                    SettingsItem(
                        "language",
                        R.string.settings_language_title,
                        R.drawable.language
                    ),
                    SettingsItem(
                        "theme",
                        R.string.settings_theme_title,
                        R.drawable.theme
                    ),
                    SettingsItem(
                        "pitchBlack",
                        R.string.settings_pitch_black_title,
                        R.drawable.pitch_black
                    ),
                    SettingsItem(
                        "materialYou",
                        R.string.settings_material_you_title,
                        R.drawable.material_you
                    ),
                    SettingsItem(
                        "defaultStartupPage",
                        R.string.settings_default_startup_page_title,
                        R.drawable.default_startup_page
                    ),
                    SettingsItem(
                        "restoreDefault",
                        R.string.settings_restore_default_title,
                        R.drawable.restore_defaults
                    )
                ),
                {},
            )
        }
    }
}
