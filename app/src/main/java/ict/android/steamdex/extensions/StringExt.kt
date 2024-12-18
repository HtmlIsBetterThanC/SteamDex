package ict.android.steamdex.extensions

fun String.toNullableBoolean(): Boolean? {
    if (this == "null") return null
    return this.toBoolean()
}
