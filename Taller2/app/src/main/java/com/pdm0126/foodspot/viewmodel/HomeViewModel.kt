package com.pdm0126.foodspot.viewmodel
import androidx.lifecycle.ViewModel
import com.pdm0126.foodspot.data.RestaurantRepository
import com.pdm0126.foodspot.data.RestaurantRepositoryImpl
import com.pdm0126.foodspot.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
class HomeViewModel : ViewModel() {
    private val repository: RestaurantRepository = RestaurantRepositoryImpl()


    private val _restaurantsByCategory =
        MutableStateFlow<Map<String, List<Restaurant>>>(emptyMap())


    val restaurantsByCategory: StateFlow<Map<String, List<Restaurant>>> =
        _restaurantsByCategory.asStateFlow()

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        val restaurants = repository.getRestaurants()

        val grouped = restaurants
            .flatMap { restaurant ->
                restaurant.categories.map { category ->
                    category to restaurant
                }
            }
            .groupBy(
                { it.first },
                { it.second }
            )

        _restaurantsByCategory.value = grouped
    }
}