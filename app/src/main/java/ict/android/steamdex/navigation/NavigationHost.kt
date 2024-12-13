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
import ict.android.steamdex.ui.screens.profile.ProfileScreen
import ict.android.steamdex.viewmodels.ProfileViewModel

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
        fadeComposable<LibraryRoute> { }
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
            val onResetSettingClick = {
                viewModel.resetAllSettings()
            }

            LaunchedEffect(null) {
                viewModel.start()
            }

            ProfileScreen(
                uiState = uiState,
                useGradientBackground = false,
                onCalculatorClick = onCalculatorClick,
                onLanguageChange = onLanguageChange,
                onThemeChange = onThemeChange,
                onPitchBlackChange = onPitchBlackChange,
                onMaterialYouChange = onMaterialYouChange,
                onGradientBackgroundChange = onGradientBackgroundChange,
                onDefaultStartingScreenChange = onDefaultStartingScreenChange,
                onResetSettingClick = onResetSettingClick,
                bottomBar = {
                    BottomNavbar(navController)
                }
            )
        }
        fadeComposable<CalculatorRoute> { }
        aboutGraph(navController)
    }
}
