package com.example.rescuer.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getString
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.example.rescuer.R
import com.example.rescuer.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    val fontFamily = FontFamily(Font(R.font.roboto))
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
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
            text = getString(context, R.string.app_description),
            textAlign = TextAlign.Center,
            fontFamily = fontFamily,
            fontSize = 14.sp,
            lineHeight = 24.sp,
            modifier = Modifier
                .fillMaxWidth(0.9f)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Button(
                onClick = {
                          navController.navigate(Screen.FirstAidInstructions.route)
                },
                modifier = Modifier
                    .fillMaxWidth(1f)
            ) {
                Text(
                    text = "First Aid Instructions",
                    fontSize = 20.sp,
                    fontFamily = fontFamily,
                    modifier = Modifier
                )
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(1f)
            ) {
                Text(
                    text = "Common Injuries",
                    fontSize = 20.sp,
                    fontFamily = fontFamily,
                    modifier = Modifier
                )
            }
            Button(
                onClick = { navController.navigate(Screen.About.route) },
                modifier = Modifier
                    .fillMaxWidth(1f)
            ) {
                Text(
                    text = "About",
                    fontSize = 20.sp,
                    fontFamily = fontFamily,
                    modifier = Modifier
                )
            }
        }
    }
}