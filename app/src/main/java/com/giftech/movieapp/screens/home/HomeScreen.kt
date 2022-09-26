package com.giftech.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.giftech.movieapp.model.Movie
import com.giftech.movieapp.model.getMovies
import com.giftech.movieapp.navigation.MovieScreens
import com.giftech.movieapp.widgets.MovieRow

@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                elevation = 4.dp
            ) {
                Text("Movies")
            }
        }
    ) {
        MainContent(navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(
        Modifier.padding(12.dp)
    ) {
        LazyColumn {
            items(items = movieList) { movie ->
                MovieRow(movie = movie) {
                    navController.navigate(MovieScreens.DetailsScreen.name + "/$it")
                }
            }
        }
    }
}

