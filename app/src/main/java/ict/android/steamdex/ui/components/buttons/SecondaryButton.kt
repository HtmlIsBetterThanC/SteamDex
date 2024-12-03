package ict.android.steamdex.ui.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun SecondaryButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @DrawableRes leadingIconId: Int? = null,
    @DrawableRes trailingIconId: Int? = null
) {
    AssistChip(
        onClick = onClick,
        label = { Text(label) },
        modifier = modifier,
        enabled = enabled,
        leadingIcon = {
            leadingIconId?.let {
                Icon(
                    painter = painterResource(it),
                    contentDescription = null
                )
            }
        },
        trailingIcon = {
            trailingIconId?.let {
                Icon(
                    painter = painterResource(it),
                    contentDescription = null
                )
            }
        }
    )
}

@PreviewSteam
@Composable
private fun SecondaryButtonPreview() {
    SteamDexTheme {
        Surface {
            SecondaryButton(label = "Preview", {})
        }
    }
}
