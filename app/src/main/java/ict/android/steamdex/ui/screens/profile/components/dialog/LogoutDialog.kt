package ict.android.steamdex.ui.screens.profile.components.dialog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.dialogs.ConfirmDialog
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun LogoutDialog(
    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    onConfirmDialog: () -> Unit,
    modifier: Modifier = Modifier
) {
    ConfirmDialog(
        showDialog = showDialog,
        dialogTitle = stringResource(R.string.profile_screen_logout_dialog_title),
        dialogDescription = stringResource(R.string.profile_screen_logout_dialog_description),
        onDismissDialog = onDismissDialog,
        onConfirmClick = onConfirmDialog,
        modifier = modifier,
        confirmTextColor = MaterialTheme.colorScheme.error
    )
}

@PreviewSteam
@Composable
private fun LogoutDialogPreview() {
    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            LogoutDialog(
                showDialog = true,
                onDismissDialog = {},
                onConfirmDialog = {}
            )
        }
    }
}
