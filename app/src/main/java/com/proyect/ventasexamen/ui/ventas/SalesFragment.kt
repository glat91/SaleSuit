package com.proyect.ventasexamen.ui.ventas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.ui.inventario.reciclers.InventaryAdapter
import com.proyect.ventasexamen.ui.viewModels.InventaryViewModel
import kotlinx.android.synthetic.main.fragment_inventory.*

class SalesFragment : Fragment() {
    companion object{
        val salesInstance = SalesFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sales, container, false)
    }



}