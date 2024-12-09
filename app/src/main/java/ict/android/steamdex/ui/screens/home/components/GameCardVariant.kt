package ict.android.steamdex.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ict.android.steamdex.R
import ict.android.steamdex.ui.screens.home.GamesCarousel
import ict.android.steamdex.ui.theme.primaryContainerDark
import ict.android.steamdex.ui.theme.primaryContainerLight

@Composable
fun GameCardVariant(
    games: GamesCarousel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(300.dp)
            .height(200.dp),
        shape = RoundedCornerShape(28.dp),
        elevation = CardDefaults
            .cardElevation(defaultElevation = 2.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Icon(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource
                (R.drawable.broken_image),
                contentDescription = stringResource
                (R.string.card_icon_image_carousel),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
            // Local gradient for icon shade
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.5f)
                            ),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp),
                horizontalAlignment = Alignment.Start,

            ) {
                Text(
                    text = when (games.rank) {
                        1 -> stringResource(R.string.column_text_carousel_first)
                        2 -> stringResource(R.string.column_text_carousel_second)
                        3 -> stringResource(R.string.column_text_carousel_third)
                        else -> stringResource(
                            R.string
                                .column_text_carousel_other_cases,
                            games.rank
                        )
                    },
                    style = MaterialTheme.typography.titleMedium,
                    color = if (isSystemInDarkTheme()) {
                        primaryContainerDark
                    } else {
                        primaryContainerLight
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Transparent)
                        .padding(4.dp)
                        .align(Alignment.Start)
                        .padding(start = 8.dp, top = 8.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(bottom = 18.dp)
                ) {
                    Text(
                        text = games.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = stringResource(
                            R.string
                                .text_variant_player_count,
                            games.playerCount
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        color = if (isSystemInDarkTheme()) {
                            primaryContainerDark
                        } else {
                            primaryContainerLight
                        }
                    )
                }
            }
        }
    }
}
