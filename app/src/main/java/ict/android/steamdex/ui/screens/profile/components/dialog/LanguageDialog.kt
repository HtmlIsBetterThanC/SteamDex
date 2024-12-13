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
fun LanguageDialog(
    showDialog: Boolean,
    currentLanguage: String,
    onDismissDialog: () -> Unit,
    onLanguageChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val dialogOption = listOf(
        "English",
        "Italiano"
    )
    val themeValue = listOf("EN", "IT")
    RadioDialog(
        showDialog = showDialog,
        title = stringResource(R.string.profile_screen_language_dialog_title),
        currentValue = currentLanguage,
        optionListNames = dialogOption,
        optionListValues = themeValue,
        onDismissDialog = onDismissDialog,
        onItemClick = onLanguageChange,
        modifier = modifier
    )
}

@PreviewSteam
@Composable
private fun LanguageDialogPreview() {
    var language by remember {
        mutableStateOf("")
    }
    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            LanguageDialog(
                showDialog = true,
                currentLanguage = language,
                onDismissDialog = {},
                onLanguageChange = {
                    language = it
                }
            )
        }
    }
}
