package com.giftech.movieapp.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(
    navController: NavController,
    movie: String?
) {
    Surface(
        Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "$movie",
                style = MaterialTheme.typography.h5
            )
            Spacer(Modifier.height(24.dp))
            Button(onClick ={
                navController.popBackStack()
            }) {
                Text("Go Back")
            }
        }
    }
}
