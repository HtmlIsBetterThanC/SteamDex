package ict.android.steamdex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ict.android.steamdex.navigation.graphs.aboutGraph
import ict.android.steamdex.ui.screens.login.LoginScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    useGradientBackground: Boolean,
    modifier: Modifier = Modifier,
    startDestination: Any = LoginRoute
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        fadeComposable<LoginRoute> {
            val onLogin = {}
            LoginScreen(
                onLogin = onLogin,
                useGradientBackground = useGradientBackground
            )
        }
        fadeComposable<ExploreRoute> { }
        fadeComposable<LibraryRoute> { }
        fadeComposable<GameRoute> { }
        fadeComposable<PublisherRoute> { }
        fadeComposable<ProfileRoute> { }
        fadeComposable<CalculatorRoute> { }
        aboutGraph(navController)
    }
}
