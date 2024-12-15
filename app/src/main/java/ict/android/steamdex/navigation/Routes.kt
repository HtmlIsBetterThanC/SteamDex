package ict.android.steamdex.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import ict.android.steamdex.R
import kotlinx.serialization.Serializable

@Serializable
object LoginRoute

@Serializable
object ExploreRoute

@Serializable
object LibraryRoute

@Serializable
data class GameRoute(val id: Long)

@Serializable
data class PublisherRoute(val id: Long)

@Serializable
object ProfileRoute

@Serializable
object CalculatorRoute

@Serializable
object AboutGraphRoute

@Immutable
data class BottomNavbarScreen<T : Any>(
    val route: T,
    @StringRes val nameId: Int,
    @DrawableRes val iconId: Int,
    @StringRes val iconDescriptionId: Int
)

@Stable
val BottomNavbarScreens = listOf(
    BottomNavbarScreen(
        route = ExploreRoute,
        nameId = R.string.explore_navbar_name,
        iconId = R.drawable.explore,
        iconDescriptionId = R.string.explore_icon_description
    ),
    BottomNavbarScreen(
        route = LibraryRoute,
        nameId = R.string.library_navbar_name,
        iconId = R.drawable.library,
        iconDescriptionId = R.string.library_navbar_name
    ),
    BottomNavbarScreen(
        route = ProfileRoute,
        nameId = R.string.profile_navbar_name,
        iconId = R.drawable.profile,
        iconDescriptionId = R.string.profile_icon_description
    )
)
