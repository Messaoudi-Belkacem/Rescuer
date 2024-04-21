package com.example.rescuer.api

import com.example.darckoum.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val instructionService: InstructionService by lazy {
        retrofit.create(InstructionService::class.java)
    }

}