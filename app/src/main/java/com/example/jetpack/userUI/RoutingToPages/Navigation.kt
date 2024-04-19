package com.example.jetpack.userUI.RoutingToPages

import HomeScreen
import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack.userUI.LOGGIN.LogginScreen2

import com.example.jetpack.userUI.LOGGIN.loginViewModel
import com.example.jetpack.userUI.signIN.RegisterScreen2


enum class LoginRoutes {
    LOGIN,
    SIGNUP,

}

enum class HomeRoutes {
    HOME,
    LOGIN,
}



@SuppressLint("SuspiciousIndentation")
@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: loginViewModel
) {

    NavHost(navController = navController, startDestination = LoginRoutes.LOGIN.name) {
        composable(route = LoginRoutes.LOGIN.name) {
            LogginScreen2(
               onNavToHomePage = {
                     navController.navigate(HomeRoutes.HOME.name){
                         launchSingleTop = true
                            popUpTo(route =LoginRoutes.LOGIN.name){
                                inclusive = true
                            }
                     }
                },
                loginViewModel = loginViewModel
            ){
                navController.navigate(LoginRoutes.SIGNUP.name){
                    launchSingleTop = true
                    popUpTo(route =LoginRoutes.LOGIN.name){
                        inclusive = true
                    }
                }
            }
    }


        composable(route = LoginRoutes.SIGNUP.name){
            RegisterScreen2(onNavToHomePage = {
                navController.navigate(HomeRoutes.HOME.name){
                    launchSingleTop = true
                    popUpTo(route =LoginRoutes.SIGNUP.name){
                        inclusive = true
                    }
                }
            },
               loginViewModel = loginViewModel
            ) {
                navController.navigate(LoginRoutes.LOGIN.name)

                }
            }


        composable(route = HomeRoutes.HOME.name){
            HomeScreen(
                navToLoginPage = {
                    navController.navigate(LoginRoutes.LOGIN.name){
                        launchSingleTop = true
                        popUpTo(route =HomeRoutes.HOME.name){
                            inclusive = true
                        }
                    }
                },
                loginViewModel = loginViewModel
            )
        }

        }
        }

