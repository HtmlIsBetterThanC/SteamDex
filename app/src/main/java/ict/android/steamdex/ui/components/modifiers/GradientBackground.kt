package ict.android.steamdex.ui.components.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Stable
fun Modifier.gradientBackground(darkTheme: Boolean): Modifier {
    // TODO add light theme colors
    val firstColor = if (darkTheme) Color(0xFF482A0C) else Color(0xFF482A0C)
    val secondColor = if (darkTheme) Color.Black else Color.Black
    val thirdColor = if (darkTheme) Color(0xFF071835) else Color(0xFF071835)

    return this.then(
        Modifier.background(
            Brush.verticalGradient(
                colors = listOf(
                    firstColor,
                    secondColor,
                    thirdColor
                )
            )
        )
    )
}

@PreviewSteam
@Composable
private fun GradientBackgroundPreview() {
    val theme = isSystemInDarkTheme()
    SteamDexTheme(theme) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .gradientBackground(theme)
        ) {}
    }
}
