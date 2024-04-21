package com.example.rescuer.api

import com.example.rescuer.data.model.Instructions
import retrofit2.Response
import retrofit2.http.GET

interface InstructionService {
    @GET("announcements")
    suspend fun getInstructions(): Response<List<Instructions>>
    @GET("announcements/{announcementId}")
    suspend fun getInstruction(): Response<Instructions>
}