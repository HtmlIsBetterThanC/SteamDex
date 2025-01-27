package ict.android.steamdex.ui.screens.about.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ict.android.steamdex.R

@Composable
fun AppLogo(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        AsyncImage(
            model = R.mipmap.ic_launcher_round,
            contentDescription = stringResource(R.string.app_icon_description),
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .size(120.dp)
        )
    }
    Row {
        Text(
            text = "Steam",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primaryContainer
        )
        Text(
            text = "Dex",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.tertiaryContainer
        )
    }
}
