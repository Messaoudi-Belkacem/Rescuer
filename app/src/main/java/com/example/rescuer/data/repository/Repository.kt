package com.example.rescuer.data.repository

import com.example.rescuer.api.RetrofitInstance
import com.example.rescuer.data.model.Instructions
import retrofit2.Response

class Repository {

    private val tag = "Repository.kt"

    suspend fun getInstructions(): Response<List<Instructions>> {
        return RetrofitInstance.instructionService.getInstructions()
    }

    suspend fun getInstruction(): Response<Instructions> {
        return RetrofitInstance.instructionService.getInstruction()
    }

}