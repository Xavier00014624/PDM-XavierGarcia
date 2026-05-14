package com.pdm0126.foodspot.data
import com.pdm0126.foodspot.model.Restaurant

interface RestaurantRepository {
    fun getRestaurants(): List<Restaurant>
}