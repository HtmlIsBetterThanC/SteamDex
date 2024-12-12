package ict.android.steamdex.ui.screens.profile.components.dialog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.dialogs.ActivateDialog
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun GradientBackgroundDialog(
    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    onGradientBackgroundActivateClick: () -> Unit,
    onGradientBackgroundDeactivateClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ActivateDialog(
        showDialog = showDialog,
        dialogTitle = stringResource(R.string.profile_screen_gradient_background_dialog_title),
        dialogDescription = stringResource(R.string.profile_screen_gradient_background_dialog_description),
        onDismissDialog = onDismissDialog,
        onActivateClick = onGradientBackgroundActivateClick,
        onDeactivateClick = onGradientBackgroundDeactivateClick,
        modifier = modifier
    )
}

@PreviewSteam
@Composable
private fun GradientBackgroundDialogPreview() {
    var gradientBackground by remember {
        mutableStateOf(false)
    }

    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            GradientBackgroundDialog(
                showDialog = true,
                onDismissDialog = {},
                onGradientBackgroundActivateClick = { gradientBackground = true },
                onGradientBackgroundDeactivateClick = { gradientBackground = false }
            )
        }
    }
}
