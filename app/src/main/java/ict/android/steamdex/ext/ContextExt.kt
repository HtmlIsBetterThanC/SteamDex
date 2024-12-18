package ict.android.steamdex.ext

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

fun Context.openCustomBrowserTab(
    url: String
) {
    val builder = CustomTabsIntent.Builder()

    builder.setShowTitle(true)

    builder.setInstantAppsEnabled(true)

    val customBuilder = builder.build()

    customBuilder.launchUrl(this, Uri.parse(url))
}
