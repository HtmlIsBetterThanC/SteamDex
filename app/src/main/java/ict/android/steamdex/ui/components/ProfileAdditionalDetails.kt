package ict.android.steamdex.ui.components

import android.icu.text.DecimalFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R

@Composable
fun ProfileAdditionalDetail(
    totalValue: Int,
    playedGames: Int,
    totalGames: Int,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
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
            labelValue = R.string.profile_total_value,
            styleValue = MaterialTheme.typography.headlineSmall,
            value = totalValue.toString()
        )
        ProgressBarGamesPlayed(
            gamesPlayed = playedGames,
            totalGames = totalGames
        )
        content()
    }
}

@Composable
fun ProgressBarGamesPlayed(
    gamesPlayed: Int,
    totalGames: Int,
    modifier: Modifier = Modifier,
    ratio: Float = gamesPlayed.toFloat() / totalGames.toFloat()
) {
    Column(
        modifier = modifier.padding(5.dp),
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
        CustomLinearProgressIndicator(ratio)
    }
}
