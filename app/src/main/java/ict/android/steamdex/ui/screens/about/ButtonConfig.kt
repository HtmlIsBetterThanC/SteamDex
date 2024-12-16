package ict.android.steamdex.ui.screens.about

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

@Immutable
data class ButtonConfig(
    val icon: Painter,
    val text: String,
    val onClick: () -> Unit,
    val buttonColor: Color? = null
)
