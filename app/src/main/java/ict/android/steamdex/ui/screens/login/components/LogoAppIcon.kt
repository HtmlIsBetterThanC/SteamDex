package ict.android.steamdex.ui.screens.login.components
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun LogoAppIcon(
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = R.drawable.steamdex_logo,
        contentDescription = stringResource(R.string.app_icon_description),
        modifier = modifier.size(240.dp)
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
