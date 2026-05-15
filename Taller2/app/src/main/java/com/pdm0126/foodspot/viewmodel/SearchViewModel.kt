package com.pdm0126.foodspot.viewmodel

import androidx.lifecycle.ViewModel
import com.pdm0126.foodspot.data.RestaurantRepository
import com.pdm0126.foodspot.data.RestaurantRepositoryImpl
import com.pdm0126.foodspot.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {

    private val repository: RestaurantRepository = RestaurantRepositoryImpl()

    private val allRestaurants = repository.getRestaurants()

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    private val _results = MutableStateFlow<List<Restaurant>>(emptyList())
    val results: StateFlow<List<Restaurant>> = _results.asStateFlow()

    fun onQueryChange(newQuery: String) {
        _query.value = newQuery
        search()
    }

    private fun search() {
        val q = _query.value.lowercase()

        if (q.isBlank()) {
            _results.value = emptyList()
            return
        }

        val filtered = allRestaurants.filter { restaurant ->
            restaurant.name.lowercase().contains(q) ||
                    restaurant.menu.any { dish ->
                        dish.name.lowercase().contains(q)
                    }
        }

        _results.value = filtered
    }
}