package ict.android.steamdex.ui.screens.game.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.buttons.SecondaryButton
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun AssistiveChipsRow(
    onClickWhislist: () -> Unit,
    onClickFollow: () -> Unit,
    onClickIgnore: () -> Unit,
    onClickWatch: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ){

        SecondaryButton(
            label = stringResource(R.string.wishlist_button),
            onClick = onClickWhislist,
            enabled = true,
        )

        SecondaryButton(
            label = stringResource(R.string.follow_button),
            onClick = onClickFollow,
            enabled = true,
        )

        SecondaryButton(
            label = stringResource(R.string.ignore_button),
            onClick = onClickIgnore,
            enabled = true,
        )
        SecondaryButton(
            label = stringResource(R.string.watch_button),
            onClick = onClickWatch,
            enabled = true,
        )
    }
}

@PreviewSteam
@Composable
private fun AssistiveChipsRowPreview() {
    SteamDexTheme {
        Surface {
            AssistiveChipsRow(
                onClickWhislist = {},
                onClickFollow = {},
                onClickIgnore = {},
                onClickWatch = {},
            )
        }
    }

}