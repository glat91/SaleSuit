package com.proyect.ventasexamen.ui.inventario.reciclers

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.models.inventoryResponse.Product

class InventaryAdapter(private val cnx: Context): RecyclerView.Adapter<InventaryViewHolder>() {
    var inventory: MutableList<Product> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(data: List<Product>){
        inventory.clear()
        inventory.addAll(data)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InventaryViewHolder {
        val lInflater = LayoutInflater.from(parent.context)
        val view = lInflater.inflate(R.layout.item_inventory, parent, false)
        return InventaryViewHolder(view)
    }

    override fun onBindViewHolder(holder: InventaryViewHolder, position: Int) {
        val item = inventory[position]
        holder.render(item, cnx)
    }

    override fun getItemCount() = inventory.size
}