package ict.android.steamdex.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.secondaryContainerDark
import ict.android.steamdex.ui.theme.secondaryContainerLight
@Composable
fun PopularGamesTopBar(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(
                color =
                if (isSystemInDarkTheme()) {
                    secondaryContainerDark
                } else {
                    secondaryContainerLight
                }
            )
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment
                .CenterVertically,
            horizontalArrangement = Arrangement
                .SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement
                    .spacedBy(20.dp),
                verticalAlignment = Alignment
                    .CenterVertically
            ) {
                Icon(
                    painter = painterResource
                    (R.drawable.savings),
                    contentDescription = stringResource
                    (R.string.icon_description_popular_games),
                    tint = MaterialTheme
                        .colorScheme.onSurface,
                    modifier = Modifier
                        .size(40.dp)
                )
                Text(
                    modifier = Modifier,
                    text = stringResource
                    (R.string.text_popular_games),
                    style = MaterialTheme
                        .typography.titleLarge,
                    color = MaterialTheme
                        .colorScheme.onSurface
                )
            }
            Icon(
                painter = painterResource
                (R.drawable.trailing_icon),
                contentDescription = stringResource
                (R.string.icon_description_popular_games),
                tint = MaterialTheme
                    .colorScheme.onSurface,
                modifier = Modifier
                    .size(40.dp)
            )
        }
    }
}

@PreviewSteam
@Composable
private fun GamesOnSaleTopBarPreview() {
    val modifier = Modifier
    val theme = isSystemInDarkTheme()
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .gradientBackground(theme)
        ) {
            PopularGamesTopBar(
                modifier = modifier
            )
        }
    }
}
