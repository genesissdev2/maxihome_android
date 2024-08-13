package com.example.maxihome.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.maxihome.domain.usecase.GetProductsUseCase

class ProductViewModel(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
    val products = getProductsUseCase.execute()
}
