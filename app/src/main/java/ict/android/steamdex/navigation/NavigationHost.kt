package ict.android.steamdex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ict.android.steamdex.navigation.graphs.aboutGraph
import ict.android.steamdex.ui.components.BottomNavbar
import ict.android.steamdex.ui.screens.library.LibraryScreen
import ict.android.steamdex.viewmodels.LibraryViewModel

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
            val viewModel = hiltViewModel<LibraryViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

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

            LaunchedEffect(null) {
                viewModel.start()
            }

            LibraryScreen(
                uiState = uiState,
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
