package com.noxo.evapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.noxo.evapp.databinding.ActivityStationBinding
import com.noxo.evapp.ui.adapter.StationListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StationActivity : AppCompatActivity() {

    private val stationViewModel: StationViewModel by viewModels()
    private val adapter = StationListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val token = intent.getStringExtra("token")!!
        val binding = ActivityStationBinding.inflate(layoutInflater)
        binding.recyclerView.adapter = adapter
        setContentView(binding.root)

        stationViewModel.currentStationList.observe(this) {
            it.onFailure {
                Toast.makeText(this, "Failed loading stations", Toast.LENGTH_LONG).show()
            }
            it.onSuccess {
                adapter.update(it)
            }
        }

        stationViewModel.getStations(token, 0.0,0.0)
    }
}