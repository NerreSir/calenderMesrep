package compose.material.theme.bottomnav

import compose.material.theme.R


sealed class BottomBarScreen(
    val route: String, val title: String, val icon: Int, val icon_focused: Int
) {

    object Calendar : BottomBarScreen(
        route = "calendar",
        title = "Takvim",
        icon = android.R.drawable.ic_menu_today,
        icon_focused = android.R.drawable.ic_menu_today
    )

    object Flow : BottomBarScreen(
        route = "flow",
        title = "Akış",
        icon = android.R.drawable.ic_menu_view,
        icon_focused = android.R.drawable.ic_menu_view
    )

    object Home : BottomBarScreen(
        route = "home",
        title = "Ana Sayfa",
        icon = R.drawable.ic_bottom_home,
        icon_focused = R.drawable.ic_bottom_home_focused
    )

    object Transactions : BottomBarScreen(
        route = "transactions",
        title = "İşlemler",
        icon = android.R.drawable.ic_menu_add,
        icon_focused = android.R.drawable.ic_input_add
    )

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profil",
        icon = R.drawable.ic_bottom_profile,
        icon_focused = R.drawable.ic_bottom_profile_focused
    )


}
