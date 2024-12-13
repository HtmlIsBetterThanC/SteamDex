package ict.android.steamdex.ui.components.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ui.components.buttons.ActivateButton
import ict.android.steamdex.ui.components.buttons.DeactivateButton
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamFontSize
import ict.android.steamdex.ui.theme.SteamDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivateDialog(
    showDialog: Boolean,
    dialogTitle: String,
    dialogDescription: String,
    onDismissDialog: () -> Unit,
    onActivateClick: () -> Unit,
    onDeactivateClick: () -> Unit,
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
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.End)
                    ) {
                        ActivateButton(
                            {
                                onActivateClick()
                                // TODO is this needed?
                                onDismissDialog()
                            },
                            color = MaterialTheme.colorScheme.primary
                        )
                        DeactivateButton({
                            onDeactivateClick()
                            onDismissDialog()
                        })
                    }
                }
            }
        }
    }
}

@PreviewSteam
@PreviewSteamFontSize
@Composable
private fun ActivateDialogPreview() {
    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            ActivateDialog(
                showDialog = true,
                dialogTitle = "Preview",
                dialogDescription = "Preview description",
                onDismissDialog = {},
                onActivateClick = {},
                onDeactivateClick = {},
            )
        }
    }
}
