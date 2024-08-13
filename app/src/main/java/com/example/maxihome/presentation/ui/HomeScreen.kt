package com.example.maxihome.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.maxihome.domain.model.Product
import com.example.maxihome.presentation.viewmodel.CartViewModel
import com.example.maxihome.presentation.viewmodel.ProductViewModel

@Composable
fun HomeScreen(viewModel: ProductViewModel, cartViewModel: CartViewModel, navController: NavController) {
    Column {
        Image(
            painter = painterResource(id = android.R.drawable.ic_dialog_alert),
            contentDescription = "Banner",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Button(
            onClick = {
                navController.navigate("cart")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Go to Cart")
        }

        LazyColumn {
            items(viewModel.products.size) { index ->
                val product = viewModel.products[index]
                ProductCard(product = product, cartViewModel = cartViewModel)
            }
        }
    }
}


@Composable
fun ProductCard(product: Product, cartViewModel: CartViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = product.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = product.description)
            Text(text = "$${product.price}", color = MaterialTheme.colorScheme.primary)
            Button(onClick = { cartViewModel.addToCart(product) }) {
                Text(text = "Add to Cart")
            }
        }
    }
}

