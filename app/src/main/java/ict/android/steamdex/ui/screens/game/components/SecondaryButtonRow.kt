package ict.android.steamdex.ui.screens.game.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.buttons.SecondaryButton
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun SecondaryButtonRow(
    @StringRes firstLabel: Int,
    @StringRes secondLabel: Int,
    @StringRes thirdLabel: Int,
    onClickFirst: () -> Unit,
    onClickSecond: () -> Unit,
    onClickThird: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GameSecondaryButton(
            labelId = firstLabel,
            onClick = onClickFirst,
            // TODO add icon game
        )
        GameSecondaryButton(
            labelId = secondLabel,
            onClick = onClickSecond,
        )
        GameSecondaryButton(
            labelId = thirdLabel,
            onClick = onClickThird,
        )
    }
}

@Composable
private fun GameSecondaryButton(
    @StringRes labelId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes leadingIconId: Int? = null
) {
    SecondaryButton(
        label = stringResource(labelId),
        onClick = onClick,
        modifier = modifier,
        enabled = true,
        leadingIconId = leadingIconId,
    )
}

@PreviewSteam
@Composable
private fun SecondaryButtonRowPreview() {
    SteamDexTheme {
        Surface {
            SecondaryButtonRow(
                firstLabel = R.string.game_screen_info,
                secondLabel = R.string.game_screen_store,
                thirdLabel = R.string.game_screen_hub,
                onClickFirst = {},
                onClickSecond = {},
                onClickThird = {},
            )
        }
    }
}
