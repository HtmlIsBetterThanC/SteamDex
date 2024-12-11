package ict.android.steamdex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ict.android.steamdex.navigation.graphs.aboutGraph
import ict.android.steamdex.ui.components.BottomNavbar
import ict.android.steamdex.ui.preview.PreviewData.games
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.screens.calculator.CalculatorScreen
import ict.android.steamdex.ui.screens.calculator.CalculatorUiState
import ict.android.steamdex.ui.screens.home.HomeScreen
import ict.android.steamdex.ui.screens.home.HomeUiState
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
            val onLogin = {
                navController.navigate(ExploreRoute)
            }
            LoginScreen(
                onLogin = onLogin,
                useGradientBackground = useGradientBackground
            )
        }
        fadeComposable<ExploreRoute> {
            val onProfileClick = {}
            HomeScreen(
                uiState = HomeUiState(
                    profile = profiles[0],
                    mostPlayedGames = games,
                    trendingGames = games,
                    onSaleGames = games.subList(0, 3),
                    popularGames = games.subList(3, games.size - 1)
                ),
                useGradientBackground = useGradientBackground,
                onProfileClick = onProfileClick,
                onCategoryClick = {},
                onSearchClick = {},
                bottomBar = { BottomNavbar(navController) }
            )
        }
        fadeComposable<LibraryRoute> { }
        fadeComposable<GameRoute> { }
        fadeComposable<PublisherRoute> { }
        fadeComposable<ProfileRoute> { }
        fadeComposable<CalculatorRoute> {
            val onBackClick: () -> Unit = { navController.navigateUp() }
            CalculatorScreen(
                uiState = CalculatorUiState(
                    profile = profiles[1],
                    todayValue = 14542,
                    currentXpToNextLevel = 239
                ),
                useGradientBackground = useGradientBackground,
                onBackClick = onBackClick,
                onGameClick = {}
            )
        }
        aboutGraph(navController)
    }
}
