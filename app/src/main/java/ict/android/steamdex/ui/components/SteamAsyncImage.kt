package ict.android.steamdex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import ict.android.steamdex.R
import ict.android.steamdex.ui.preview.PreviewSteam
import ict.android.steamdex.ui.theme.SteamDexTheme

@Composable
fun SteamAsyncImage(
    model: Any,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    val painter = rememberAsyncImagePainter(model)
    val value = painter.state.collectAsStateWithLifecycle().value
    when (value) {
        is AsyncImagePainter.State.Loading -> {
            CircularProgressIndicator(Modifier.padding(8.dp))
        }

        is AsyncImagePainter.State.Success -> {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = modifier,
                contentScale = contentScale
            )
        }

        is AsyncImagePainter.State.Error -> {
            Icon(
                painter = painterResource(R.drawable.broken_image),
                contentDescription = null,
                modifier = modifier.fillMaxSize()
            )
        }

        is AsyncImagePainter.State.Empty -> {
            Icon(
                painter = painterResource(R.drawable.insert_image),
                contentDescription = null,
                modifier = modifier.fillMaxSize()
            )
        }
    }
}

@PreviewSteam
@Composable
private fun TokAsyncImagePreview() {
    SteamDexTheme {
        Surface(Modifier.safeContentPadding()) {
            SteamAsyncImage("", Modifier.size(150.dp))
        }
    }
}
