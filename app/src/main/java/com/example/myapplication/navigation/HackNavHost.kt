package com.example.myapplication.navigation
import ApplicationScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screens.*


sealed class NavRoute(val route: String){
    object Start:NavRoute("start_screen")
    object Main:NavRoute("main_screen")
    object Add:NavRoute("add_screen")
    object Application:NavRoute("application_screen")
    object Registration:NavRoute("application_screen")
}

@Composable
fun HackNavHost(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route){
        composable(NavRoute.Start.route){StartScreen(navController = navController) }
        composable(NavRoute.Add.route){ AddScreen(navController = navController) }
        composable(NavRoute.Main.route){MainScreen(navController = navController) }
        composable(NavRoute.Application.route){ApplicationScreen(navController = navController) }
        composable(NavRoute.Registration.route){RegistrationScreen(navController = navController) }
    }

}