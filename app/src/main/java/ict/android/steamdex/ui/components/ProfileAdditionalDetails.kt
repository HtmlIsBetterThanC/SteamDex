package ict.android.steamdex.ui.components

import android.icu.text.DecimalFormat
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.models.ui.UiProfile
import ict.android.steamdex.ui.components.buttons.PrimaryButton
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.screens.calculator.CalculatorUiState
import ict.android.steamdex.ui.theme.SteamDexTheme
import java.time.format.TextStyle

@Composable
fun ProfileAdditionalDetail(
    calculator: CalculatorUiState, // TODO to rework with UiProfile object
    modifier: Modifier = Modifier,
    additionalInfoEnabled: Boolean = false,
    onCalculatorClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = MaterialTheme.colorScheme.onSecondary)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ValueSection(
            labelValue = R.string.profile_additional_details_total_value,
            styleValue = MaterialTheme.typography.headlineSmall,
            value = calculator.profile.totalValue.toString(),
            trailingUnit = "€",
        )
        ProgressBarGamesPlayed(
            gamesPlayed = calculator.profile.playedGames,
            totalGames = calculator.profile.totalGames
        )

        if (additionalInfoEnabled) {
            ProgressBarXp(calculator.currentXpToNextLevel)
            ValueSection(
                labelValue = R.string.profile_additional_details_total_hours,
                styleValue = MaterialTheme.typography.labelLarge,
                value = calculator.profile.totalHours.toString(),
                trailingUnit = "h",
            )
            ValueSection(
                labelValue = R.string.profile_additional_details_today_value,
                styleValue = MaterialTheme.typography.labelLarge,
                value = calculator.todayValue.toString(),
                trailingUnit = "€",
            )
        } else {
            CalculatorButton(onCalculatorClick)
        }
    }
}

@Composable
private fun ValueSection(
    @StringRes labelValue: Int,
    value: String,
    trailingUnit: String, // TODO check if it's correct in this way
    styleValue: androidx.compose.ui.text.TextStyle,
    modifier: Modifier = Modifier,

) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(labelValue),
            color = MaterialTheme.colorScheme.onSurface,
            style = styleValue
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = value,
                color = MaterialTheme.colorScheme.secondaryContainer,
                style = styleValue
            )
            Text(
                text = trailingUnit,
                color = MaterialTheme.colorScheme.secondaryContainer,
                style = styleValue

            )
        }
    }
}

@Composable
private fun ProgressBarGamesPlayed(
    gamesPlayed: Int,
    totalGames: Int,
    modifier: Modifier = Modifier,
    ratio: Float = gamesPlayed.toFloat() / totalGames.toFloat()
) {
    Column(
        modifier = modifier
            .padding(5.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = gamesPlayed.toString(),
                color = MaterialTheme.colorScheme.primaryContainer,
                style = MaterialTheme.typography.titleMedium
            )

            val dec = DecimalFormat("#.00")
            val percentageRatio = ratio * 100f
            Text(
                text = "(${dec.format(percentageRatio)}%)",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                text = stringResource(R.string.progress_bar_games_played),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.labelLarge
            )
        }
        CustomLinearProgressIndicator(
            progress = ratio
        )
    }
}

@Composable
private fun ProgressBarXp(
    currentXpToNextLevel: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(5.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = currentXpToNextLevel.toString(),
                color = MaterialTheme.colorScheme.primaryContainer,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(R.string.progress_bar_fixed_xp),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.labelLarge
            )
        }
        CustomLinearProgressIndicator(currentXpToNextLevel.toFloat() / 500.toFloat())
    }
}

@Composable
private fun CustomLinearProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    progressColor: Color = MaterialTheme.colorScheme.primaryContainer,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceTint,
    clipShape: Shape = RoundedCornerShape(4.dp)
) {
    Box(
        modifier = modifier
            .clip(clipShape)
            .background(backgroundColor)
            .height(12.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .background(progressColor)
                .fillMaxHeight()
                .fillMaxWidth(progress)
        )
    }
}

// TODO to rework
@Composable
fun CalculatorButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    PrimaryButton(
        onClick = onClick,
        modifier = modifier,
        enabled = true,
        content = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.calculate),
                    contentDescription = stringResource(R.string.button_icon_calculator),
                    modifier = Modifier.size(40.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = stringResource(R.string.button_calculator),
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        },
    )
}

@PreviewSteam
@Composable
private fun ProfileAdditionalDetailsPreview() {
    val profile = UiProfile(
        name = "allolla",
        iconUrl = "",
        level = 50,
        totalValue = 6789,
        totalGames = 500,
        totalHours = 890.5,
        playedGames = 292,
        countryCode = "CA",
        age = "8.0"
    )
    val calculator = CalculatorUiState(
        profile = profile,
        todayValue = 14542.9,
        currentXpToNextLevel = 239
    )
    SteamDexTheme {
        Surface {
            ProfileAdditionalDetail(
                calculator = calculator,
                onCalculatorClick = {},
                additionalInfoEnabled = true,
            )
        }
    }
}
