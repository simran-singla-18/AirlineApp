package com.example.airlineapp

import retrofit2.http.GET

interface AirlineApi {
    @GET("airlines")
    suspend fun getAirlines(): List<AirlineModel>
}
