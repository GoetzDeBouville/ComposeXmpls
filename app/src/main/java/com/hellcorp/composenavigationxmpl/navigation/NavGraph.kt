package com.hellcorp.composenavigationxmpl.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.hellcorp.composenavigationxmpl.domain.models.Movie
import com.hellcorp.composenavigationxmpl.feature.details.DetailsScreen
import com.hellcorp.composenavigationxmpl.feature.moviescreen.MoviesScreen
import com.hellcorp.composenavigationxmpl.feature.myscreen.MyScreen

@Composable
fun NavGraph(
    startDestination: String = Routes.Movies.name,
    navHostController: NavHostController,
    gson: Gson,
    movies: List<Movie>,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(
            route = "movies"
        ) {
            MoviesScreen(navHostController, gson, movies)
        }
        composable(
            route = "details/{movie}",
            arguments = listOf(navArgument("movie") { type = NavType.StringType })
        ) { navBackStackEntry ->
            val movieJson = navBackStackEntry.arguments?.getString("movie")
            val movie = gson.fromJson(movieJson, Movie::class.java)
            DetailsScreen(movie, navHostController)
        }
        composable(
            route = "my_screen"
        ) {
            MyScreen(paddingValues = PaddingValues())
        }
    }
}