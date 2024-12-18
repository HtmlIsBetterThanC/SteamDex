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
import ict.android.steamdex.ui.screens.explore.Category
import ict.android.steamdex.ui.screens.explore.ExploreScreen
import ict.android.steamdex.ui.screens.profile.ProfileScreen
import ict.android.steamdex.viewmodels.ExploreViewModel
import ict.android.steamdex.viewmodels.ProfileViewModel
import ict.android.steamdex.ui.components.BottomNavbar
import ict.android.steamdex.ui.screens.library.LibraryScreen
import ict.android.steamdex.viewmodels.LibraryViewModel

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
        fadeComposable<LoginRoute> { }
        fadeComposable<ExploreRoute> {
            val viewModel = hiltViewModel<ExploreViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            val onProfileClick = {
                navController.navigate(ProfileRoute)
            }

            val onCategoryClick = { categoryId: Int ->
            }

            val onCarouselExpandedClick = { categoryId: Int, expanded: Boolean ->
                when (categoryId) {
                    Category.MostPlayed.id -> viewModel.updateMostPlayedGamesExpanded(expanded)
                    Category.Trending.id -> viewModel.updateTrendingGamesExpanded(expanded)
                    Category.OnSale.id -> viewModel.updateOnSaleGamesExpanded(expanded)
                    Category.Popular.id -> viewModel.updatePopularGamesExpanded(expanded)
                }
            }

            val onSearchClick = {
            }

            LaunchedEffect(null) {
                viewModel.start()
            }

            ExploreScreen(
                uiState = uiState,
                useGradientBackground = false,
                onProfileClick = onProfileClick,
                onCategoryClick = onCategoryClick,
                onCarouselExpandedClick = onCarouselExpandedClick,
                onSearchClick = onSearchClick,
                bottomBar = {
                    BottomNavbar(navController)
                }
            )
        }
        fadeComposable<LibraryRoute> { }
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
        fadeComposable<ProfileRoute> {
            val viewModel = hiltViewModel<ProfileViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            val onCalculatorClick = {
                navController.navigate(CalculatorRoute) {
                    launchSingleTop = true
                    restoreState = true
                }
            }
            val onLanguageChange = { lang: String ->
                viewModel.updateLanguage(lang)
            }
            val onThemeChange = { darkTheme: Boolean? ->
                viewModel.updateDarkTheme(darkTheme)
            }
            val onPitchBlackChange = { pitchBlack: Boolean ->
                viewModel.updatePitchBlack(pitchBlack)
                viewModel.updateGradientBackground(false)
            }
            val onMaterialYouChange = { materialYou: Boolean ->
                viewModel.updateMaterialYou(materialYou)
                viewModel.updateGradientBackground(false)
            }
            val onGradientBackgroundChange = { gradientBackground: Boolean ->
                viewModel.updateGradientBackground(gradientBackground)
            }
            val onDefaultStartingScreenChange = { startingScreen: Any ->
                viewModel.updateDefaultStartingScreen(startingScreen)
            }

            val onAboutClick = {
                navController.navigate(AboutGraphRoute) {
                    launchSingleTop = true
                }
            }

            val onLogoutClick = {}
            val onResetSettingClick = {
                viewModel.resetAllSettings()
            }

            LaunchedEffect(null) {
                viewModel.start()
            }

            ProfileScreen(
                uiState = uiState,
                useGradientBackground = useGradientBackground,
                onCalculatorClick = onCalculatorClick,
                onLanguageChange = onLanguageChange,
                onThemeChange = onThemeChange,
                onPitchBlackChange = onPitchBlackChange,
                onMaterialYouChange = onMaterialYouChange,
                onGradientBackgroundChange = onGradientBackgroundChange,
                onDefaultStartingScreenChange = onDefaultStartingScreenChange,
                onAboutClick = onAboutClick,
                onResetSettingClick = onResetSettingClick,
                onLogoutClick = onLogoutClick,
                bottomBar = {
                    BottomNavbar(navController)
                }
            )
        }
        fadeComposable<CalculatorRoute> { }
        aboutGraph(navController, useGradientBackground)
    }
}
