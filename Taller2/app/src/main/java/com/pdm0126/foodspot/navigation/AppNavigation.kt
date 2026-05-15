package com.pdm0126.foodspot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.pdm0126.foodspot.screens.home.HomeScreen

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

            // TEMPORAL (luego creamos pantalla real)
            androidx.compose.material3.Text("Detalle restaurante ID: $id")
        }

        composable("search") {
            // TEMPORAL
            androidx.compose.material3.Text("Pantalla de búsqueda")
        }
    }
}