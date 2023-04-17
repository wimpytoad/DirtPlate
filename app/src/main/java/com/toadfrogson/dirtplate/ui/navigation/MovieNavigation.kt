package com.toadfrogson.dirtplate.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.toadfrogson.dirtplate.presentation.viewmodel.MovieListViewModel
import com.toadfrogson.dirtplate.ui.screen.MovieDetailsScreen
import com.toadfrogson.dirtplate.ui.screen.MovieListScreen
import com.toadfrogson.dirtplate.ui.screen.movieDetailsRoute
import com.toadfrogson.dirtplate.ui.screen.movieScreenRoute

@Composable
fun MovieNavigation(navController: NavHostController) {
    val viewModel: MovieListViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = movieScreenRoute) {
        composable(movieScreenRoute) {
            MovieListScreen(navController = navController, viewModel = viewModel)
        }

        composable(movieDetailsRoute)
        {
            MovieDetailsScreen(navController = navController, viewModel = viewModel)
        }
    }
}