package ict.android.steamdex.ui.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import ict.android.steamdex.R
import ict.android.steamdex.models.ui.UiGames
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.providers.HomePreviewParametersProvider
import ict.android.steamdex.ui.screens.home.HomeUiState
import ict.android.steamdex.ui.theme.SteamDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularCategory(
    popularGames: List<UiGames>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        CategoryGamesBar(
            categoryIconId = R.drawable.popular,
            categoryIconDescriptionId = R.string.popular_icon_description,
            categoryTitleId = R.string.home_popular_category,
            onClick = onClick
        )
        HorizontalCarousel(popularGames)
    }
}

@PreviewSteam
@Composable
private fun PopularPreview(
    @PreviewParameter(HomePreviewParametersProvider::class) uiState: HomeUiState
) {
    SteamDexTheme {
        Surface {
            PopularCategory(uiState.popularGames, {})
        }
    }
}
