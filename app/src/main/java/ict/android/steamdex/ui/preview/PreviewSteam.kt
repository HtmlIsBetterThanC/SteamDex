package ict.android.steamdex.ui.preview

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Light", group = "Theme", showBackground = true)
@Preview(
    name = "Dark",
    group = "Theme",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
annotation class PreviewSteam

@Preview(name = "80%", group = "Font", fontScale = 0.80f)
@Preview(name = "100%", group = "Font", fontScale = 1.0f)
@Preview(name = "130%", group = "Font", fontScale = 1.3f)
@Preview(name = "150%", group = "Font", fontScale = 1.5f)
@Preview(name = "180%", group = "Font", fontScale = 1.8f)
@Preview(name = "200%", group = "Font", fontScale = 2f)
annotation class PreviewSteamFontSize

@Preview(
    name = "api 28",
    group = "apiLevels",
    apiLevel = 28
)
@Preview(
    name = "api 30",
    group = "apiLevels",
    apiLevel = 30
)
annotation class PreviewSteamApi
