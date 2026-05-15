package com.pdm0126.foodspot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdm0126.foodspot.screens.home.HomeScreen
import com.pdm0126.foodspot.screens.detail.DetailScreen
import com.pdm0126.foodspot.screens.search.SearchScreen
import com.pdm0126.foodspot.viewmodel.CartViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val cartViewModel: CartViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(
                cartViewModel = cartViewModel,
                onRestaurantClick = { id ->
                    navController.navigate("detail/$id")
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
                    onBack = { navController.popBackStack() },
                    cartViewModel = cartViewModel
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