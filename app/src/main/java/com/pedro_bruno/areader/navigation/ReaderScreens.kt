package com.pedro_bruno.areader.navigation

import java.lang.IllegalArgumentException

enum class ReaderScreens {
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    ReaderHomeScreen,
    SearchScreen,
    DetailScreen,
    UpdateScreen,
    ReaderStatsScreen;

    companion object {
        fun fromRoute(route: String): ReaderScreens = when (route.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            CreateAccountScreen.name -> CreateAccountScreen
            ReaderHomeScreen.name -> ReaderHomeScreen
            SearchScreen.name -> SearchScreen
            DetailScreen.name -> DetailScreen
            ReaderStatsScreen.name -> ReaderStatsScreen
            UpdateScreen.name -> UpdateScreen
            null -> ReaderHomeScreen
            else -> throw IllegalArgumentException("Rou $route is not recognized")
        }
    }
}