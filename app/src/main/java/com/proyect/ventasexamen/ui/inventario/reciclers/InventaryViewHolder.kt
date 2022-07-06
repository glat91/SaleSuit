package com.proyect.ventasexamen.ui.inventario.reciclers

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.models.inventoryResponse.Products

class InventaryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val photo = view.findViewById<ImageView>(R.id.img_photoInventory)
    val name = view.findViewById<TextView>(R.id.txt_nameInventory)
    val brand = view.findViewById<TextView>(R.id.txt_brandInventory)
    val model = view.findViewById<TextView>(R.id.txt_modelInventory)
    val total = view.findViewById<TextView>(R.id.txt_totalInventory)

    fun render(data: Products, cnx: Context){
        Glide.with(cnx).load(data.image).into(photo)
        name.text = data.name
        brand.text = data.brand
        model.text = data.model
        total.text = data.stock.toString()
    }
}