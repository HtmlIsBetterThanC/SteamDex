package ict.android.steamdex.ui.components.buttons

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun DeactivateButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = LocalContentColor.current
) {
    TextButton(onClick, modifier) {
        Text(
            stringResource(R.string.deactivate_button_title),
            color = color
        )
    }
}

@PreviewSteam
@Composable
private fun DeactivateButtonPreview() {
    SteamDexTheme {
        Surface {
            DeactivateButton({})
        }
    }
}
