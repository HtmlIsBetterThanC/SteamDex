package ict.android.steamdex.ui.screens.home.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import ict.android.steamdex.ui.theme.onPrimaryContainerDark
import ict.android.steamdex.ui.theme.onPrimaryContainerLight
import ict.android.steamdex.ui.theme.primaryContainerDark
import ict.android.steamdex.ui.theme.primaryContainerLight

@Composable
fun SearchButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomEnd
    ) {
        SearchButtonClickable()
    }
}

@Composable
fun SearchButtonClickable(modifier: Modifier = Modifier) {
    val isDarkTheme = isSystemInDarkTheme()

    val containerColor = if (isDarkTheme) primaryContainerDark else primaryContainerLight
    val contentColor = if (isDarkTheme) onPrimaryContainerDark else onPrimaryContainerLight
    PrimaryButton(
        onClick = { },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Icon(
            modifier = Modifier
                .padding(10.dp)
                .size(24.dp),
            painter = painterResource(R.drawable.search),
            contentDescription = stringResource(
                R.string
                    .search_button_icon_description_search
            ),
            tint = MaterialTheme.colorScheme
                .onSecondaryContainer
        )
    }
}

@PreviewSteam
@Composable
private fun SearchButtonPreview() {
    SteamDexTheme {
        Surface {
            SearchButton()
        }
    }
}
