package ict.android.steamdex.ui.screens.about.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ict.android.steamdex.R
import ict.android.steamdex.ui.screens.about.ButtonConfig

@Composable
fun AboutButtonsList(
    onAuthorsClick: () -> Unit,
    onTranslationClick: () -> Unit,
    onDonationClick: () -> Unit,
    onDependenciesClick: () -> Unit,
    onAppLicensesClick: () -> Unit,
    onGitHubClick: () -> Unit,
    onPrivacyPolicyClick: () -> Unit,
    onAppVersionClick: () -> Unit,
    onUpdatesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val firstRowButtons = listOf(
        ButtonConfig(
            icon = painterResource(R.drawable.group_filled),
            text = "Authors",
            onClick = onAuthorsClick,
            buttonColor = MaterialTheme.colorScheme.secondaryContainer

        ),
        ButtonConfig(
            icon = painterResource(R.drawable.translate),
            text = "Translation",
            onClick = onTranslationClick,
            buttonColor = MaterialTheme.colorScheme.secondaryContainer

        ),
        ButtonConfig(
            icon = painterResource(R.drawable.volunteer_activism),
            text = "Donations",
            onClick = onDonationClick,
            buttonColor = MaterialTheme.colorScheme.tertiaryContainer

        )
    )
    val secondRowButtons = listOf(
        ButtonConfig(
            icon = painterResource(R.drawable.contract),
            text = "Dependencies",
            onClick = onDependenciesClick,
            buttonColor = MaterialTheme.colorScheme.secondaryContainer

        ),
        ButtonConfig(
            icon = painterResource(R.drawable.article),
            text = "App Licenses",
            onClick = onAppLicensesClick,
            buttonColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        ButtonConfig(
            icon = painterResource(R.drawable.github_mark_1),
            text = "GitHub",
            onClick = onGitHubClick,
            buttonColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    )
    val thirdRowButtons = listOf(
        ButtonConfig(
            icon = painterResource(R.drawable.visibility),
            text = "Privacy Policy",
            onClick = onPrivacyPolicyClick,
            buttonColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        ButtonConfig(
            icon = painterResource(R.drawable.security_update_warning),
            text = "App Version",
            onClick = onAppVersionClick,
            buttonColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        ButtonConfig(
            icon = painterResource(R.drawable.cached),
            text = "Updates",
            onClick = onUpdatesClick,
            buttonColor = MaterialTheme.colorScheme.primaryContainer
        )
    )

    ButtonRow(firstRowButtons, modifier)

    ButtonRow(secondRowButtons, modifier)

    ButtonRow(thirdRowButtons, modifier)
}
