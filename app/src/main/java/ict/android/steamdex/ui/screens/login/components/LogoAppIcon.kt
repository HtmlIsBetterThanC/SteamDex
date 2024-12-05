package ict.android.steamdex.ui.screens.login.components
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun LogoAppIcon(
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = R.mipmap.ic_launcher_round,
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
