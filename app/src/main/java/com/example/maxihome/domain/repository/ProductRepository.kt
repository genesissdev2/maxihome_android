package com.example.maxihome.domain.repository

import com.example.maxihome.domain.model.Product

interface ProductRepository {
    fun getProducts(): List<Product>
    fun getProductById(id: Int): Product?
}