package ict.android.steamdex.ui.components.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamFontSize
import ict.android.steamdex.ui.theme.SteamDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutYouDialog(
    showDialog: Boolean,
    dialogContent: DialogContent,
    onDismissDialog: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (showDialog) {
        BasicAlertDialog(onDismissDialog) {
            Surface(
                modifier = modifier,
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(Modifier.padding(24.dp)) {
                    Text(
                        dialogContent.title,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        dialogContent.description,
                        style = MaterialTheme.typography.labelLarge
                    )
                    Spacer(Modifier.height(24.dp))
                }
            }
        }
    }
}

@PreviewSteam
@PreviewSteamFontSize
@Composable
private fun DialogPreview() {
    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            val (showDialog, onShowDialogChange) = remember { mutableStateOf(true) }

            val authorsDialogContent = DialogContent(
                title = "Authors",
                description = "Ethan Wetherfield\n" +
                    "Lila Ashcroft\n" +
                    "Marcus Haverstone\n" +
                    "Amelia Crowell\n" +
                    "Jack Elridge\n" +
                    "Charlotte Windmere\n" +
                    "Oliver Blackthorn\n" +
                    "Sophia Fairmont\n" +
                    "James Holloway\n" +
                    "Evelyn Redwyne\n" +
                    "Henry Winslow\n" +
                    "Clara Thornfield\n" +
                    "Lucas Greystone\n" +
                    "Grace Bellamy\n" +
                    "Nathaniel Harwick\n" +
                    "Isla Winterbourne\n" +
                    "Theodore Ashenford\n" +
                    "Victoria Langley\n" +
                    "Samuel Ravensdale\n" +
                    "Emily Whitestone"
            )

            val licenseDialogContent = DialogContent(
                title = "App License",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                    "nisi ut aliquip ex ea commodo consequat. " +
                    "Duis aute irure dolor in reprehenderit in voluptate velit esse " +
                    "cillum dolore eu fugiat nulla pariatur. " +
                    "Excepteur sint occaecat cupidatat non proident, " +
                    "sunt in culpa qui officia deserunt mollit anim id est laborum."
            )

            val privacyDialogContent = DialogContent(
                title = "Privacy Policy",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                    "nisi ut aliquip ex ea commodo consequat. " +
                    "Duis aute irure dolor in reprehenderit in voluptate velit esse " +
                    "cillum dolore eu fugiat nulla pariatur. " +
                    "Excepteur sint occaecat cupidatat non proident, " +
                    "sunt in culpa qui officia deserunt mollit anim id est laborum."
            )

            val versionDialogContent = DialogContent(
                title = "App Version",
                description = "Your app version is: 1.0"
            )

            AboutYouDialog(
                showDialog = showDialog,
                dialogContent = authorsDialogContent,
                onDismissDialog = { onShowDialogChange(false) },
            )

            AboutYouDialog(
                showDialog = showDialog,
                dialogContent = licenseDialogContent,
                onDismissDialog = { onShowDialogChange(false) },
            )

            AboutYouDialog(
                showDialog = showDialog,
                dialogContent = privacyDialogContent,
                onDismissDialog = { onShowDialogChange(false) },
            )

            AboutYouDialog(
                showDialog = showDialog,
                dialogContent = versionDialogContent,
                onDismissDialog = { onShowDialogChange(false) },
            )

            if (!showDialog) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button({ onShowDialogChange(true) }) {
                        Text("Show Dialog")
                    }
                }
            }
        }
    }
}
