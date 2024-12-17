package ict.android.steamdex

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import ict.android.steamdex.ui.theme.SteamDexTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
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
            SteamDexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) { }
            }
        }
    }
}
