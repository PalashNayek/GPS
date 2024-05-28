package com.palash.gps.view_models

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palash.gps.repositories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(private val locationRepository: LocationRepository) : ViewModel() {

    val locationData: LiveData<Location?> = locationRepository.locationData

    fun startLocationUpdates() {
        viewModelScope.launch {
            locationRepository.startLocationUpdates()
        }
    }

    fun stopLocationUpdates() {
        viewModelScope.launch {
            locationRepository.stopLocationUpdates()
        }
    }
}