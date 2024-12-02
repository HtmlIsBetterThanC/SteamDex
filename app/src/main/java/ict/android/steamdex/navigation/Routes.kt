package ict.android.steamdex.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Serializable
object LoginRoute

@Serializable
object HomeRoute

@Serializable
object LibraryRoute

@Serializable
data class GameRoute(val id: Int)

@Serializable
data class PublisherRoute(val id: Int)

@Serializable
object ProfileRoute

@Serializable
object CalculatorRoute

@Serializable
object AboutGraphRoute

// TODO use in BottomNavbar
@Immutable
data class BottomNavbarScreen<T : Any>(
    val route: T,
    @StringRes val nameId: Int,
    @DrawableRes val iconId: Int,
    @StringRes val iconDescriptionId: Int
)
