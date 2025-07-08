package com.example.airlineapp.network

import com.example.airlineapp.models.AirlineModel
import retrofit2.http.GET

interface AirlineApi {
    @GET("airlines")
    suspend fun getAirlines(): List<AirlineModel>
}
