package com.example.maxihome.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.maxihome.domain.model.Product
import com.example.maxihome.presentation.viewmodel.CartViewModel

@Composable
fun CartScreen(viewModel: CartViewModel, navController: NavController) {
    val cartItems = viewModel.cartItems.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Volver")
        }

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(cartItems.value.size) { index ->
                val product = cartItems.value[index]
                CartItem(product = product)
            }
        }

        Divider()

        Text(
            text = "Total: $${cartItems.value.sumOf { it.price }}",
            modifier = Modifier.padding(16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = { /* Proceed to checkout */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Proceed to Checkout")
        }
    }
}

@Composable
fun CartItem(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = product.name, fontWeight = FontWeight.Bold)
            Text(text = "$${product.price}")
        }
        Button(onClick = { /* Remove item */ }) {
            Text(text = "Remove")
        }
    }
}
