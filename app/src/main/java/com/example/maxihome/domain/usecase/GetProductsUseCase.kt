package com.example.maxihome.domain.usecase

import com.example.maxihome.domain.model.Product
import com.example.maxihome.domain.repository.ProductRepository

class GetProductsUseCase(private val repository: ProductRepository) {
    fun execute(): List<Product> {
        return repository.getProducts()
    }
}
