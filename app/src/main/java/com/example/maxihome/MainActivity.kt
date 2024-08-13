package com.example.maxihome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.maxihome.data.repository.ProductRepositoryImpl
import com.example.maxihome.domain.usecase.GetProductsUseCase
import com.example.maxihome.presentation.ui.NavGraph
import com.example.maxihome.ui.theme.MaxihomeTheme
import com.example.maxihome.presentation.viewmodel.ProductViewModel
import com.example.maxihome.presentation.viewmodel.CartViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val productRepository = ProductRepositoryImpl()
        val getProductsUseCase = GetProductsUseCase(productRepository)
        val productViewModel = ProductViewModel(getProductsUseCase)
        val cartViewModel = CartViewModel()

        setContent {
            MaxihomeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController, productViewModel, cartViewModel)
                }
            }
        }
    }
}
