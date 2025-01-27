package ict.android.steamdex.ui.screens.game.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.buttons.PrimaryButton
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun PrimaryButtonRow(
    @DrawableRes leftButtonIconId: Int, // TODO check how to get the id of a default Icon
    @DrawableRes rightButtonIconId: Int,
    @StringRes leftButtonLabel: Int,
    @StringRes rightButtonLabel: Int,
    leftButtonValue: Any,
    rightButtonValue: Number,
    onClickLeftButton: () -> Unit,
    onClickRightButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PrimaryButton( // TODO make its separate component for the single button
            onClick = onClickLeftButton,
            enabled = true,
            content = {
                GamePrimaryButtonContent(
                    iconId = leftButtonIconId,
                    value = leftButtonValue,
                    label = leftButtonLabel
                )
            }
        )
        PrimaryButton(
            onClick = onClickRightButton,
            enabled = true,
            content = {
                GamePrimaryButtonContent(
                    iconId = rightButtonIconId,
                    value = rightButtonValue,
                    label = rightButtonLabel
                )
            }
        )
    }
}

@Composable
fun GamePrimaryButtonContent(
    @DrawableRes iconId: Int,
    value: Any,
    @StringRes label: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(iconId),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value.toString(),
                // TODO change color
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = stringResource(label),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@PreviewSteam
@Composable
private fun PrimaryButtonRowPreview() {
    SteamDexTheme {
        Surface {
            PrimaryButtonRow(
                leftButtonIconId = R.drawable.gamepad,
                leftButtonValue = 28.86,
                leftButtonLabel = R.string.reviews_button_label,
                rightButtonIconId = R.drawable.gamepad,
                rightButtonValue = 2237,
                rightButtonLabel = R.string.in_game_counter,
                onClickLeftButton = {},
                onClickRightButton = {}
            )
        }
    }
}
