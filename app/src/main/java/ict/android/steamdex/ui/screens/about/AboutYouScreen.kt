package ict.android.steamdex.ui.screens.about

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ict.android.steamdex.ui.components.buttons.icons.BackArrowButton
import ict.android.steamdex.ui.components.modifiers.gradientBackground
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamGradient
import ict.android.steamdex.ui.screens.about.components.AboutButtonsList
import ict.android.steamdex.ui.screens.about.components.AppLogo
import ict.android.steamdex.ui.theme.SteamDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutYouScreen(
    userGradientBackground: Boolean,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    BackArrowButton(
                        onClick = onBackClick
                    )
                },
                colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Transparent
                )

            )
        },
        containerColor =
        if (userGradientBackground) Color.Transparent else MaterialTheme.colorScheme.background

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(80.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppLogo()
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AboutButtonsList()
            }
        }
    }
}

@PreviewSteam
@Composable
private fun AboutYouScreenPreview() {
    SteamDexTheme {
        AboutYouScreen(
            userGradientBackground = false,
            onBackClick = { }
        )
    }
}

@PreviewSteamGradient
@Composable
private fun AboutYouScreenGradientPreview() {
    val theme = isSystemInDarkTheme()
    SteamDexTheme(theme) {
        AboutYouScreen(
            userGradientBackground = true,
            modifier = Modifier.gradientBackground(theme),
            onBackClick = { }
        )
    }
}
