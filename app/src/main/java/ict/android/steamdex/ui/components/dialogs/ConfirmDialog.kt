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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ui.components.buttons.CancelButton
import ict.android.steamdex.ui.components.buttons.ConfirmButton
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamFontSize
import ict.android.steamdex.ui.theme.SteamDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmDialog(
    showDialog: Boolean,
    dialogTitle: String,
    dialogDescription: String,
    onDismissDialog: () -> Unit,
    onConfirmClick: () -> Unit,
    modifier: Modifier = Modifier,
    confirmTextColor: Color = LocalContentColor.current,
    cancelTextColor: Color = LocalContentColor.current
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
                        ConfirmButton({
                            onConfirmClick()
                            onDismissDialog()
                        }, color = confirmTextColor)
                        CancelButton(onDismissDialog, color = cancelTextColor)
                    }
                }
            }
        }
    }
}

@PreviewSteam
@PreviewSteamFontSize
@Composable
private fun ConfirmDialogPreview() {
    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            val (showDialog, onShowDialogChange) = remember { mutableStateOf(true) }
            ConfirmDialog(
                showDialog = showDialog,
                dialogTitle = "Hello world",
                dialogDescription = "Hello world, Hello world, Hello word",
                onDismissDialog = { onShowDialogChange(false) },
                onConfirmClick = {}
            )
            if (!showDialog) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button({ onShowDialogChange(true) }) {
                        Text("Show dialog")
                    }
                }
            }
        }
    }
}
