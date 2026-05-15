package com.pdm0126.foodspot.screens.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.pdm0126.foodspot.viewmodel.SearchViewModel
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onBack: () -> Unit,
    onRestaurantClick: (Int) -> Unit
) {

    val viewModel: SearchViewModel = viewModel()

    val query by viewModel.query.collectAsState()
    val results by viewModel.results.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Buscar") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Text("<")
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(8.dp)
        ) {

            OutlinedTextField(
                value = query,
                onValueChange = { viewModel.onQueryChange(it) },
                label = { Text("Buscar...") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (results.isEmpty() && query.isNotBlank()) {
                Text("No se encontraron resultados")
            }

            LazyColumn {
                items(results) { restaurant ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onRestaurantClick(restaurant.id)
                            }
                            .padding(8.dp)
                    ) {

                        AsyncImage(
                            model = restaurant.imageUrl,
                            contentDescription = restaurant.name,
                            modifier = Modifier.size(80.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(restaurant.name)
                    }
                }
            }
        }
    }
}