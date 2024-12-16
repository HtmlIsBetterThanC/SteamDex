package ict.android.steamdex.ui.screens.about

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mikepenz.aboutlibraries.ui.compose.m3.LibrariesContainer
import com.mikepenz.aboutlibraries.ui.compose.m3.LibraryDefaults
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamGradient
import ict.android.steamdex.ui.screens.about.components.DependenciesTopAppBar
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun DependenciesScreen(
    userGradientBackground: Boolean,
    onBackClick: () -> Unit,
    onCloseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            DependenciesTopAppBar(
                userGradientBackground = userGradientBackground,
                onBackClick = onBackClick,
                onCloseClick = onCloseClick
            )
        },
        containerColor =
        if (userGradientBackground) Color.Transparent else MaterialTheme.colorScheme.background
    ) { innerPadding ->
        LibrariesContainer(
            modifier = Modifier.padding(innerPadding),
            colors = if (userGradientBackground) {
                LibraryDefaults.libraryColors(
                    backgroundColor = Color.Transparent,
                    contentColor = contentColorFor(MaterialTheme.colorScheme.background)
                )
            } else {
                LibraryDefaults.libraryColors()
            }
        )
    }
}

@PreviewSteam
@Composable
private fun DependenciesScreenPreview() {
    SteamDexTheme {
        DependenciesScreen(
            userGradientBackground = false,
            onBackClick = {},
            onCloseClick = {}
        )
    }
}

@PreviewSteamGradient
@Composable
private fun DependenciesScreenGradientPreview() {
    SteamDexTheme {
        DependenciesScreen(
            userGradientBackground = true,
            onBackClick = {},
            onCloseClick = {},
            modifier = Modifier.gradientBackground(isSystemInDarkTheme())
        )
    }
}
