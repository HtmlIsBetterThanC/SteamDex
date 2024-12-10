package ict.android.steamdex.ui.screens.about

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mikepenz.aboutlibraries.ui.compose.m3.LibrariesContainer
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.screens.about.components.TopAppBar
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun DependenciesScreen(
    onBackClick: () -> Unit,
    onCloseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                onBackClick = onBackClick,
                onCloseClick = onCloseClick
            )
        }
    ) { innerPadding ->
        // TODO add progress indicator
        LibrariesContainer(Modifier.padding(innerPadding))
    }
}

@PreviewSteam
@Composable
private fun DependenciesScreenPreview() {
    SteamDexTheme {
        DependenciesScreen(
            onBackClick = {},
            onCloseClick = {}
        )
    }
}
