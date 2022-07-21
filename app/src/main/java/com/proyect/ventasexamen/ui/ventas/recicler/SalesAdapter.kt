package com.proyect.ventasexamen.ui.ventas.recicler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.models.salesRv.SalesRv

class SalesAdapter: RecyclerView.Adapter<SalesViewHolder>() {
    var sales: MutableList<SalesRv> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun update(newData: ArrayList<SalesRv>){
        sales.clear()
        sales.addAll(newData)
        this.notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesViewHolder {
        val lInflater = LayoutInflater.from(parent.context)
        val view = lInflater.inflate(R.layout.item_sales, parent, false)
        return SalesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        val item = sales[position]
        holder.renderizar(item)
    }

    override fun getItemCount() = sales.size
}