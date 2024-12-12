package ict.android.steamdex.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import ict.android.steamdex.models.ui.UiProfile
import ict.android.steamdex.ui.components.buttons.icons.BackArrowButton
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun TopAppBarLarge(
    profile: UiProfile,
    backEnabled: Boolean,
    @DrawableRes firstIconId: Int,
    @DrawableRes secondIconId: Int,
    @StringRes firstIconDescriptionId: Int,
    @StringRes secondIconDescriptionId: Int,
    firstDetails: String,
    secondDetails: String,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (backEnabled) {
                    BackArrowButton(onBackClick)
                }

                Box(
                    modifier = Modifier.size(80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // TODO test with a real image
                    SteamAsyncImage(
                        model = profile.iconUrl,
                        modifier = Modifier
                            .clip(CircleShape)
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )
                    )
                }

                Text(
                    text = profile.name,
                    modifier = Modifier.basicMarquee(),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = profile.level.toString(),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SingleDetail(
                iconId = firstIconId,
                iconDescriptionId = firstIconDescriptionId,
                details = firstDetails
            )

            SingleDetail(
                iconId = secondIconId,
                iconDescriptionId = secondIconDescriptionId,
                details = secondDetails
            )
        }
    }
}

@Composable
private fun SingleDetail(
    @DrawableRes iconId: Int,
    @StringRes iconDescriptionId: Int,
    details: String,
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
            text = details,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@PreviewSteam
@Composable
private fun TopAppBarLargePreview() {
    val profile = UiProfile(
        name = "allolla",
        iconUrl = "",
        level = 50,
        totalValue = 42069,
        totalGames = 500,
        totalHours = 890.5,
        playedGames = 290,
        countryCode = "CA",
        age = "8.0"
    )
    SteamDexTheme {
        Surface {
            TopAppBarLarge(
                profile = profile,
                backEnabled = true,
                firstIconId = R.drawable.age,
                secondIconId = R.drawable.country_code,
                firstIconDescriptionId = R.string.profile_age_icon_description,
                secondIconDescriptionId = R.string.profile_country_code_description,
                firstDetails = profile.age,
                secondDetails = profile.countryCode
            )
        }
    }
}
