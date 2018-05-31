package com.kayak.toulouse.kayak.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kayak.toulouse.kayak.R
import com.kayak.toulouse.kayak.data.entities.FlyListItem
import kotlinx.android.synthetic.main.list_item_fly.view.*

class FlyListAdapter(
        val items: ArrayList<FlyListItem>,
        val context: Context
        )
    : RecyclerView.Adapter<FlyListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_fly,null,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flyListItem : FlyListItem=items.get(position)
        holder.imgAirline.setImageDrawable(context.getDrawable(flyListItem.origin.airlineLogo))
        holder.txtAirlines.text=flyListItem.airlines
        holder.txtCityDestination.text=flyListItem.origin.destinationCity
        holder.txtCityOrigin.text=flyListItem.origin.originCity
        holder.txtFlightTime.text=flyListItem.origin.getFlyLongerThanDay().toString()
        holder.txtPrice.text=flyListItem.price.toDouble().toString()
        holder.txtTimeDestination.text=flyListItem.origin.originDate.toString()
        holder.txtTimeOrigin.text=flyListItem.origin.destinationDate.toString()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imgAirline: ImageView = view.imgAirline;
        val txtAirlines: TextView = view.txtAirlines;
        val txtCityDestination: TextView = view.txtCityDestination;
        val txtCityOrigin: TextView = view.txtCityOrigin;
        val txtFlightTime: TextView = view.txtFlightTime;
        val txtPrice: TextView = view.txtPrice;
        val txtTimeDestination: TextView = view.txtTimeDestination;
        val txtTimeOrigin: TextView = view.txtTimeOrigin;
    }
}