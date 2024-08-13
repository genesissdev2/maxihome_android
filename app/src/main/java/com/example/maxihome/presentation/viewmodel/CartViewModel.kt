package com.example.maxihome.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.maxihome.domain.model.Product

class CartViewModel : ViewModel() {
    private val _cartItems = MutableStateFlow<List<Product>>(emptyList())
    val cartItems: StateFlow<List<Product>> get() = _cartItems

    fun addToCart(product: Product) {
        _cartItems.value += product
    }

    fun removeFromCart(product: Product) {
        _cartItems.value -= product
    }
}
