package com.hellcorp.composenavigationxmpl.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.gson.Gson
import com.hellcorp.composenavigationxmpl.domain.models.Movie

@Composable
fun BottomNavigationBar(navController: NavHostController, gson: Gson, movies: List<Movie>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomAppBar(
        containerColor = Color.Green
    ) {
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.List, contentDescription = "") },
            label = { Text("Movies") },
            selected = currentDestination?.route == Routes.Movies.name,
            onClick = { navController.navigate(Routes.Movies.name) }
        )
        val movieJson = gson.toJson(movies[2])
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Info, contentDescription = "") },
            label = { Text("Details") },
            selected = currentDestination?.route == "${Routes.Details.name}/$movieJson",
            onClick = { navController.navigate("${Routes.Details.name}/$movieJson") }
        )
    }
}