package ict.android.steamdex.navigation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ict.android.steamdex.navigation.graphs.aboutGraph
import ict.android.steamdex.ui.components.BottomNavbar
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewData.games
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.screens.library.LibraryScreen
import ict.android.steamdex.ui.screens.library.LibraryUiState

@Composable
fun NavigationHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: Any = LoginRoute
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        fadeComposable<LoginRoute> { }
        fadeComposable<ExploreRoute> { }
        fadeComposable<LibraryRoute> {
            val onProfileClick = {
                navController.navigate(ProfileRoute) {
                    launchSingleTop = true
                }
            }
            val onGameClick = { id: Long ->
                navController.navigate(GameRoute(id)) {
                    launchSingleTop = true
                }
            }
            val onSearchClick = {}

            LibraryScreen(
                uiState = LibraryUiState(
                    games = games,
                    profile = profiles[0]
                ),
                useGradientBackground = false,
                onProfileClick = onProfileClick,
                onGameClick = onGameClick,
                onSearchClick = onSearchClick,
                bottomBar = {
                    BottomNavbar(navController)
                }
            )
        }
        fadeComposable<GameRoute> { }
        fadeComposable<PublisherRoute> { }
        fadeComposable<ProfileRoute> { }
        fadeComposable<CalculatorRoute> { }
        aboutGraph(navController)
    }
}
