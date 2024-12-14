package ict.android.steamdex.ui.screens.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import ict.android.steamdex.ui.components.buttons.SecondaryButton
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam

@Composable
fun GameScreen(
    onClickWhislist: () -> Unit,
    onClickFollow: () -> Unit,
    onClickIgnore: () -> Unit,
    onClickWatch: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(){

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
    }
}

@PreviewSteam
@Composable
private fun GameScreenPreview
)
     {
    
}