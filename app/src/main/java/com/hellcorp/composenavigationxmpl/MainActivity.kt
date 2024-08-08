package com.hellcorp.composenavigationxmpl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.google.gson.Gson
import com.hellcorp.composenavigationxmpl.domain.models.Movie
import com.hellcorp.composenavigationxmpl.feature.mainscreen.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val gson = Gson()
        val movies = listOf(
            Movie("1", "Первый фильм"),
            Movie("2", "Второй фильм"),
            Movie("3", "Третий фильм"),
        )

        setContent {
            MainScreen(gson = gson, movies = movies)
        }
    }
}
