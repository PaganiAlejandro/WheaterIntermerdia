package com.aplicacion.wheater.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aplicacion.wheater.data.entities.AppResult
import com.aplicacion.wheater.data.entities.WheatherToday
import com.aplicacion.wheater.data.repository.CurrentCityRepository
import com.aplicacion.wheater.util.collectWithLoadingState
import kotlinx.coroutines.launch

class CurrentCityViewModel(
    private val currentCityRepository: CurrentCityRepository
): ViewModel() {

    private var _wheaterCityName = MutableLiveData<WheatherToday>()
    val wheaterCityName: LiveData<WheatherToday> get() = _wheaterCityName

    var _isLoadingWheaterCity by remember { mutableStateOf(false) }

    fun getWheaterByCityName(cityName: String) {
        viewModelScope.launch {
            currentCityRepository.getCituByName(cityName = cityName)
                .collectWithLoadingState(_isLoadingWheaterCity) { result ->
                    if (result is AppResult.Success) {

                    }
                }
        }
    }
}