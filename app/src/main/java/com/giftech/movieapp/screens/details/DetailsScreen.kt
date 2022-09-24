package com.giftech.movieapp.screens.details

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailsScreen(
    navController: NavController
) {
    Scaffold {
        MainContent()
    }
}

@Composable
fun MainContent() {
    Text("Detail")
}