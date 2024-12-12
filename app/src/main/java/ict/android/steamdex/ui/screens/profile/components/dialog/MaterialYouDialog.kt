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
fun MaterialYouDialog(
    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    onMaterialYouActivateClick: () -> Unit,
    onMaterialYouDeactivateClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ActivateDialog(
        showDialog = showDialog,
        dialogTitle = stringResource(R.string.profile_screen_material_you_dialog_title),
        dialogDescription = stringResource(R.string.profile_screen_material_you_dialog_description),
        onDismissDialog = onDismissDialog,
        onActivateClick = onMaterialYouActivateClick,
        onDeactivateClick = onMaterialYouDeactivateClick,
        modifier = modifier
    )
}

@PreviewSteam
@Composable
private fun MaterialYouDialogPreview() {
    var materialYou by remember {
        mutableStateOf(false)
    }

    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            MaterialYouDialog(
                showDialog = true,
                onDismissDialog = {},
                onMaterialYouActivateClick = { materialYou = true },
                onMaterialYouDeactivateClick = { materialYou = false },
            )
        }
    }
}
