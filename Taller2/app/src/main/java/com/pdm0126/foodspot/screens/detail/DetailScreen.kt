package com.pdm0126.foodspot.screens.detail

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdm0126.foodspot.viewmodel.DetailViewModel
import com.pdm0126.foodspot.viewmodel.CartViewModel
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    restaurantId: Int,
    onBack: () -> Unit,
    cartViewModel: CartViewModel
) {

    val viewModel: DetailViewModel = viewModel()
    val restaurant by viewModel.restaurant.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.loadRestaurant(restaurantId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(restaurant?.name ?: "Detalle") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Text("<")
                    }
                }
            )
        }
    ) { padding ->

        restaurant?.let { rest ->

            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(8.dp)
            ) {

                item {
                    Text(
                        text = rest.description,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                items(rest.menu) { dish ->

                    Column(
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {

                        AsyncImage(
                            model = dish.imageUrl,
                            contentDescription = dish.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                        )

                        Text(text = dish.name)
                        Text(text = dish.description)

                        Button(
                            onClick = {
                                cartViewModel.addToCart(dish)

                                Toast.makeText(
                                    context,
                                    "${dish.name} agregado al carrito",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        ) {
                            Text("Agregar al carrito")
                        }
                    }
                }
            }
        }
    }
}