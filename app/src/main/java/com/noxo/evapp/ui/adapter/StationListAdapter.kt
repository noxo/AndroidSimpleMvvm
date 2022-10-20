package com.noxo.evapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.noxo.evapp.R
import com.noxo.evapp.model.Station

class StationListAdapter :
    RecyclerView.Adapter<StationListAdapter.ViewHolder>() {

    private var stationList = arrayOf<Station>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        init {
            textView = view.findViewById(R.id.textViewStationName)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.station_row, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = stationList[position].name
    }

    override fun getItemCount() = stationList.size

    fun update(stationList: Array<Station>) {
        this.stationList = stationList
        notifyDataSetChanged()
    }

}