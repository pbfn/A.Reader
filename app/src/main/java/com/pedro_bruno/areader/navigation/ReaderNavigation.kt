package com.pedro_bruno.areader.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pedro_bruno.areader.screens.ReaderSplashScreen
import com.pedro_bruno.areader.screens.details.BookDetailsScreen
import com.pedro_bruno.areader.screens.home.Home
import com.pedro_bruno.areader.screens.login.LoginScreen
import com.pedro_bruno.areader.screens.search.BookSearchViewModel
import com.pedro_bruno.areader.screens.search.SearchScreen
import com.pedro_bruno.areader.screens.stats.ReaderStatsScreen
import com.pedro_bruno.areader.screens.update.BookUpdateScreen

@Composable
fun ReaderNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ReaderScreens.SplashScreen.name
    ) {

        composable(ReaderScreens.SplashScreen.name) {
            ReaderSplashScreen(navController = navController)
        }

        composable(ReaderScreens.ReaderHomeScreen.name) {
            Home(navController = navController)
        }

        composable(ReaderScreens.DetailScreen.name) {
            BookDetailsScreen(navController = navController)
        }

        composable(ReaderScreens.LoginScreen.name) {
            LoginScreen(navController = navController)
        }

        composable(ReaderScreens.SearchScreen.name) {
            val viewModel = hiltViewModel<BookSearchViewModel>()
            SearchScreen(navController = navController, viewModel = viewModel)
        }

        composable(ReaderScreens.ReaderStatsScreen.name) {
            ReaderStatsScreen(navController = navController)
        }

        composable(ReaderScreens.UpdateScreen.name) {
            BookUpdateScreen(navController = navController)
        }

    }
}