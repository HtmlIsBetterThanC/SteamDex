package ict.android.steamdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ict.android.steamdex.navigation.NavigationHost
import ict.android.steamdex.navigation.ProfileRoute
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.theme.SteamDexTheme
import ict.android.steamdex.viewmodels.MainActivityViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
                    startDestination = ProfileRoute
                )
            }
        }
    }
}
