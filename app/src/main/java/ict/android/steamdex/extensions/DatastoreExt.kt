package ict.android.steamdex.extensions

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

fun <T> DataStore<Preferences>.observeValue(key: Preferences.Key<T>) = data.map { it[key] }

suspend fun <T> DataStore<Preferences>.getValue(
    key: Preferences.Key<T>,
    default: T,
) = observeValue(key).first() ?: default

suspend fun <T> DataStore<Preferences>.setValue(
    key: Preferences.Key<T>,
    value: T
) = edit {
    it[key] = value
}
