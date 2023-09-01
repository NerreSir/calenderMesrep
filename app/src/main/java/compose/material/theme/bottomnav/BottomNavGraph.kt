package compose.material.theme.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import compose.material.theme.screens.CalendarScreen
import compose.material.theme.screens.HomeScreen
import compose.material.theme.screens.ProfileScreen
import compose.material.theme.screens.FlowScreen
import compose.material.theme.screens.TransactionsScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Calendar.route) {
            CalendarScreen()
        }
        composable(route = BottomBarScreen.Transactions.route) {
            TransactionsScreen()
        }
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Flow.route) {
            FlowScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
    }
}