package com.hellcorp.composenavigationxmpl.feature.moviescreen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.gson.Gson
import com.hellcorp.composenavigationxmpl.domain.models.Movie

@Composable
fun MoviesScreen(
    navController: NavController,
    gson: Gson,
    movies: List<Movie>
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        for (movie in movies) {
            Text(
                text = movie.title,
                modifier = Modifier
                    .clickable {
                        val movieJson = gson.toJson(movie)
                        Toast.makeText(context, "Context — всему голова!", Toast.LENGTH_LONG).show()
                        navController.navigate("details/$movieJson")
                    }
            )
        }
    }
}