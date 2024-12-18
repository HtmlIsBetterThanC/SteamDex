package ict.android.steamdex.ui.screens.profile.components.dialog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.buttons.RadioDialog
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun ThemeDialog(
    showDialog: Boolean,
    currentTheme: Boolean?,
    onDismissDialog: () -> Unit,
    onThemeChange: (Boolean?) -> Unit,
    modifier: Modifier = Modifier
) {
    val dialogOption = listOf(
        stringResource(R.string.profile_screen_theme_system),
        stringResource(R.string.profile_screen_theme_light),
        stringResource(R.string.profile_screen_theme_dark)
    )
    val themeValue = listOf(null, false, true)
    RadioDialog(
        showDialog = showDialog,
        title = stringResource(R.string.profile_screen_theme_dialog_title),
        currentValue = currentTheme,
        optionListNames = dialogOption,
        optionListValues = themeValue,
        onDismissDialog = onDismissDialog,
        onItemClick = onThemeChange,
        modifier = modifier
    )
}

@PreviewSteam
@Composable
private fun ThemeDialogPreview() {
    var darkTheme: Boolean? by remember {
        mutableStateOf(null)
    }
    SteamDexTheme(darkTheme) {
        Surface(Modifier.fillMaxSize()) {
            ThemeDialog(
                showDialog = true,
                currentTheme = darkTheme,
                onDismissDialog = {},
                onThemeChange = { darkTheme = it }
            )
        }
    }
}
