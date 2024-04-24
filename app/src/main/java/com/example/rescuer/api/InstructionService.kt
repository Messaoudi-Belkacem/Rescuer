package com.example.rescuer.api

import com.example.rescuer.data.model.Instructions
import retrofit2.Response
import retrofit2.http.GET

interface InstructionService {
    @GET("first-aid")
    suspend fun getInstructions(): Response<List<Instructions>>
    @GET("first-aid/{symptoms}")
    suspend fun getInstruction(): Response<Instructions>
}