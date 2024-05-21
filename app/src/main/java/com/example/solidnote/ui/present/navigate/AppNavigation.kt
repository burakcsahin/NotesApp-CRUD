package com.example.solidnote.ui.present.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.solidnote.ui.present.view.addSolidNote.addSolidScreen
import com.example.solidnote.ui.present.view.homeScreen.HomeScreen
import com.example.solidnote.ui.present.view.updateSolidNote.updateSolidScreen

@Composable
fun AppNavigation(navControl: NavHostController){
    NavHost(
        navController = navControl,
        startDestination = Screens.HomeScreen.route
    ){
        composable(route = Screens.HomeScreen.route){
            HomeScreen(navControl)
        }
        composable(route = Screens.addSolidScreen.route){
            addSolidScreen(navControl)
        }
        composable(

            route = Screens.UpdateScreen.route, arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ){
            updateSolidScreen(navControl)
        }
    }

}

sealed class Screens(val route: String){
    data object HomeScreen:Screens("home")
    data object addSolidScreen:Screens("add")
    data object UpdateScreen:Screens("update/{id}"){
        fun getById(id:Int)= "update/$id"
    }

}