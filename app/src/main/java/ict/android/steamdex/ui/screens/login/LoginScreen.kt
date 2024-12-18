package ict.android.steamdex.ui.screens.login

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ext.openCustomBrowserTab
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamGradient
import ict.android.steamdex.ui.screens.login.components.LoginButton
import ict.android.steamdex.ui.screens.login.components.LogoAppIcon
import ict.android.steamdex.ui.screens.login.components.WelcomeText
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun LoginScreen(
    url: String,
    useGradientBackground: Boolean,
    modifier: Modifier = Modifier
) {
    val ctx = LocalContext.current

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
                        ctx.openCustomBrowserTab(url)
                    }
                )
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
