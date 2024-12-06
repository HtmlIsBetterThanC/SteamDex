package ict.android.steamdex.ui.screens.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.buttons.PrimaryButton
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

val profile = profiles.first()

@Composable
fun CalculatorPreview() {
    MaterialTheme {
        Column(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = MaterialTheme.colorScheme.onSecondary),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TotalValueSection()
            Spacer(modifier = Modifier.height(16.dp))
            ProgressBarSection()
            Spacer(modifier = Modifier.height(16.dp))
            CalculatorButton()
        }
    }
}

@Composable
fun TotalValueSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            modifier = Modifier
                .padding(end = 5.dp),
            text = stringResource(R.string.calculator_preview_total_value),
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize
        )
        Text(
            text = profile.totalValue.toString(),
            color = MaterialTheme.colorScheme.secondaryContainer,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
        )
        Text(
            text = stringResource(R.string.eur_symbol),
            color = MaterialTheme.colorScheme.secondaryContainer,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize
        )
    }
}

@Composable
fun ProgressBarSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp, end = 5.dp),
            text = profile.playedGames.toString(),
            color = MaterialTheme.colorScheme.primaryContainer,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp, end = 5.dp),
            text = stringResource(R.string.progress_bar_out_of),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp, end = 5.dp),
            text = profile.totalGames.toString(),
            color = MaterialTheme.colorScheme.primaryContainer,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp),
            text = stringResource(R.string.progress_bar_games_played),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleMedium
        )
    }
    LinearProgressIndicator(
        progress = {
            profile.playedGames.toFloat() / profile.totalGames.toFloat()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(12.dp)
            .padding(start = 5.dp, end = 5.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        trackColor = MaterialTheme.colorScheme.surfaceTint,
    )
}

@Composable
fun CalculatorButton() {
    PrimaryButton(
        onClick = {},
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .padding(bottom = 10.dp),
        colors = ButtonDefaults.
        buttonColors(MaterialTheme.colorScheme.tertiaryContainer),
        enabled = true,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.calculate),
                    contentDescription = stringResource(R.string.button_icon_calculator),
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(16.dp))
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
    SteamDexTheme {
        CalculatorPreview()
    }
}