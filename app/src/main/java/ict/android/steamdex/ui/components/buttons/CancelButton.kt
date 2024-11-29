package ict.android.steamdex.ui.components.buttons

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun CancelButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(onClick, modifier) {
        Text(stringResource(R.string.cancel_button_title))
    }
}

@PreviewSteam
@Composable
private fun CancelButtonPreview() {
    SteamDexTheme {
        Surface {
            CancelButton({})
        }
    }
}
