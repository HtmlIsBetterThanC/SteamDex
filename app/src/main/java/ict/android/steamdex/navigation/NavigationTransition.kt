package ict.android.steamdex.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

// TODO add new transitions or change default values

inline fun <reified T : Any> NavGraphBuilder.slideInComposable(
    noinline content: @Composable (AnimatedVisibilityScope.(NavBackStackEntry) -> Unit)
) {
    composable<T>(
        enterTransition = { slideInHorizontally { width -> width } },
        exitTransition = { slideOutHorizontally { width -> -width } },
        popEnterTransition = { slideInHorizontally { width -> -width } },
        popExitTransition = { slideOutHorizontally { width -> width } },
        content = content
    )
}

inline fun <reified T : Any> NavGraphBuilder.fadeComposable(
    noinline content: @Composable (AnimatedVisibilityScope.(NavBackStackEntry) -> Unit)
) {
    composable<T>(
        enterTransition = { fadeIn(initialAlpha = 0.3f) },
        exitTransition = { fadeOut(targetAlpha = 0.3f) },
        content = content
    )
}
