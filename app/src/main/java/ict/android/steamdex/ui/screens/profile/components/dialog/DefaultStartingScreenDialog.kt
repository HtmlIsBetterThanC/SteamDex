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
import ict.android.steamdex.navigation.BottomNavbarScreens
import ict.android.steamdex.ui.components.buttons.RadioDialog
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun DefaultStartingScreenDialog(
    showDialog: Boolean,
    currentStartingScreen: Any,
    onDismissDialog: () -> Unit,
    onDefaultStartingScreenChange: (Any) -> Unit,
    modifier: Modifier = Modifier
) {
    val startingScreenListName = BottomNavbarScreens.map { stringResource(it.nameId) }
    val startingScreenListValue = BottomNavbarScreens.map { it.route }

    RadioDialog(
        showDialog = showDialog,
        title = stringResource(R.string.profile_screen_default_screen_dialog_title),
        currentValue = currentStartingScreen,
        optionListNames = startingScreenListName,
        optionListValues = startingScreenListValue,
        onDismissDialog = onDismissDialog,
        onItemClick = onDefaultStartingScreenChange,
        modifier = modifier
    )
}

@PreviewSteam
@Composable
private fun DefaultStartingScreenDialogPreview() {
    var defaultScreen by remember {
        mutableStateOf("")
    }
    SteamDexTheme {
        Surface(Modifier.fillMaxSize()) {
            DefaultStartingScreenDialog(
                showDialog = true,
                currentStartingScreen = defaultScreen,
                onDismissDialog = {},
                onDefaultStartingScreenChange = {
                    defaultScreen = it.toString()
                },
            )
        }
    }
}
