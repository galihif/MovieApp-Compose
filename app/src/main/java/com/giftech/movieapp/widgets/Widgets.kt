package com.giftech.movieapp.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.giftech.movieapp.model.Movie
import com.giftech.movieapp.model.getMovies


@Preview
@Composable
fun MovieRow(
    movie: Movie = getMovies()[0],
    onItemClick: (String) -> Unit = {}
) {

    Card(
        Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable {
                onItemClick(movie.id)
            },
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.images[0])
                        .crossfade(true)
                        .transformations(CircleCropTransformation())
                        .build(),
                    contentDescription = "",
                )
//                Icon(
//                    imageVector = Icons.Default.AccountBox,
//                    contentDescription = "Movie Image"
//                )
            }
            Column(
                Modifier.padding(4.dp)
            ) {
                Text(
                    movie.title,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    "Director ${movie.director}",
                    style = MaterialTheme.typography.caption
                )
                Text(
                    "Released: ${movie.year}",
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}