package com.example.airlineapp.network

import com.example.airlineapp.models.AirlineModel
import javax.inject.Inject

class AirlineRepository @Inject constructor(private val api: AirlineApi) {
    suspend fun fetchAirlines(): List<AirlineModel> = api.getAirlines()
}
