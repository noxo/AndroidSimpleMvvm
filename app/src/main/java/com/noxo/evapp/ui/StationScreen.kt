package com.noxo.evapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.noxo.evapp.model.Connector
import com.noxo.evapp.model.Evse
import com.noxo.evapp.model.Station

@Composable
fun StationScreen(viewModel: StationViewModel, token : String)  {
    val stations by viewModel.uiState.collectAsStateWithLifecycle()
    StationScreenContent(stations = stations.stationList)
}

@Composable
fun StationScreenContent(stations : Array<Station>) {
    Column() {
        stations.forEach {
            StationRow(it)
        }
    }
}

@Composable
fun StationRow(station : Station) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        ) {
        Text(text=station.name, color = Color.Black)
        Text(text=station.city, color = Color.Black)
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun PreviewStationScreen() {
    val stations = arrayOf(
        Station("Kuopio", listOf(Evse(listOf(Connector(10,"kw")),"group1",1)),1, Double.MAX_VALUE,Double.MIN_VALUE,"random1","Virta"),
        Station("Leppävirta", listOf(Evse(listOf(Connector(10,"kw")),"group1",1)),1, Double.MAX_VALUE,Double.MIN_VALUE,"random2","Virta"),
        Station("Varkaus", listOf(Evse(listOf(Connector(10,"kw")),"group1",1)),1, Double.MAX_VALUE,Double.MIN_VALUE,"random3","Virta")
    )
    StationScreenContent(stations = stations)
}