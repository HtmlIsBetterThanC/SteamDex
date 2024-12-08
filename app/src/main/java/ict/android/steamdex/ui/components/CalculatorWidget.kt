package ict.android.steamdex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
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
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun CalculatorWidget(
    profile: UiProfile,
    onClickButton: () -> Unit,
    additionalInfoEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = MaterialTheme.colorScheme.onSecondary)
            .padding(10.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TotalValueSection(
            totalGamesValue = profile.totalValue
        )
        ProgressBarSection(
            totalGames = profile.totalGames,
            gamesPlayed = profile.playedGames,
        )
        if(additionalInfoEnabled){

        }

        CalculatorButton(
            onClick = onClickButton
        )
    }
}

@Composable
private fun TotalValueSection(
    totalGamesValue: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.calculator_preview_total_value),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.headlineSmall
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = totalGamesValue.toString(),
                color = MaterialTheme.colorScheme.secondaryContainer,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = stringResource(R.string.eur_symbol),
                color = MaterialTheme.colorScheme.secondaryContainer,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
private fun ProgressBarSection(
    totalGames: Int,
    gamesPlayed: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(5.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
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
            Text(
                text = stringResource(R.string.progress_bar_out_of),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = totalGames.toString(),
                color = MaterialTheme.colorScheme.primaryContainer,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(R.string.progress_bar_games_played),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium
            )
        }
        CustomLinearProgressIndicator(
            progress = gamesPlayed.toFloat() / totalGames.toFloat(),
            modifier = modifier
        )
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
    modifier: Modifier = Modifier,
) {
    PrimaryButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiaryContainer),
        enabled = true,
        content = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.calculate),
                    contentDescription = stringResource(R.string.button_icon_calculator),
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    modifier = Modifier,
                    text = stringResource(R.string.button_calculator),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        },
    )
}

@PreviewSteam
@Composable
private fun CalculatorPreviewPreview() {
    val profile = UiProfile(
        name = "allolla",
        iconUrl = "",
        level = 50,
        totalValue = 6789,
        totalGames = 500,
        totalHours = 890.5,
        playedGames = 290,
        countryCode = "CA",
        age = "8.0",
    )
    SteamDexTheme {
        Surface {
            CalculatorWidget(
                profile = profile,
                onClickButton = {},
                additionalInfoEnabled = false
            )
        }
    }
}
