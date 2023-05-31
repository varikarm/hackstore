package com.example.myapplication.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screens.Add
import com.example.myapplication.screens.Application
import com.example.myapplication.screens.Main
import com.example.myapplication.screens.Start


sealed class NavRoute(val route: String){
    object Start:NavRoute("start_screen")
    object Main:NavRoute("main_screen")
    object Add:NavRoute("add_screen")
    object Application:NavRoute("application_screen")
}

@Composable
fun HackNavHost(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route){
        composable(NavRoute.Start.route){Start(navController = navController)}
        composable(NavRoute.Add.route){Add(navController = navController) }
        composable(NavRoute.Main.route){Main(navController = navController) }
        composable(NavRoute.Application.route){Application(navController = navController) }
    }

}