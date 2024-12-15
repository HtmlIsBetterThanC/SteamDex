package ict.android.steamdex.ui.screens.about.components.dialogs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.dialogs.InformationDialog
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun AppVersionDialog(
    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    version: String,
    modifier: Modifier = Modifier
) {
    InformationDialog(
        showDialog = showDialog,
        dialogTitle = stringResource(R.string.dialog_title_app_version),
        dialogDescription = version,
        onDismissDialog = onDismissDialog,
        modifier = modifier
    )
}

@PreviewSteam
@Composable
private fun AppVersionDialogPreview() {
    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            AppVersionDialog(
                showDialog = true,
                onDismissDialog = {},
                version = stringResource(R.string.dialog_description_app_version)
            )
        }
    }
}
