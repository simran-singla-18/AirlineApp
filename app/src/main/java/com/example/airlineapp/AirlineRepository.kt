package com.example.airlineapp

import javax.inject.Inject

class AirlineRepository @Inject constructor(private val api: AirlineApi) {
    suspend fun fetchAirlines(): List<AirlineModel> = api.getAirlines()
}
