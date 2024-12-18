package ict.android.steamdex.ext

//import android.content.Context
//import android.net.Uri
//import androidx.browser.customtabs.CustomTabsIntent
//
//fun Context.openCustomBrowserTab(
//    url: String
//) {
//    val builder = CustomTabsIntent.Builder()
//
//    builder.setShowTitle(true)
//
//    builder.setInstantAppsEnabled(true)
//
//    val customBuilder = builder.build()
//
//    customBuilder.launchUrl(this, Uri.parse(url))
//}


import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

fun Context.openCustomBrowserTab(
    url: String,
    onJsonIntercepted: ((String) -> Unit)? = null
) {
    val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    val encryptedSharedPreferences = EncryptedSharedPreferences.create(
        "secure_json_storage",
        masterKeyAlias,
        this,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    onJsonIntercepted?.let {
        encryptedSharedPreferences.edit()
            .putString("JSON_CALLBACK_FUNCTION", "true")
            .apply()
    }

    val builder = CustomTabsIntent.Builder()
    builder.setShowTitle(true)
    builder.setInstantAppsEnabled(true)

    val customBuilder = builder.build()
    customBuilder.launchUrl(this, Uri.parse(url))
}

fun Context.saveInterceptedJson(jsonString: String) {
    val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    val encryptedSharedPreferences = EncryptedSharedPreferences.create(
        "secure_json_storage",
        masterKeyAlias,
        this,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    encryptedSharedPreferences.edit()
        .putString("INTERCEPTED_JSON", jsonString)
        .apply()
}

fun Context.getInterceptedJson(): String? {
    val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    val encryptedSharedPreferences = EncryptedSharedPreferences.create(
        "secure_json_storage",
        masterKeyAlias,
        this,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    return encryptedSharedPreferences.getString("INTERCEPTED_JSON", null)
}


fun Context.getDecryptedJson(): String? {
    val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    val encryptedSharedPreferences = EncryptedSharedPreferences.create(
        "secure_json_storage",
        masterKeyAlias,
        this,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    return encryptedSharedPreferences.getString("INTERCEPTED_JSON", null)
}