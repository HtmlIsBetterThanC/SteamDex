package ict.android.steamdex.navigation

import android.R.attr.width
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

inline fun <reified T : Any> NavGraphBuilder.slideInComposable(
    noinline content: @Composable (AnimatedVisibilityScope.(NavBackStackEntry) -> Unit)
) {
    composable<T>(
        enterTransition = {
            slideInHorizontally(
                animationSpec = tween(durationMillis = 170)
            ) { width -> width / 3 }
        },
        exitTransition = {
            slideOutHorizontally(
                animationSpec = spring(stiffness = Spring.StiffnessHigh)
            ) { 170 }
        },
        popEnterTransition = {
            slideInHorizontally(
                animationSpec = tween(durationMillis = 170)
            ) { width -> -width / 3 }
        },
        popExitTransition = {
            slideOutHorizontally(
                animationSpec = spring(stiffness = Spring.StiffnessHigh)
            ) { 170 }
        },
        content = content
    )
}

inline fun <reified T : Any> NavGraphBuilder.fadeComposable(
    noinline content: @Composable (AnimatedVisibilityScope.(NavBackStackEntry) -> Unit)
) {
    composable<T>(
        enterTransition = {
            slideInHorizontally(
                animationSpec = tween(durationMillis = 170)
            ) { width -> -width / 3 }
        },
        exitTransition = {
            slideOutHorizontally(
                animationSpec = spring(stiffness = Spring.StiffnessHigh)
            ) { 170 }
        },
        content = content
    )
}
