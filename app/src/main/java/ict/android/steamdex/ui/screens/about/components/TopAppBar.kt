package ict.android.steamdex.ui.screens.about.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ict.android.steamdex.R
import ict.android.steamdex.ui.components.buttons.icons.BackArrowButton
import ict.android.steamdex.ui.components.buttons.icons.CloseButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    onBackClick: () -> Unit,
    onCloseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.dependencies_dependencies_title),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.displaySmall
            )
        },
        modifier = modifier.fillMaxWidth(),
        navigationIcon = {
            BackArrowButton(onBackClick)
        },
        actions = {
            CloseButton(onCloseClick)
        }
    )
}
