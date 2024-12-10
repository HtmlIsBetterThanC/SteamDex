package ict.android.steamdex.ui.components.buttons.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Suppress("ModifierNotUsedAtRoot")
@Composable
fun SearchIcon(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) {
    IconButton(onClick) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = stringResource(R.string.search_icon_description),
            modifier = modifier,
            tint = tint
        )
    }
}

@PreviewSteam
@Composable
private fun SearchButtonPreview() {
    SteamDexTheme {
        Surface {
            SearchIcon({})
        }
    }
}
