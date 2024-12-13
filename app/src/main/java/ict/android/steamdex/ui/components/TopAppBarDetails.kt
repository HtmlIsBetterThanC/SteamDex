package ict.android.steamdex.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
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
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun TopAppBarDetails(
    @DrawableRes firstIconId: Int,
    @StringRes firstIconDescriptionId: Int,
    firstTitle: String,
    @DrawableRes secondIconId: Int,
    @StringRes secondIconDescriptionId: Int,
    secondTitle: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SingleDetail(
            iconId = firstIconId,
            iconDescriptionId = firstIconDescriptionId,
            title = firstTitle,
        )
        SingleDetail(
            iconId = secondIconId,
            iconDescriptionId = secondIconDescriptionId,
            title = secondTitle,
        )
    }
}

@Composable
private fun SingleDetail(
    @DrawableRes iconId: Int,
    @StringRes iconDescriptionId: Int,
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(iconId),
            contentDescription = stringResource(iconDescriptionId),
            modifier = Modifier.size(40.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = title,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@PreviewSteam
@Composable
private fun TopAppBarDetailsPreview() {
    SteamDexTheme {
        Surface {
            TopAppBarDetails(
                firstIconId = R.drawable.age,
                firstIconDescriptionId = R.string.profile_age_icon_description,
                firstTitle = "12.4 years",
                secondIconId = R.drawable.country_code,
                secondIconDescriptionId = R.string.profile_country_code_description,
                secondTitle = "IT"

            )
        }
    }
}
