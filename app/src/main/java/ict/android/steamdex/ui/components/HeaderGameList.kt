package ict.android.steamdex.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun HeaderGameList(
    @StringRes headerListName: Int,
    @StringRes itemTitle: Int,
    @StringRes firstParameterTitle: Int,
    @StringRes secondParameterTitle: Int,
    @StringRes thirdParameterTitle: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(headerListName),
            style = MaterialTheme.typography.titleLarge
        )
        HorizontalDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(itemTitle),
                style = MaterialTheme.typography.labelMedium
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(firstParameterTitle),
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = stringResource(secondParameterTitle),
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = stringResource(thirdParameterTitle),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@PreviewSteam
@Composable
private fun OwnedGamesPreview() {
    SteamDexTheme {
        Surface {
            HeaderGameList(
                headerListName = R.string.header_title_owned_games,
                itemTitle = R.string.header_title_parameter,
                firstParameterTitle = R.string.header_price_hour_parameter,
                secondParameterTitle = R.string.header_price_parameter,
                thirdParameterTitle = R.string.header_time_parameter
            )
        }
    }
}
