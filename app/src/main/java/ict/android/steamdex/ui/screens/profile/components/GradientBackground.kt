package ict.android.steamdex.ui.screens.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

object GradientBackground {
    val gameDetailsBackground = Modifier.background(
        brush = Brush.verticalGradient(
            colors = listOf(
                Color(0xFF482A0C),
                Color(0xFF000000),
                Color(0xFF000000),
                Color(0xFF071835)
            ),
            startY = 0f,
            endY = Float.POSITIVE_INFINITY
        )
    )
}

@PreviewSteam
@Composable
fun AppGradientsPreview() {
    SteamDexTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(GradientBackground.gameDetailsBackground)
        ) { }
    }
}
