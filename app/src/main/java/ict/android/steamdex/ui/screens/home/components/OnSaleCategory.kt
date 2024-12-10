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
fun OnSaleCategory(
    onSaleGames: List<UiGames>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        CategoryGamesBar(
            categoryIconId = R.drawable.savings,
            categoryIconDescriptionId = R.string.savings_icon_description,
            categoryTitleId = R.string.home_on_sale_category,
            onClick = onClick
        )
        HorizontalCarousel(onSaleGames)
    }
}

@PreviewSteam
@Composable
private fun OnSaleCategoryPreview(
    @PreviewParameter(HomePreviewParametersProvider::class) uiState: HomeUiState
) {
    SteamDexTheme {
        Surface {
            OnSaleCategory(uiState.onSaleGames, {})
        }
    }
}
