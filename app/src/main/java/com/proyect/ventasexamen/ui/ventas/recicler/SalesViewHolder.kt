package com.proyect.ventasexamen.ui.ventas.recicler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.models.salesRv.SalesRv

class SalesViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val img = view.findViewById<ImageView>(R.id.iv_producto)
    val producto = view.findViewById<TextView>(R.id.txt_titleItemSales)
    val pedidos = view.findViewById<TextView>(R.id.inp_pedidoItemSales)
    val vendidas = view.findViewById<TextView>(R.id.inp_unidadesItemSale)
    val precio = view.findViewById<TextView>(R.id.inp_precioItemSale)

    fun renderizar(datos: SalesRv){
        Glide.with(view.context).load(datos.img).into(img)
        producto.text = datos.title
        pedidos.text = datos.pedidos.toString()
        vendidas.text = datos.vendidos.toString()
        precio.text = datos.precio.toString()
    }
}