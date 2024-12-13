package ict.android.steamdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ict.android.steamdex.navigation.ExploreRoute
import ict.android.steamdex.navigation.NavigationHost
import ict.android.steamdex.ui.theme.SteamDexTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SteamDexTheme {
                val navController = rememberNavController()
                NavigationHost(
                    navController = navController,
                    modifier = Modifier.fillMaxSize(),
                    startDestination = ExploreRoute
                )
            }
        }
    }
}
