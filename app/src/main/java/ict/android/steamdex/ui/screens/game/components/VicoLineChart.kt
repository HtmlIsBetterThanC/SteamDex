package ict.android.steamdex.ui.screens.game.components

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberBottom
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStart
import com.patrykandpatrick.vico.compose.cartesian.cartesianLayerPadding
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLine
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.compose.cartesian.rememberVicoZoomState
import com.patrykandpatrick.vico.compose.common.fill
import com.patrykandpatrick.vico.core.cartesian.axis.HorizontalAxis
import com.patrykandpatrick.vico.core.cartesian.axis.VerticalAxis
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.lineSeries
import com.patrykandpatrick.vico.core.cartesian.layer.LineCartesianLayer
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.screens.game.rememberMarker
import ict.android.steamdex.ui.theme.SteamDexTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random

/*
* Vico charts library URL:
* https://github.com/patrykandpatrick/vico/tree/master
*/

/*TESTING PART START  TODO remove this */

fun generateRandomFloats(
    count: Int,
    minValue: Float = 0f,
    maxValue: Float = 1f
): List<Float> {
    return List(count) {
        Random.nextFloat() * (maxValue - minValue) + minValue
    }
}

fun generateRandomInt(
    count: Int,
    minValue: Int = 0,
    maxValue: Int = 1
): List<Int> {
    return List(count) {
        Random.nextInt(
            from = minValue,
            until = maxValue
        )
    }
}

private val year = (1..365).toList()
private val priceHistory = generateRandomFloats(365, 9.99f, 69.99f)
private val playersHistory = generateRandomInt(365, 20000, 1_100_000)

fun main() {
    println(playersHistory)
}

/* TESTING PART END */

@Composable
internal fun LineChart(
    // horizontals and verticals collections should have the same amount of data
    horizontalAxisData: List<Number>,
    verticalAxisData: List<Number>,
    modifier: Modifier = Modifier
) {
    val modelProducer = remember { CartesianChartModelProducer() }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            modelProducer.runTransaction {
                lineSeries { series(horizontalAxisData, verticalAxisData) }
            }
        }
    }
    VicoLineChart(
        modelProducer = modelProducer,
        modifier = modifier
    )
}

// position of the persist marker in the chart, yes it is a float because fuck it
private const val PERSISTENT_MARKER_X = 6f

@Composable
private fun VicoLineChart(
    modelProducer: CartesianChartModelProducer,
    modifier: Modifier = Modifier
) {
    val marker = rememberMarker()

    CartesianChartHost(
        chart =
        rememberCartesianChart(
            rememberLineCartesianLayer(
                LineCartesianLayer.LineProvider.series(
                    LineCartesianLayer.rememberLine(
                        // cannot use MaterialTheme.colorScheme cuz it's not composable
                        remember { LineCartesianLayer.LineFill.single(fill(Color(0xFF0096F4))) }
                    )
                )
            ),
            startAxis = VerticalAxis.rememberStart(
                itemPlacer = remember { VerticalAxis.ItemPlacer.count() }
            ),
            bottomAxis = HorizontalAxis.rememberBottom(
                guideline = null,
                itemPlacer = remember { HorizontalAxis.ItemPlacer.segmented() },
            ),
            marker = marker,
            layerPadding = cartesianLayerPadding(),
            // don't think the persistent marker is useful
            // persistentMarkers = rememberExtraLambda(marker) { marker at PERSISTENT_MARKER_X }

        ),
        modelProducer = modelProducer,
        modifier = modifier,
        zoomState = rememberVicoZoomState(zoomEnabled = true)
    )
}

// preview sometimes works other doesn't idk why
@PreviewSteam
@Composable
private fun VicoLineChartPreview() {
    SteamDexTheme {
        Surface {
            LineChart(
                horizontalAxisData = year,
                verticalAxisData = priceHistory
            )
        }
    }
}
