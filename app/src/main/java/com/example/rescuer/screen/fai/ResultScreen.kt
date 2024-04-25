package com.example.rescuer.screen.fai

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rescuer.R

@Composable
fun ResultScreen(navController: NavController, firstAidInstructionsViewModel: FirstAidInstructionsViewModel) {
    val fontFamily = FontFamily(Font(R.font.roboto))

    Scaffold(
        modifier = Modifier
            .fillMaxSize(1f),
    ) { contentPadding ->
        // Screen content
        contentPadding
        val instructionsList = firstAidInstructionsViewModel.responseInstructions.value.instructionsList
        Column(
            modifier = Modifier
                .fillMaxSize(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            instructionsList[0].forEach { (key, value) ->
                InstructionItem(
                    title = key,
                    body = value,
                    fontFamily = fontFamily
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun InstructionItem(title: String, body: String, fontFamily: FontFamily) {
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = title,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(horizontal = 8.dp)
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = body,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        modifier = Modifier,
        textAlign = TextAlign.Center
    )
}