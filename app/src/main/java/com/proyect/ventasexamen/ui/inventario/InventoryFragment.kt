package com.proyect.ventasexamen.ui.inventario

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
import com.proyect.ventasexamen.viewModels.InventaryViewModel
import kotlinx.android.synthetic.main.fragment_inventory.*


class InventoryFragment : Fragment() {
    val inventaryViewModel: InventaryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_inventory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }
    private fun initData(){
        inventaryViewModel.getSalesApi(requireContext())
        createRecicler()
    }
    private fun createRecicler(){
        rv_inventory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = InventaryAdapter(requireContext())
        inventaryViewModel.inventory.observe(viewLifecycleOwner){
            adapter.updateList(it)
            Log.i("Check___", it.toString())
        }
        rv_inventory.adapter = adapter
    }
}