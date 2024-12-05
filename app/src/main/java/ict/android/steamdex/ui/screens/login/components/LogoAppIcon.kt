package ict.android.steamdex.ui.screens.login.components

import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun LogoAppIcon(
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = null,
        modifier = modifier
    )
}

@PreviewSteam
@Composable
private fun LogoIconPreview() {
    SteamDexTheme {
        Surface {
            LogoAppIcon()
        }
    }
}
