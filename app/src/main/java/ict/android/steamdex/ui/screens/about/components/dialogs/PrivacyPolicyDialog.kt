package ict.android.steamdex.ui.screens.about.components.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ict.android.steamdex.ui.components.dialogs.InformationDialog

@Composable
fun PrivacyPolicyDialog(
    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    dialogDescription: String,
    dialogTitle: String,
    modifier: Modifier = Modifier
) {
    InformationDialog(
        showDialog = showDialog,
        dialogTitle = dialogTitle,
        dialogDescription = dialogDescription,
        onDismissDialog = onDismissDialog,
        modifier = modifier
    )
}
