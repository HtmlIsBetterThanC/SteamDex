package ict.android.steamdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ict.android.steamdex.navigation.NavigationHost
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.theme.SteamDexTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SteamDexTheme {
                // TODO collect from viewmodel
                val darkTheme = isSystemInDarkTheme()
                val useGradientBackground by remember {
                    mutableStateOf(true)
                }
                val navModifier =
                    if (useGradientBackground) {
                        Modifier.fillMaxSize().gradientBackground(darkTheme)
                    } else {
                        Modifier.fillMaxSize()
                    }
                val navController = rememberNavController()
                NavigationHost(
                    navController = navController,
                    useGradientBackground = useGradientBackground,
                    modifier = navModifier
                )
            }
        }
    }
}
