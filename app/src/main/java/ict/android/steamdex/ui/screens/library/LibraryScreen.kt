package ict.android.steamdex.ui.screens.library

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import ict.android.steamdex.ui.components.BottomNavbar
import ict.android.steamdex.ui.components.SearchFAB
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamGradient
import ict.android.steamdex.ui.preview.providers.LibraryPreviewParametersProvider
import ict.android.steamdex.ui.screens.library.components.LibraryGameItem
import ict.android.steamdex.ui.screens.library.components.LibraryTopBar
import ict.android.steamdex.ui.theme.SteamDexTheme

// TODO handle empty list
@Composable
fun LibraryScreen(
    uiState: LibraryUiState,
    useGradientBackground: Boolean,
    onProfileClick: () -> Unit,
    onGameClick: (Long) -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
    bottomBar: @Composable () -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            LibraryTopBar(
                useGradientBackground = useGradientBackground,
                profile = uiState.profile,
                onProfileClick = onProfileClick
            )
        },
        bottomBar = bottomBar,
        floatingActionButton = {
            SearchFAB(onSearchClick)
        },
        containerColor =
        if (useGradientBackground) Color.Transparent else MaterialTheme.colorScheme.background
    ) { innerPadding ->
        if (uiState.isLoading) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(innerPadding),
                horizontalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(uiState.games) { game ->
                    // TODO what if hours Played is empty
                    game.hoursPlayed?.let {
                        LibraryGameItem(
                            iconUrl = game.iconUrl,
                            name = game.name,
                            hoursPlayed = it,
                            onGameClick = {
                                onGameClick(game.id)
                            }
                        )
                    }
                }
            }
        }
    }
}

@PreviewSteam
@Composable
private fun LibraryScreenPreview(
    @PreviewParameter(LibraryPreviewParametersProvider::class) uiState: LibraryUiState
) {
    SteamDexTheme {
        LibraryScreen(
            uiState = uiState,
            useGradientBackground = false,
            onProfileClick = {},
            onGameClick = {},
            onSearchClick = {},
            bottomBar = { BottomNavbar(rememberNavController()) }
        )
    }
}

@PreviewSteamGradient
@Composable
private fun LibraryScreenGradientPreview(
    @PreviewParameter(LibraryPreviewParametersProvider::class) uiState: LibraryUiState
) {
    SteamDexTheme {
        LibraryScreen(
            uiState = uiState,
            useGradientBackground = true,
            onProfileClick = {},
            onGameClick = {},
            onSearchClick = {},
            modifier = Modifier.gradientBackground(isSystemInDarkTheme()),
            bottomBar = { BottomNavbar(rememberNavController()) }
        )
    }
}
