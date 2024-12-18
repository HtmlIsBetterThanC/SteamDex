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
fun AuthorsDialog(
    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    authors: String,
    modifier: Modifier = Modifier
) {
    InformationDialog(
        showDialog = showDialog,
        dialogTitle = stringResource(R.string.about_screen_dialog_title_authors),
        dialogDescription = authors,
        onDismissDialog = onDismissDialog,
        modifier = modifier
    )
}

@PreviewSteam
@Composable
private fun AuthorsDialogPreview() {
    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            AuthorsDialog(
                showDialog = true,
                onDismissDialog = {},
                authors = "Mario Mario and Luigi Mario"
            )
        }
    }
}
