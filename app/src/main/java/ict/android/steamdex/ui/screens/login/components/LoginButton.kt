package ict.android.steamdex.ui.screens.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.buttons.PrimaryButton
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun LoginButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val textAndIconColor = MaterialTheme.colorScheme.onTertiaryContainer
    PrimaryButton(
        onClick = onClick,
        modifier = modifier.clip(RoundedCornerShape(100))
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stringResource(R.string.loginScreen_login_button_text),
                color = textAndIconColor,
                style = MaterialTheme.typography.labelLarge
            )
            Icon(
                painter = painterResource(R.drawable.steam_icon),
                contentDescription = null,
                tint = textAndIconColor
            )
            Text(
                stringResource(R.string.steam),
                color = textAndIconColor,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@PreviewSteam
@Composable
private fun LoginButtonPreview() {
    SteamDexTheme {
        Surface {
            LoginButton(
                onClick = {},
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
