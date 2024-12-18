package ict.android.steamdex.ui.screens.about.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.buttons.icons.BackArrowButton
import ict.android.steamdex.ui.components.buttons.icons.CloseButton
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DependenciesTopAppBar(
    userGradientBackground: Boolean,
    onBackClick: () -> Unit,
    onCloseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val iconTint = MaterialTheme.colorScheme.onSurface
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.dependencies_screen_dependencies_title),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.displaySmall
            )
        },
        modifier = modifier.fillMaxWidth(),
        navigationIcon = {
            BackArrowButton(onBackClick, tint = iconTint)
        },
        actions = {
            CloseButton(onCloseClick, tint = iconTint)
        },
        colors =
        if (userGradientBackground) {
            TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                scrolledContainerColor = Color.Transparent
            )
        } else {
            TopAppBarDefaults.centerAlignedTopAppBarColors()
        }
    )
}

@PreviewSteam
@Composable
private fun TopAppBarPreview() {
    SteamDexTheme {
        Surface {
            DependenciesTopAppBar(
                userGradientBackground = false,
                onBackClick = {},
                onCloseClick = {}
            )
        }
    }
}
