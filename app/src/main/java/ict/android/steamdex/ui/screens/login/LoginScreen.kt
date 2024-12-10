package ict.android.steamdex.ui.screens.login

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.screens.login.components.LoginButton
import ict.android.steamdex.ui.screens.login.components.LogoAppIcon
import ict.android.steamdex.ui.screens.login.components.WelcomeText
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun LoginScreen(
    onLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        containerColor = Color.Transparent
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LogoAppIcon(Modifier.size(240.dp))

            Column(
                modifier = Modifier.padding(top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(60.dp)
            ) {
                WelcomeText()
                LoginButton(onLogin)
            }
        }
    }
}

@PreviewSteam
@Composable
private fun LoginScreenPreview() {
    val theme = isSystemInDarkTheme()
    SteamDexTheme(theme) {
        LoginScreen(
            {},
            Modifier.gradientBackground(theme)
        )
    }
}
