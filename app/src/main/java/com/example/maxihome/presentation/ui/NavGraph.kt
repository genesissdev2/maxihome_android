package com.example.maxihome.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.maxihome.presentation.viewmodel.ProductViewModel
import com.example.maxihome.presentation.viewmodel.CartViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    productViewModel: ProductViewModel,
    cartViewModel: CartViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController = navController)
        }
        composable("home") {
            HomeScreen(viewModel = productViewModel, cartViewModel = cartViewModel, navController = navController)
        }
        composable("cart") {
            CartScreen(viewModel = cartViewModel, navController = navController)
        }
    }
}
