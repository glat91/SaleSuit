package com.proyect.ventasexamen.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proyect.ventasexamen.models.graphRv.GraphRv
import com.proyect.ventasexamen.models.salesRv.SalesRv

class GraphViewModel: ViewModel() {
    private val _graph = MutableLiveData<ArrayList<GraphRv>>()
    val graph = _graph

    fun getSales(){
        val array = arrayListOf<GraphRv>()
        array.add(GraphRv("06", "Julio", "50000.00"))
        array.add(GraphRv("06", "Julio", "50000.00"))
        array.add(GraphRv("06", "Julio", "50000.00"))
        array.add(GraphRv("06", "Julio", "50000.00"))
        array.add(GraphRv("06", "Julio", "50000.00"))
        array.add(GraphRv("06", "Julio", "50000.00"))
        array.add(GraphRv("06", "Julio", "50000.00"))
        _graph.value = array
    }
}