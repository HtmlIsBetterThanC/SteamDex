package ict.android.steamdex.navigation.graphs

import androidx.compose.ui.platform.LocalUriHandler
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import ict.android.steamdex.DonationLink
import ict.android.steamdex.ReleasesLink
import ict.android.steamdex.SourceLink
import ict.android.steamdex.TranslationLink
import ict.android.steamdex.navigation.AboutGraphRoute
import ict.android.steamdex.navigation.slideInComposable
import ict.android.steamdex.ui.screens.about.AboutAppScreen
import ict.android.steamdex.ui.screens.about.DependenciesScreen
import kotlinx.serialization.Serializable

@Serializable
private object AboutMainRoute

@Serializable
private object AboutDependenciesRoute

fun NavGraphBuilder.aboutGraph(navController: NavHostController, useGradientBackground: Boolean) {
    navigation<AboutGraphRoute>(AboutMainRoute) {
        slideInComposable<AboutMainRoute> {
            val uriHandler = LocalUriHandler.current
            val onBackClick: () -> Unit = { navController.navigateUp() }
            val onTranslateClick = { uriHandler.openUri(TranslationLink) }
            val onDependenciesClick = {
                navController.navigate(AboutDependenciesRoute) {
                    launchSingleTop = true
                }
            }
            val onDonateClick = { uriHandler.openUri(DonationLink) }
            val onGithubClick = { uriHandler.openUri(SourceLink) }
            val onUpdatesClick = {
                // TODO toast
                uriHandler.openUri(ReleasesLink)
            }

            // TODO get data from the link in Utils
            AboutAppScreen(
                userGradientBackground = useGradientBackground,
                authors = "HtmlIsBetterThanC, Vanehir, Gaudan90",
                privacyPolicy = "Privacy Policy\n" +
                    "SteamDex takes your privacy seriously. To better protect your privacy we " +
                    "provide this privacy policy notice explaining the way your personal " +
                    "information is collected and used.\n" +
                    "\n" +
                    "Collection of Information\n" +
                    "SteamDex collects the steamid of the user from their Steam account after " +
                    "they have logged in. No other data is obtained or stored.",
                appLicense = "GNU GPLv3",
                onBackClick = onBackClick,
                onTranslationClick = onTranslateClick,
                onDonationClick = onDonateClick,
                onDependenciesClick = onDependenciesClick,
                onGitHubClick = onGithubClick,
                onUpdatesClick = onUpdatesClick
            )
        }

        slideInComposable<AboutDependenciesRoute> {
            val onBackClick: () -> Unit = { navController.navigateUp() }
            val onCloseClick: () -> Unit = { navController.popBackStack(AboutGraphRoute, true) }
            DependenciesScreen(
                userGradientBackground = useGradientBackground,
                onBackClick = onBackClick,
                onCloseClick = onCloseClick
            )
        }
    }
}
