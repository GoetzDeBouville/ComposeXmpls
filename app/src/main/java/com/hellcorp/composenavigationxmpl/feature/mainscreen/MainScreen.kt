package com.hellcorp.composenavigationxmpl.feature.mainscreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.hellcorp.composenavigationxmpl.domain.models.Movie
import com.hellcorp.composenavigationxmpl.navigation.BottomNavigationBar
import com.hellcorp.composenavigationxmpl.navigation.NavGraph

@Composable
fun MainScreen(gson: Gson, movies: List<Movie>) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()


    val showBottomBar = navBackStackEntry?.destination?.route != "details/{movie}"

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(navController, gson, movies)
            }
        }
    ) { innerPadding ->
        NavGraph(
            navHostController = navController,
            gson = gson,
            movies = movies,
            modifier = Modifier.padding(innerPadding)
        )
    }
}