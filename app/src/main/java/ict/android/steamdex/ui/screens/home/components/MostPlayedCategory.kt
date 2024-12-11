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
fun MostPlayedCategory(
    mostPlayedGames: List<UiGames>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        CategoryGamesBar(
            categoryIconId = R.drawable.leaderboard,
            categoryIconDescriptionId = R.string.most_played_icon_description,
            categoryTitleId = R.string.home_most_played_category,
            onClick = onClick
        )
        HorizontalCarousel(
            games = mostPlayedGames,
            large = true
        )
    }
}

@PreviewSteam
@Composable
private fun MostPlayedPreview(
    @PreviewParameter(HomePreviewParametersProvider::class) uiState: HomeUiState
) {
    SteamDexTheme {
        Surface {
            MostPlayedCategory(uiState.mostPlayedGames, {})
        }
    }
}
