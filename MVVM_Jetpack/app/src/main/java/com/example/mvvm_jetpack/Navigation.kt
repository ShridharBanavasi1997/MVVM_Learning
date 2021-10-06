package com.example.mvvm_jetpack

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginApp(){
    var navController= rememberNavController()
    NavHost(navController = navController, startDestination = "loginPage"){
        composable(route = "loginPage"){
            LoginPage(navController = navController)
        }
        composable(route = "registerPage"){
            RegisterPage(navController = navController)
        }
        composable(route="homePage"){
            HomePage()
        }

    }
}