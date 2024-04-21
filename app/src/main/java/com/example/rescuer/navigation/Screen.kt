package com.example.rescuer.navigation

sealed class Screen(val route: String) {
    data object Home: Screen(route = "home_screen")
    data object FirstAidInstructions: Screen(route = "first_aid_instructions_screen")
    data object FirstAidInstructions1: Screen(route = "first_aid_instructions_screen1")
    data object FirstAidInstructions2: Screen(route = "first_aid_instructions_screen2")
    data object Results: Screen(route = "results")
    data object CommonInjuries: Screen(route = "common_injuries_screen")
    data object About: Screen(route = "about_screen")
}