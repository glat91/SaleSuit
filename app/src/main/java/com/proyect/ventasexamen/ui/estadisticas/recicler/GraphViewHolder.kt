package com.proyect.ventasexamen.ui.estadisticas.recicler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.models.graphRv.GraphRv

class GraphViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val dia = view.findViewById<TextView>(R.id.inp_dayItemStats)
    val mes = view.findViewById<TextView>(R.id.inp_monthItemStats)
    val total = view.findViewById<TextView>(R.id.inp_totalItemSales)

    fun renderizar(datos: GraphRv){
        dia.text = datos.dia
        mes.text = datos.mes
        total.text = datos.total
    }
}