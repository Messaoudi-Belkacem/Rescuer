package com.example.rescuer.api

import com.example.rescuer.data.model.Instructions
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface InstructionService {
    @GET("first-aid")
    suspend fun getInstructions(): Response<List<Instructions>>
    @GET("first-aid")
    suspend fun getInstruction(
        @Query("symptoms") symptoms: List<String>
    ): Response<List<Map<String, String>>>
}