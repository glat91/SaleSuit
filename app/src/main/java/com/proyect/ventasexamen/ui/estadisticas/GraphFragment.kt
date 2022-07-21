package com.proyect.ventasexamen.ui.estadisticas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.ui.estadisticas.recicler.GraphAdapter
import com.proyect.ventasexamen.ui.ventas.recicler.SalesAdapter
import com.proyect.ventasexamen.ui.viewModels.GraphViewModel
import kotlinx.android.synthetic.main.fragment_graph.*
import kotlinx.android.synthetic.main.fragment_inventory.*
import kotlinx.android.synthetic.main.fragment_sales.*

class GraphFragment : Fragment() {
    val graphViewModel: GraphViewModel by viewModels()
    companion object{
        val graphInstance = GraphFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_graph, container, false)
    }

    private fun initData(){
        graphViewModel.getSales()
        createRecicler()
    }
    private fun createRecicler(){
        rv_salesGraph.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = GraphAdapter()
        graphViewModel.graph.observe(viewLifecycleOwner){
            adapter.update(it)
            Log.i("Check___", it.toString())
        }
        rv_salesGraph.adapter = adapter
    }
}