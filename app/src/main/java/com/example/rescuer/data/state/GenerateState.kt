package com.example.darckoum.data.state

sealed class GenerateState {
    object Initial : GenerateState()
    object Loading : GenerateState()
    object Success : GenerateState()
    data class Error(val message: String) : GenerateState()
}