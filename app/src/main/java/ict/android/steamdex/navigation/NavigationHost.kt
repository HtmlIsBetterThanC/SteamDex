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
import ict.android.steamdex.viewmodels.ExploreViewModel

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
        fadeComposable<GameRoute> { }
        fadeComposable<PublisherRoute> { }
        fadeComposable<ProfileRoute> { }
        fadeComposable<CalculatorRoute> { }
        aboutGraph(navController)
    }
}
