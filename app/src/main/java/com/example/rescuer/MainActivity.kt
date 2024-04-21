package com.example.rescuer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.rescuer.data.OffLineExpertSystem
import com.example.rescuer.navigation.Screen
import com.example.rescuer.navigation.SetupNavGraph
import com.example.rescuer.screen.fai.FirstAidInstructionsViewModel
import com.example.rescuer.screen.fai.FirstAidInstructionsViewModelFactory

class MainActivity : ComponentActivity() {



    lateinit var navController: NavHostController
    private val startDestination = Screen.Home.route

    private lateinit var firstAidInstructionsViewModel: FirstAidInstructionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val offLineExpertSystem = OffLineExpertSystem()

        val firstAidInstructionsViewModelFactory = FirstAidInstructionsViewModelFactory(offLineExpertSystem, application)

        firstAidInstructionsViewModel = ViewModelProvider(this, firstAidInstructionsViewModelFactory)[FirstAidInstructionsViewModel::class.java]


        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navController = rememberNavController()
                    SetupNavGraph(
                        navController = navController,
                        startDestination = startDestination,
                        firstAidInstructionsViewModel = firstAidInstructionsViewModel
                    )
                }
            }
        }
    }
}

