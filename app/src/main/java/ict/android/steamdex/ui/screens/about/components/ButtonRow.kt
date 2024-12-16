package ict.android.steamdex.ui.screens.about.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.screens.about.ButtonConfig
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun ButtonRow(
    buttons: List<ButtonConfig>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        buttons.forEach { config ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AboutButton(
                    modifier = Modifier.size(80.dp),
                    text = config.text,
                    icon = config.icon,
                    onClick = config.onClick,
                    buttonColor = config.buttonColor
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = config.text,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@PreviewSteam
@Composable
fun ButtonRowPreview() {

    val firstRowButtons = listOf(
        ButtonConfig(
            icon = painterResource(R.drawable.group_filled),
            text = "Authors",
            onClick = { },
            buttonColor = MaterialTheme.colorScheme.tertiaryContainer

        ),
        ButtonConfig(
            icon = painterResource(R.drawable.translate),
            text = "Translation",
            onClick = { },
            buttonColor = MaterialTheme.colorScheme.tertiaryContainer

        ),
        ButtonConfig(
            icon = painterResource(R.drawable.volunteer_activism),
            text = "Donations",
            onClick = { },
            buttonColor = MaterialTheme.colorScheme.tertiaryContainer

        )
    )

    SteamDexTheme {
        Surface {
            ButtonRow(
                firstRowButtons,

            )
        }
    }
}
