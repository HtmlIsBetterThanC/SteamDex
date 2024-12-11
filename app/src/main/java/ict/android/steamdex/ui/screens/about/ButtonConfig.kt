package ict.android.steamdex.ui.screens.about

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class ButtonConfig(
    val icon: Painter,
    val text: String,
    val onClick: () -> Unit,
    val buttonColor: Color? = null

)
