package ict.android.steamdex.ui.screens.login.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ict.android.steamdex.R

@Composable
fun LogoIcon(
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "",
        modifier = modifier
    )
}