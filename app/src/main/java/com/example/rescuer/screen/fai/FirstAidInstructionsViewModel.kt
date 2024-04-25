package com.example.rescuer.screen.fai

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.darckoum.data.state.GenerateState
import com.example.rescuer.data.OffLineExpertSystem
import com.example.rescuer.data.model.Instructions
import com.example.rescuer.data.repository.Repository
import kotlinx.coroutines.launch
import java.net.ConnectException

class FirstAidInstructionsViewModel(
    private val repository: Repository,
    private val offLineExpertSystem: OffLineExpertSystem,
    application: Application
) : ViewModel() {

    private val _symptomsList = mutableListOf("Injured(x)")
    val symptomsList: List<String> = _symptomsList

    private val tag: String = "FirstAidInstructionsViewModel.kt"
    private val appContext: Context = application.applicationContext

    private val _generateState = mutableStateOf<GenerateState>(GenerateState.Initial)
    val generateState: State<GenerateState> = _generateState

    private val _responseInstructions = mutableStateOf(Instructions(mutableListOf()))
    var responseInstructions: State<Instructions> = _responseInstructions

    fun generateInstructions() {
        viewModelScope.launch {
            try {
                val response = repository.getInstructionsBySymptoms(_symptomsList)
                if (response.isSuccessful) {
                    _generateState.value = GenerateState.Success
                    _responseInstructions.value = Instructions(response.body()!!.toMutableList())
                    Log.d(tag, "response was successful")
                    Log.d(tag, "response: " + response.body().toString())
                } else {
                    _generateState.value = GenerateState.Error("Generating results failed. Please try again.")
                    Log.d(tag, "response was not successful")
                    Log.d(tag, "response error body (string): " + (response.errorBody()!!.string()))
                    Log.d(
                        tag,
                        "response error body (to string): " + (response.errorBody().toString())
                    )
                    Log.d(tag, "response code: " + (response.code().toString()))
                }
            } catch (e: ConnectException) {
                Log.d(
                    tag,
                    "Failed to connect to the server. Please check your internet connection."
                )
                _generateState.value = GenerateState.Error("An error occurred during Login")
                e.printStackTrace()
            } catch (e: Exception) {
                Log.d(tag, "An unexpected error occurred.")
                e.printStackTrace()
                _generateState.value = GenerateState.Error("An error occurred during Login")
            }
        }
    }

    fun setLoginState(generateState: GenerateState) {
        _generateState.value = generateState
    }

    private fun parseStringToList(input: String): List<String> {
        return input.split("\\s+".toRegex())
    }

    fun addSymptom(string: String) {
        _symptomsList.add(string)
    }

}