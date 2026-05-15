package com.pdm0126.foodspot.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pdm0126.foodspot.model.Restaurant
import com.pdm0126.foodspot.viewmodel.HomeViewModel
import androidx.compose.material3.ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = HomeViewModel(),
    onRestaurantClick: (Int) -> Unit,
    onSearchClick: () -> Unit
) {

    val categories by viewModel.restaurantsByCategory.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FoodSpot") },
                actions = {
                    IconButton(onClick = onSearchClick) {
                        Text("🔍")
                    }
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(8.dp)
        ) {

            categories.forEach { (category, restaurants) ->

                item {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                item {
                    LazyRow {
                        items(restaurants) { restaurant ->
                            RestaurantItem(restaurant, onRestaurantClick)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RestaurantItem(
    restaurant: Restaurant,
    onClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .width(150.dp)
            .clickable { onClick(restaurant.id) }
    ) {

        AsyncImage(
            model = restaurant.imageUrl,
            contentDescription = restaurant.name,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )

        Text(
            text = restaurant.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}