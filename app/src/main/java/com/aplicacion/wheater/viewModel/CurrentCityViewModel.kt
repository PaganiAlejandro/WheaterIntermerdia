package com.aplicacion.wheater.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aplicacion.wheater.data.entities.AppResult
import com.aplicacion.wheater.data.entities.WheatherToday
import com.aplicacion.wheater.data.repository.CurrentCityRepository
import com.aplicacion.wheater.util.collectWithLoading
import kotlinx.coroutines.launch

class CurrentCityViewModel(
    private val currentCityRepository: CurrentCityRepository
) : ViewModel() {

    private var _wheaterCityName = MutableLiveData<WheatherToday>()
    val wheaterCityName: LiveData<WheatherToday> get() = _wheaterCityName

    private val _isLoadingWheater = MutableLiveData<Boolean>()

    fun getWheaterByCityName(cityName: String) {
        viewModelScope.launch {
            currentCityRepository.getCituByName(cityName = cityName)
                .collectWithLoading(_isLoadingWheater) { result ->
                    if (result is AppResult.Success) {
                        _wheaterCityName.postValue(result.data)
                    }
                }
        }
    }
}