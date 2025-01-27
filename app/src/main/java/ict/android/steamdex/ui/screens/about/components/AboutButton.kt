package ict.android.steamdex.ui.screens.about.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ui.components.buttons.PrimaryButton

@Composable
fun AboutButton(
    text: String?,
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonColor: Color? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PrimaryButton(
            onClick = onClick,
            modifier = modifier,
            colors = buttonColor?.let {
                ButtonDefaults.buttonColors(containerColor = buttonColor)
            } ?: ButtonDefaults.buttonColors()
        ) {
            Icon(
                painter = icon,
                contentDescription = text,
                modifier = Modifier.size(50.dp),
                tint = MaterialTheme.colorScheme.surface
            )
        }
    }
}
