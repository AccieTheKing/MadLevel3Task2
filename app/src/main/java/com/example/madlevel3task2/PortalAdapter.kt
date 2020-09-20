package com.example.madlevel3task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_poral.view.*

class PortalAdapter(private val portals: List<Portal>, val clickListener: (Portal) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortalAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_poral, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).databind(portals[position], clickListener)
    }

    override fun getItemCount(): Int {
        return portals.size
    }

    /**
     * Bind the item view to the data model
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun databind(portal: Portal, clickListener: (Portal) -> Unit) {
            itemView.txtViewPotalTitle.text = portal.portalTitle
            itemView.txtViewPortalLink.text = portal.portalText
            itemView.setOnClickListener { clickListener(portal) }
        }
    }
}