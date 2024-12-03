package ict.android.steamdex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ict.android.steamdex.navigation.graphs.aboutGraph

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
        fadeComposable<HomeRoute> { }
        fadeComposable<LibraryRoute> { }
        fadeComposable<GameRoute> { }
        fadeComposable<PublisherRoute> { }
        fadeComposable<ProfileRoute> { }
        fadeComposable<CalculatorRoute> { }
        aboutGraph(navController)
    }
}
