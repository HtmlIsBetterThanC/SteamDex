package ict.android.steamdex.ui.components.dialogs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamFontSize
import ict.android.steamdex.ui.theme.SteamDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformationDialog(
    showDialog: Boolean,
    dialogTitle: String,
    dialogDescription: String,
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
                        dialogTitle,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        dialogDescription,
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
private fun InformationDialogPreview() {
    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            InformationDialog(
                showDialog = true,
                dialogTitle = "Preview",
                dialogDescription = "Dialog preview",
                onDismissDialog = {}
            )
        }
    }
}
