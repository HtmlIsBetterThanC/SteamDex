package ict.android.steamdex.ui.components.buttons

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    content:
    @Composable
    (RowScope.() -> Unit)
) {
    ElevatedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        content = content,
        colors = colors
    )
}

@PreviewSteam
@Composable
private fun PrimaryButtonPreview() {
    SteamDexTheme {
        Surface {
            PrimaryButton({}) {
                Text("Preview")
            }
        }
    }
}
