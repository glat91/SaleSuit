package com.proyect.ventasexamen.ui.estadisticas.recicler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.models.graphRv.GraphRv

class GraphAdapter(): RecyclerView.Adapter<GraphViewHolder>() {
    var data: ArrayList<GraphRv> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun update(newData: ArrayList<GraphRv>){
        data.clear()
        data.addAll(newData)
        this.notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GraphViewHolder {
        val lInflater = LayoutInflater.from(parent.context)
        val view = lInflater.inflate(R.layout.item_stats, parent, false)
        return GraphViewHolder(view)
    }

    override fun onBindViewHolder(holder: GraphViewHolder, position: Int) {
        val item = data[position]
        holder.renderizar(item)
    }

    override fun getItemCount() = data.size
}