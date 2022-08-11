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
import com.proyect.ventasexamen.viewModels.GraphViewModel
import kotlinx.android.synthetic.main.fragment_graph.*

class GraphFragment : Fragment() {
    val graphViewModel: GraphViewModel by viewModels()
    var total = 0.00
    companion object{
        val graphInstance = GraphFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        total = 0.00
        initData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_graph, container, false)
    }

    private fun initData(){
        graphViewModel.getGraph(requireContext())
        inp_totalGraph.text = "$ $total"
        createRecicler()
    }
    private fun createRecicler(){
        rv_salesGraph.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = GraphAdapter()
        graphViewModel.graph.observe(viewLifecycleOwner){
            adapter.update(it)
            for(c in it){
                total += c.total.toInt()
            }
            Log.i("Check___", it.toString())
        }
        rv_salesGraph.adapter = adapter
    }
}