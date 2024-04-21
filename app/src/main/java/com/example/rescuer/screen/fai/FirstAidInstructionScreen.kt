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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.md_theme_light_primary
import com.example.darckoum.data.state.GenerateState
import com.example.rescuer.R
import com.example.rescuer.navigation.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstAidInstructionsScreen(navController: NavController, firstAidInstructionsViewModel: FirstAidInstructionsViewModel) {
    val fontFamily = FontFamily(Font(R.font.roboto))
    val searchState = remember { mutableStateOf("") }
    val generateState by firstAidInstructionsViewModel.generateState
    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState()
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
                    Text(
                        text = """Please note that the first aid instructions provided by this app are for informational purposes only
                                |They may not be accurate or appropriate for all situations
                                |Always seek professional medical assistance in emergencies""".trimMargin(),
                        fontFamily = fontFamily,
                        modifier = Modifier
                            .fillMaxWidth(0.8f),
                        textAlign = TextAlign.Center
                    )
                    Button(
                        onClick = {
                            navController.navigate(Screen.FirstAidInstructions1.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                    ) {
                        Text(
                            text = "Start",
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