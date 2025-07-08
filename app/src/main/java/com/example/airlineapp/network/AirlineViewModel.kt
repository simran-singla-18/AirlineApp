package com.example.airlineapp.network

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airlineapp.models.AirlineModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AirlineViewModel @Inject constructor(private val repo: AirlineRepository): ViewModel() {

    private val _airlines = MutableStateFlow<List<AirlineModel>>(emptyList())
    val airlines: StateFlow<List<AirlineModel>> = _airlines.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _airlines.value = repo.fetchAirlines()
            } catch (e: Exception) {
                Log.e("ViewModel", "Error: ${e.message}")
            }
        }
    }
}
