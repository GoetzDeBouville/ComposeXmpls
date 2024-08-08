package com.hellcorp.composenavigationxmpl.feature.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hellcorp.composenavigationxmpl.domain.models.Movie

@Composable
fun DetailsScreen(movie: Movie,
                  navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = movie.id)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = movie.title,
            modifier = Modifier.clickable {
                navHostController.navigate("my_screen")
            })
    }
}