package com.noxo.evapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noxo.evapp.model.Credentials
import com.noxo.evapp.model.Station
import com.noxo.evapp.repository.EVStationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

import javax.inject.Inject

@HiltViewModel
class StationViewModel @Inject constructor(private val evStationRepository: EVStationRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(StationListState(false, emptyArray()))
    val uiState: StateFlow<StationListState> = _uiState.asStateFlow()

    init {
        getStations("", 0.0,0.0)
    }

    fun getStations(token : String, latitude : Double, longitude: Double)  {
        viewModelScope.launch {
            val stations = evStationRepository.getStations(token, latitude, longitude)
            stations.onSuccess { stationList ->
                _uiState.update { it.copy(true, stationList) }
            }
        }
    }

}

data class StationListState (
    val loaded : Boolean,
    val stationList :Array<Station>
)