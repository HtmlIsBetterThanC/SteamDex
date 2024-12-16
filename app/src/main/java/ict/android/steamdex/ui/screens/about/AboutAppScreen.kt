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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import ict.android.steamdex.ui.screens.about.components.dialogs.AppLicenseDialog
import ict.android.steamdex.ui.screens.about.components.dialogs.AppVersionDialog
import ict.android.steamdex.ui.screens.about.components.dialogs.AuthorsDialog
import ict.android.steamdex.ui.screens.about.components.dialogs.PrivacyPolicyDialog
import ict.android.steamdex.ui.theme.SteamDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutAppScreen(
    userGradientBackground: Boolean,
    authors: String,
    privacyPolicy: String,
    appLicense: String,
    onBackClick: () -> Unit,
    onTranslationClick: () -> Unit,
    onDonationClick: () -> Unit,
    onDependenciesClick: () -> Unit,
    onGitHubClick: () -> Unit,
    onUpdatesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showAuthorsDialog by remember { mutableStateOf(false) }
    var showLicenseDialog by remember { mutableStateOf(false) }
    var showPrivacyDialog by remember { mutableStateOf(false) }
    var showVersionDialog by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    BackArrowButton(onBackClick)
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
            verticalArrangement = Arrangement.spacedBy(80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .weight(.8f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppLogo()
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AboutButtonsList(
                    onAuthorsClick = { showAuthorsDialog = true },
                    onTranslationClick = onTranslationClick,
                    onDonationClick = onDonationClick,
                    onDependenciesClick = onDependenciesClick,
                    onAppLicensesClick = { showLicenseDialog = true },
                    onGitHubClick = onGitHubClick,
                    onPrivacyPolicyClick = { showPrivacyDialog = true },
                    onAppVersionClick = { showVersionDialog = true },
                    onUpdatesClick = onUpdatesClick
                )
            }
            AuthorsDialog(
                showDialog = showAuthorsDialog,
                onDismissDialog = { showAuthorsDialog = false },
                authors = authors
            )
            AppLicenseDialog(
                showDialog = showLicenseDialog,
                onDismissDialog = { showLicenseDialog = false },
                license = appLicense
            )
            PrivacyPolicyDialog(
                showDialog = showPrivacyDialog,
                onDismissDialog = { showPrivacyDialog = false },
                privacyPolicy = privacyPolicy
            )
            AppVersionDialog(
                showDialog = showVersionDialog,
                onDismissDialog = { showVersionDialog = false }
            )
        }
    }
}

@PreviewSteam
@Composable
private fun AboutYouScreenPreview() {
    SteamDexTheme {
        AboutAppScreen(
            userGradientBackground = false,
            authors = "Mario Mario and Luigi Mario",
            privacyPolicy = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            appLicense = "GPL v.3",
            onBackClick = { },
            onTranslationClick = {},
            onDonationClick = { },
            onDependenciesClick = {},
            onGitHubClick = { },
            onUpdatesClick = { }
        )
    }
}

@PreviewSteamGradient
@Composable
private fun AboutYouScreenGradientPreview() {
    SteamDexTheme {
        AboutAppScreen(
            userGradientBackground = true,
            authors = "Mario Mario and Luigi Mario",
            privacyPolicy = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            appLicense = "GPL v.3",
            onBackClick = { },
            onTranslationClick = {},
            onDonationClick = { },
            onDependenciesClick = {},
            onGitHubClick = { },
            onUpdatesClick = { },
            modifier = Modifier.gradientBackground(isSystemInDarkTheme())
        )
    }
}
