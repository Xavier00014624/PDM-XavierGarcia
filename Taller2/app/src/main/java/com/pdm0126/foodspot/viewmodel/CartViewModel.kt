package com.pdm0126.foodspot.viewmodel

import androidx.lifecycle.ViewModel
import com.pdm0126.foodspot.model.Dish
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartViewModel : ViewModel() {

    private val _cartItems = MutableStateFlow<List<Dish>>(emptyList())
    val cartItems: StateFlow<List<Dish>> = _cartItems.asStateFlow()

    fun addToCart(dish: Dish) {
        _cartItems.value = _cartItems.value + dish
    }
}