package com.example.madlevel3task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_poral.view.*

class PortalAdapter(private val portals: List<Portal>) :
    RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortalAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_poral, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PortalAdapter.ViewHolder, position: Int) {
        holder.databind(portals[position])
    }

    override fun getItemCount(): Int {
        return portals.size
    }

    /**
     * Bind the item view to the data model
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun databind(portal: Portal) {
            itemView.txtViewPotalTitle.text = portal.portalTitle
            itemView.txtViewPortalLink.text = portal.portalText
        }
    }
}