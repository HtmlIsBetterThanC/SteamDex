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
fun AppLicenseDialog(
    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    license: String,
    modifier: Modifier = Modifier
) {
    InformationDialog(
        showDialog = showDialog,
        dialogTitle = stringResource(R.string.about_screen_dialog_title_app_license),
        dialogDescription = license,
        onDismissDialog = onDismissDialog,
        modifier = modifier
    )
}

@PreviewSteam
@Composable
private fun AppLicenseDialogPreview() {
    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            AppLicenseDialog(
                showDialog = true,
                onDismissDialog = {},
                license = "GPL v.3"
            )
        }
    }
}
