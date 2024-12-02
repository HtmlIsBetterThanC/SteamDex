package ict.android.steamdex.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import ict.android.steamdex.navigation.AboutGraphRoute
import ict.android.steamdex.navigation.slideInComposable
import kotlinx.serialization.Serializable

@Serializable
private object AboutMainRoute

@Serializable
private object AboutDependenciesRoute

fun NavGraphBuilder.aboutGraph(navController: NavHostController) {
    navigation<AboutGraphRoute>(AboutMainRoute) {
        slideInComposable<AboutMainRoute> {
            val onBackClick = navController.navigateUp()
            val navigateToDependencies = navController.navigate(AboutDependenciesRoute) {
                launchSingleTop = true
            }
        }

        slideInComposable<AboutDependenciesRoute> {
            val onBackClick = navController.navigateUp()
            val onCloseClick = { navController.popBackStack(AboutGraphRoute, true) }
        }
    }
}
