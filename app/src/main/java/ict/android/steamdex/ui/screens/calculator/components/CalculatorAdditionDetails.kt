package ict.android.steamdex.ui.screens.calculator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.CustomLinearProgressIndicator
import ict.android.steamdex.ui.components.ValueSection
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun CalculatorAdditionalDetails(
    totalHours: Double,
    todayValue: Int,
    currentXpToNextLevel: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        ProgressBarXp(currentXpToNextLevel)
        ValueSection(
            labelValue = R.string.profile_additional_details_total_hours,
            styleValue = MaterialTheme.typography.labelLarge,
            value = totalHours.toString()
        )
        ValueSection(
            labelValue = R.string.profile_additional_details_today_value,
            styleValue = MaterialTheme.typography.labelLarge,
            value = todayValue.toString()
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

@PreviewSteam
@Composable
private fun CalculatorAdditionalDetailsPreview() {
    SteamDexTheme {
        Surface {
            CalculatorAdditionalDetails(
                totalHours = 2234.4,
                todayValue = 12000,
                currentXpToNextLevel = 500,
            )
        }
    }
}
