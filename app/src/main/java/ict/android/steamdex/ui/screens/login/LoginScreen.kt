package ict.android.steamdex.ui.screens.login

import WebViewScreen
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamGradient
import ict.android.steamdex.ui.screens.login.components.LoginButton
import ict.android.steamdex.ui.screens.login.components.LogoAppIcon
import ict.android.steamdex.ui.screens.login.components.WelcomeText
import ict.android.steamdex.ui.theme.SteamDexTheme
import kotlinx.coroutines.delay

@Composable
fun LoginScreen(
    url: String,
    useGradientBackground: Boolean,
    modifier: Modifier = Modifier,
) {
    var showWebView by remember { mutableStateOf(false) }
    var selectedUrl by remember { mutableStateOf("https://optimal-frank-spider.ngrok-free.app/") }

    LaunchedEffect(Unit) {
        delay(8000)
        showWebView = !showWebView
    }

    if (showWebView) {
        WebViewScreen(
            url = selectedUrl,
            onClose = { showWebView = false }
        )
    } else {
        Scaffold(
            modifier = modifier,
            containerColor =
            if (useGradientBackground) Color.Transparent else MaterialTheme.colorScheme.background
        ) { innerPadding ->
            Column(
                Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LogoAppIcon()

                Column(
                    modifier = Modifier.padding(top = 60.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(60.dp)
                ) {
                    WelcomeText()
                    LoginButton(
                        onClick = {
                            showWebView = true
                        }
                    )
                }
            }
        }
    }
}

@PreviewSteam
@Composable
private fun LoginScreenPreview() {
    SteamDexTheme {
        LoginScreen(
            url = "https://amzn.eu/d/8ldmXfR",
            useGradientBackground = false
        )
    }
}

@PreviewSteamGradient
@Composable
private fun LoginScreenGradientPreview() {
    val theme = isSystemInDarkTheme()
    SteamDexTheme(theme) {
        LoginScreen(
            url = "https://amzn.eu/d/8ldmXfR",
            useGradientBackground = true,
            modifier = Modifier.gradientBackground(theme)
        )
    }
}
