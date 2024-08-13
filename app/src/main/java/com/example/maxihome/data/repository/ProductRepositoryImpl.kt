package com.example.maxihome.data.repository

import com.example.maxihome.domain.model.Product
import com.example.maxihome.domain.repository.ProductRepository

class ProductRepositoryImpl : ProductRepository {
    override fun getProducts(): List<Product> {
        return listOf(
            Product(1, "Product 1", "Description 1", 29.99, "url1"),
            Product(2, "Product 2", "Description 2", 39.99, "url2"),
            // Agrega más productos aquí
        )
    }

    override fun getProductById(id: Int): Product? {
        return getProducts().find { it.id == id }
    }
}