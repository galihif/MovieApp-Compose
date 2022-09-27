package com.giftech.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.giftech.movieapp.model.Movie
import com.giftech.movieapp.model.getMovies
import com.giftech.movieapp.widgets.MovieRow

@Composable
fun DetailsScreen(
    navController: NavController,
    movieId: String?
) {
    val newMovieList = getMovies().filter { it.id == movieId }
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                elevation = 4.dp
            ) {
                Row(horizontalArrangement = Arrangement.Start) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        })
                    Spacer(modifier = Modifier.width(100.dp))
                    Text("Movies")
                }
            }
        }
    ) {
        Surface(
            Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                MovieRow(
                    movie = newMovieList.first()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text("Movie Images")
                HorizontalScrollableImageView(newMovieList)
            }
        }
    }


}

@Composable
private fun HorizontalScrollableImageView(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList.first().images) { image ->
            Card(
                Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 4.dp
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = "",
                )
            }
        }
    }
}
