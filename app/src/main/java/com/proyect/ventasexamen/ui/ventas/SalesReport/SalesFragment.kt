package com.proyect.ventasexamen.ui.ventas.SalesReport

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.ui.ventas.SalesReport.recicler.SalesAdapter
import com.proyect.ventasexamen.viewModels.SalesViewModel
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
        salesViewModel.getSalesApi(requireContext())
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