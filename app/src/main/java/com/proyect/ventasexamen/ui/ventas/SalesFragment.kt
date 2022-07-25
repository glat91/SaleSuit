package com.proyect.ventasexamen.ui.ventas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.ui.inventario.reciclers.InventaryAdapter
import com.proyect.ventasexamen.ui.ventas.recicler.SalesAdapter
import com.proyect.ventasexamen.ui.viewModels.InventaryViewModel
import com.proyect.ventasexamen.ui.viewModels.SalesViewModel
import kotlinx.android.synthetic.main.fragment_inventory.*
import kotlinx.android.synthetic.main.fragment_sales.*

class SalesFragment : Fragment() {
    val salesViewModel: SalesViewModel by viewModels()
    companion object{
        val salesInstance = SalesFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sales, container, false)
    }

    private fun initData(){
        salesViewModel.getSales()
        createRecicler()
    }
    private fun createRecicler(){
        rv_salesSales.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = SalesAdapter()
        salesViewModel.sales.observe(viewLifecycleOwner){
            adapter.update(it)
            Log.i("Check___", it.toString())
        }
        rv_salesSales.adapter = adapter
    }

}