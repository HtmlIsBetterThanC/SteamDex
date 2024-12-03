package ict.android.steamdex.ui.screens.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.providers.CalculatorPreviewParametersProvider
import ict.android.steamdex.ui.components.TopAppBarLarge
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun CalculatorScreen(
    uiState: CalculatorUiState,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val profile = uiState.profile
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarLarge(
                profile = profile,
                backEnabled = true,
                firstIconId = R.drawable.age,
                secondIconId = R.drawable.country_code,
                firstIconDescriptionId = R.string.profile_age_icon_description,
                secondIconDescriptionId = R.string.profile_country_code_description,
                firstDetails = profile.age,
                secondDetails = profile.countryCode,
                onBackClick = onBackClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

        }
    }
}

@PreviewSteam
@Composable
private fun CalculatorScreenPreview(
    @PreviewParameter(CalculatorPreviewParametersProvider::class) uiState: CalculatorUiState
) {
    SteamDexTheme {
        CalculatorScreen(uiState, {})
    }
}
