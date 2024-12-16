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
fun PrivacyPolicyDialog(
    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    privacyPolicy: String,
    modifier: Modifier = Modifier
) {
    InformationDialog(
        showDialog = showDialog,
        dialogTitle = stringResource(R.string.dialog_title_privacy_policy),
        dialogDescription = privacyPolicy,
        onDismissDialog = onDismissDialog,
        modifier = modifier
    )
}

@PreviewSteam
@Composable
private fun PrivacyPolicyDialogPreview() {
    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            PrivacyPolicyDialog(
                showDialog = true,
                onDismissDialog = {},
                privacyPolicy = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
                    "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit " +
                    "in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                    "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui " +
                    "officia deserunt mollit anim id est laborum"
            )
        }
    }
}
