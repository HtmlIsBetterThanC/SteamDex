package ict.android.steamdex.ui.screens.home.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.preview.PreviewSteamFontSize
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun CategoryGamesBar(
    @DrawableRes categoryIconId: Int,
    @StringRes categoryIconDescriptionId: Int,
    @StringRes categoryTitleId: Int,
    editMode: Boolean,
    isExpanded: Boolean,
    onCategoryBarClick: () -> Unit,
    onIsExpandedClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val textAndIconTint = MaterialTheme.colorScheme.onSecondaryContainer
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .clickable(enabled = !editMode, onClick = onCategoryBarClick)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(categoryIconId),
                    contentDescription = stringResource(categoryIconDescriptionId),
                    tint = textAndIconTint
                )
            }
            Text(
                text = stringResource(categoryTitleId),
                color = textAndIconTint,
                style = MaterialTheme.typography.titleLarge
            )
        }
        Box(
            Modifier.size(48.dp),
            contentAlignment = Alignment.Center
        ) {
            if (editMode) {
                IconToggleButton(isExpanded, onIsExpandedClick) {
                    if (isExpanded) {
                        Icon(
                            painter = painterResource(R.drawable.collapse),
                            contentDescription = stringResource(R.string.collapse_icon_description),
                            tint = textAndIconTint
                        )
                    } else {
                        Icon(
                            painter = painterResource(R.drawable.expand),
                            contentDescription = stringResource(R.string.expand_icon_description),
                            tint = textAndIconTint
                        )
                    }
                }
            } else {
                Icon(
                    painter = painterResource(R.drawable.trailing_icon),
                    contentDescription = stringResource(R.string.trailing_icon_description),
                    tint = textAndIconTint
                )
            }
        }
    }
}

@PreviewSteam
@PreviewSteamFontSize
@Composable
private fun CategoryGameBarPreview() {
    SteamDexTheme {
        Surface {
            CategoryGamesBar(
                categoryIconId = R.drawable.trending_up,
                categoryIconDescriptionId = R.string.trending_up_icon_description,
                categoryTitleId = R.string.home_trending_category,
                editMode = false,
                isExpanded = false,
                onCategoryBarClick = {},
                onIsExpandedClick = {}
            )
        }
    }
}

@PreviewSteam
@Composable
private fun CategoryGameBarEditModePreview() {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    SteamDexTheme {
        Surface {
            CategoryGamesBar(
                categoryIconId = R.drawable.trending_up,
                categoryIconDescriptionId = R.string.trending_up_icon_description,
                categoryTitleId = R.string.home_trending_category,
                editMode = true,
                isExpanded = isExpanded,
                onCategoryBarClick = {},
                onIsExpandedClick = {
                    isExpanded = it
                }
            )
        }
    }
}
