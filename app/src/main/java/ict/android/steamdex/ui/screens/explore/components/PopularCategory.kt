package ict.android.steamdex.ui.screens.explore.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import ict.android.steamdex.R
import ict.android.steamdex.models.ui.UiGame
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.providers.ExplorePreviewParametersProvider
import ict.android.steamdex.ui.screens.explore.ExploreUiState
import ict.android.steamdex.ui.theme.SteamDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularCategory(
    popularGames: List<UiGame>,
    editMode: Boolean,
    isExpanded: Boolean,
    onCategoryClick: () -> Unit,
    onIsExpandedClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        CategoryGamesBar(
            categoryIconId = R.drawable.popular,
            categoryIconDescriptionId = R.string.popular_icon_description,
            categoryTitleId = R.string.explore_screen_popular_category_title,
            editMode = editMode,
            isExpanded = isExpanded,
            onCategoryBarClick = onCategoryClick,
            onIsExpandedClick = onIsExpandedClick
        )
        HorizontalCarousel(
            popularGames,
            large = isExpanded
        )
    }
}

@PreviewSteam
@Composable
private fun PopularCategoryPreview(
    @PreviewParameter(ExplorePreviewParametersProvider::class) uiState: ExploreUiState
) {
    SteamDexTheme {
        Surface {
            PopularCategory(
                popularGames = uiState.popularGames,
                editMode = false,
                isExpanded = uiState.isPopularGamesExpanded,
                onCategoryClick = {},
                onIsExpandedClick = {}
            )
        }
    }
}

@PreviewSteam
@Composable
private fun PopularCategoryEditPreview(
    @PreviewParameter(ExplorePreviewParametersProvider::class) uiState: ExploreUiState
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    SteamDexTheme {
        Surface {
            PopularCategory(
                popularGames = uiState.popularGames,
                editMode = true,
                isExpanded = isExpanded,
                onCategoryClick = {},
                onIsExpandedClick = {
                    isExpanded = it
                }
            )
        }
    }
}
