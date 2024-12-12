package ict.android.steamdex.ui.screens.profile.components.dialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.buttons.CancelButton
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
    if (showDialog) {
        val dialogOption = listOf(
            R.string.profile_screen_theme_system,
            R.string.profile_screen_theme_light,
            R.string.profile_screen_theme_dark
        )
        val themeValue = listOf(null, false, true)
        Dialog(onDismissDialog) {
            Card(modifier.fillMaxWidth(0.9F)) {
                Column(Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(R.string.profile_screen_theme_dialog_title),
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                    dialogOption.forEachIndexed { index, themeOption ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onThemeChange(themeValue[index])
                                    onDismissDialog()
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = themeValue[index] == currentTheme,
                                onClick = {
                                    onThemeChange(themeValue[index])
                                    onDismissDialog()
                                }
                            )
                            Text(
                                stringResource(themeOption),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    CancelButton(onDismissDialog)
                }
            }
        }
    }
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
