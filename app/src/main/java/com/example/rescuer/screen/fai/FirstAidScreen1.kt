package com.example.rescuer.screen.fai

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.md_theme_light_primary
import com.example.darckoum.data.state.GenerateState
import com.example.rescuer.R
import com.example.rescuer.navigation.Screen

@Composable
fun FirstAidInstructionsScreen1(navController: NavController, firstAidInstructionsViewModel: FirstAidInstructionsViewModel) {
    val fontFamily = FontFamily(Font(R.font.roboto))
    val searchState = remember { mutableStateOf("") }
    val generateState by firstAidInstructionsViewModel.generateState
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(

    ) { contentPadding ->
        // Screen content
        contentPadding
        Column(
            modifier = Modifier.fillMaxSize(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            when (generateState) {
                is GenerateState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(1f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(64.dp),
                                color = md_theme_light_primary
                            )
                            Spacer(modifier = Modifier.height(32.dp))
                            Text(
                                text = "Hang tight...",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Medium,
                                color = md_theme_light_primary
                            )
                        }
                    }
                }

                is GenerateState.Success -> {
                    /*navController.navigate(Screen.Main.route)*/
                    showBottomSheet = true
                }

                is GenerateState.Error -> {
                    Toast.makeText(
                        context,
                        (generateState as GenerateState.Error).message,
                        Toast.LENGTH_SHORT
                    ).show()
                    firstAidInstructionsViewModel.setLoginState(GenerateState.Initial)
                }

                else -> {
                    Text(
                        text = "Rescuer",
                        fontSize = 30.sp,
                        fontFamily = fontFamily,
                        modifier = Modifier
                    )
                    Image(
                        painter = painterResource(id = R.drawable.logo_of_the_red_crescent),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .fillMaxHeight(0.2f),
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.8f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Please select the body part that has been injured",
                            fontFamily = fontFamily,
                            modifier = Modifier
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {
                                navController.navigate(Screen.FirstAidInstructions2.route)
                            },
                            modifier = Modifier
                                .fillMaxWidth(1f)
                        ) {
                            Text(
                                text = "Head",
                                fontSize = 20.sp,
                                fontFamily = fontFamily,
                                modifier = Modifier
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {
                                navController.navigate(Screen.FirstAidInstructions2.route)
                            },
                            modifier = Modifier
                                .fillMaxWidth(1f)
                        ) {
                            Text(
                                text = "Torso",
                                fontSize = 20.sp,
                                fontFamily = fontFamily,
                                modifier = Modifier
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {
                                navController.navigate(Screen.FirstAidInstructions2.route)
                            },
                            modifier = Modifier
                                .fillMaxWidth(1f)
                        ) {
                            Text(
                                text = "Limbs",
                                fontSize = 20.sp,
                                fontFamily = fontFamily,
                                modifier = Modifier
                            )
                        }
                    }
                }
            }
        }
    }
}