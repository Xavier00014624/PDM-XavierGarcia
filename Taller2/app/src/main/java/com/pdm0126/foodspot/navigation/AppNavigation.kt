package com.pdm0126.foodspot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.pdm0126.foodspot.screens.home.HomeScreen
import com.pdm0126.foodspot.screens.detail.DetailScreen
import com.pdm0126.foodspot.screens.search.SearchScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(
                onRestaurantClick = { restaurantId ->
                    navController.navigate("detail/$restaurantId")
                },
                onSearchClick = {
                    navController.navigate("search")
                }
            )
        }

        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()

            id?.let {
                DetailScreen(
                    restaurantId = it,
                    onBack = { navController.popBackStack() }
                )
            }
        }

        composable("search") {
            SearchScreen(
                onBack = { navController.popBackStack() },
                onRestaurantClick = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }
    }
}