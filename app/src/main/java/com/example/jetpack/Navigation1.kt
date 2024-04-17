//package com.example.jetpack
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.example.jetpack.userUI.HomeScreen
//import com.example.jetpack.userUI.LOGGIN.LoginScreen
//import com.example.jetpack.userUI.signIN.RegisterScreen
//
//
//sealed class Route(val name: String) {
//
//    object LoginScreen : Route("Login")
//    object HomeScreen : Route("Home")
//    object RegisterScreen : Route("Register")
//}
//
//@Composable
//fun myNavigation(navHostController: NavHostController) {
//    NavHost(
//        navController = navHostController,
//        startDestination = Route.LoginScreen.name
//    ) {
//        composable(route = Route.LoginScreen.name) {
//            LoginScreen( navHostController)
//        }
//        composable(route = Route.RegisterScreen.name) {
//            RegisterScreen(navHostController)
//        }
//        composable(route = Route.HomeScreen.name) {
//            HomeScreen()
//        }
//    }
//}
