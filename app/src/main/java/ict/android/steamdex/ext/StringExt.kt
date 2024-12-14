package ict.android.steamdex.ext

fun String.toNullableBoolean(): Boolean? {
    if (this == "null") return null
    return this.toBoolean()
}
