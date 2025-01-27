package ict.android.steamdex

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ict.android.steamdex.navigation.ExploreRoute
import ict.android.steamdex.navigation.LoginRoute
import ict.android.steamdex.navigation.NavigationHost
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.theme.SteamDexTheme
import ict.android.steamdex.viewmodels.MainActivityViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isSplashScreenRunning.value
            }
            setOnExitAnimationListener { screen ->
                val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.4f, 0.0f)
                val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.4f, 0.0f)

                val scaleAnimator = ObjectAnimator.ofPropertyValuesHolder(
                    screen.iconView,
                    scaleX,
                    scaleY
                ).apply {
                    interpolator = OvershootInterpolator()
                    duration = 500L
                    doOnEnd { screen.remove() }
                }
                scaleAnimator.start()
            }
        }

        setContent {
            val darkTheme by viewModel.darkTheme.collectAsStateWithLifecycle()
            val pitchBlack by viewModel.pitchBlack.collectAsStateWithLifecycle()
            val materialYou by viewModel.materialYou.collectAsStateWithLifecycle()
            val useGradientBackground by viewModel.gradientBackground.collectAsStateWithLifecycle()
            SteamDexTheme(
                darkTheme = darkTheme,
                amoledMode = pitchBlack,
                materialYou = materialYou
            ) {
                val navModifier =
                    if (useGradientBackground) {
                        Modifier.fillMaxSize().gradientBackground((darkTheme ?: isSystemInDarkTheme()))
                    } else {
                        Modifier.fillMaxSize()
                    }

                val navController = rememberNavController()
                NavigationHost(
                    navController = navController,
                    useGradientBackground = useGradientBackground,
                    modifier = navModifier,
                    //startDestination = ExploreRoute
                )
            }
        }
    }
}
