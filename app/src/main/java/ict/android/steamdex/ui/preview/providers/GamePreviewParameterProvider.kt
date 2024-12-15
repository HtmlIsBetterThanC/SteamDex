import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ict.android.steamdex.ui.preview.PreviewData.games
import ict.android.steamdex.ui.preview.PreviewData.profiles
import ict.android.steamdex.ui.screens.game.GameUiState

class GamePreviewParameterProvider : PreviewParameterProvider<GameUiState> {
    override val values = sequenceOf(
        GameUiState(
            game = games[0],
            profile = profiles[0]
        ),
        GameUiState(
            game = games[1],
            profile = profiles[1]
        ),
        GameUiState(
            game = games[2],
            profile = profiles[2]
        ),
        GameUiState(
            game = games[3],
            profile = profiles[3]
        ),
        GameUiState(
            game = games[4],
            profile = profiles[4]
        )
    )
}
