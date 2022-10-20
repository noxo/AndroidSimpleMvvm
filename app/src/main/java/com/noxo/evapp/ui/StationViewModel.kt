package com.noxo.evapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.noxo.evapp.model.Station
import com.noxo.evapp.service.EvService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*

import javax.inject.Inject

@HiltViewModel
class StationViewModel @Inject constructor(private val evService: EvService) : ViewModel() {

    private val coroutineExceptionHanlder = CoroutineExceptionHandler { _, throwable ->
        currentStationList.postValue(Result.failure(throwable))
    }

    private val coroutineScope = CoroutineScope(Dispatchers.IO + coroutineExceptionHanlder)

    val currentStationList: MutableLiveData<Result<Array<Station>>> by lazy {
        MutableLiveData<Result<Array<Station>>>()
    }

    fun getStations(token : String, latitude : Double, longitude: Double)  {
        this.coroutineScope.launch {
            val stations = evService.getStations(token, latitude, longitude)
            currentStationList.postValue(Result.success(stations))
        }
    }
}