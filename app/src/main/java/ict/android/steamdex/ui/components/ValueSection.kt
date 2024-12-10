package ict.android.steamdex.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun ValueSection(
    @StringRes labelValue: Int,
    value: String,
    styleValue: TextStyle,
    modifier: Modifier = Modifier,
    currency: String = "€" // TODO change to type Currency

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
                text = currency,
                color = MaterialTheme.colorScheme.secondaryContainer,
                style = styleValue

            )
        }
    }
}