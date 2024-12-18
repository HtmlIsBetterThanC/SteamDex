package ict.android.steamdex.ui.screens.about.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
            text = stringResource(R.string.about_screen_authors_title),
            onClick = onAuthorsClick,
            buttonColor = MaterialTheme.colorScheme.secondaryContainer

        ),
        ButtonConfig(
            icon = painterResource(R.drawable.translate),
            text = stringResource(R.string.about_screen_translation_title),
            onClick = onTranslationClick,
            buttonColor = MaterialTheme.colorScheme.secondaryContainer

        ),
        ButtonConfig(
            icon = painterResource(R.drawable.volunteer_activism),
            text = stringResource(R.string.about_screen_donations_title),
            onClick = onDonationClick,
            buttonColor = MaterialTheme.colorScheme.tertiaryContainer

        )
    )
    val secondRowButtons = listOf(
        ButtonConfig(
            icon = painterResource(R.drawable.contract),
            text = stringResource(R.string.about_screen_dependencies_title),
            onClick = onDependenciesClick,
            buttonColor = MaterialTheme.colorScheme.secondaryContainer

        ),
        ButtonConfig(
            icon = painterResource(R.drawable.article),
            text = stringResource(R.string.about_screen_app_licenses_title),
            onClick = onAppLicensesClick,
            buttonColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        ButtonConfig(
            icon = painterResource(R.drawable.github),
            text = stringResource(R.string.about_screen_github_title),
            onClick = onGitHubClick,
            buttonColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    )
    val thirdRowButtons = listOf(
        ButtonConfig(
            icon = painterResource(R.drawable.visibility),
            text = stringResource(R.string.about_screen_privacy_policy_title),
            onClick = onPrivacyPolicyClick,
            buttonColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        ButtonConfig(
            icon = painterResource(R.drawable.security_update_warning),
            text = stringResource(R.string.about_screen_app_version_title),
            onClick = onAppVersionClick,
            buttonColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        ButtonConfig(
            icon = painterResource(R.drawable.cached),
            text = stringResource(R.string.about_screen_updates_title),
            onClick = onUpdatesClick,
            buttonColor = MaterialTheme.colorScheme.primaryContainer
        )
    )

    ButtonRow(firstRowButtons, modifier)

    ButtonRow(secondRowButtons, modifier)

    ButtonRow(thirdRowButtons, modifier)
}
