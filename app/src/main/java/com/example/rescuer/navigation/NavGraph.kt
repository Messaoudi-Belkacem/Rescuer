package com.example.rescuer.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rescuer.screen.AboutScreen
import com.example.rescuer.screen.HomeScreen
import com.example.rescuer.screen.fai.FirstAidInstructionsScreen
import com.example.rescuer.screen.fai.FirstAidInstructionsScreen1
import com.example.rescuer.screen.fai.FirstAidInstructionsScreen2
import com.example.rescuer.screen.fai.FirstAidInstructionsViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
    firstAidInstructionsViewModel: FirstAidInstructionsViewModel
) {
    val time = 500
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { slideInHorizontally(animationSpec = tween(time), initialOffsetX = {fullWidth ->  
            -fullWidth
        }) },
        exitTransition = { slideOutHorizontally(animationSpec = tween(time), targetOffsetX = {fullWidth ->
            fullWidth
        }) },
        popEnterTransition = { slideInHorizontally(animationSpec = tween(time), initialOffsetX = {fullWidth ->
            -fullWidth
        }) },
        popExitTransition = { slideOutHorizontally(animationSpec = tween(time), targetOffsetX = {fullWidth ->
            fullWidth
        }) }
    ) {
        composable(
            route = Screen.Home.route,
            ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.FirstAidInstructions.route,
        ) {
            FirstAidInstructionsScreen(navController, firstAidInstructionsViewModel)
        }
        composable(
            route = Screen.FirstAidInstructions1.route,
        ) {
            FirstAidInstructionsScreen1(navController, firstAidInstructionsViewModel)
        }
        composable(
            route = Screen.FirstAidInstructions2.route,
        ) {
            FirstAidInstructionsScreen2(navController, firstAidInstructionsViewModel)
        }
        composable(
            route = Screen.About.route,
        ) {
            AboutScreen(navController)
        }
    }
}