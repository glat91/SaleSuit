package com.proyect.ventasexamen.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.ui.configuracion.SettingsFragment
import com.proyect.ventasexamen.ui.estadisticas.GraphFragment
import com.proyect.ventasexamen.ui.inventario.InventoryFragment
import com.proyect.ventasexamen.ui.ventas.SalesReport.SalesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(SalesFragment.salesInstance)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.money->{ replaceFragment(SalesFragment.salesInstance) }
                R.id.tableChart->{ replaceFragment(InventoryFragment()) }
                R.id.graph->{replaceFragment(GraphFragment.graphInstance)}
                R.id.settings->{replaceFragment(SettingsFragment.settingsInstance)}
            }
            true
        }

    }


    /** Metodo para cambiar de Activity */
    private fun replaceFragment(fragment: Fragment, addBack: Boolean = false, levelName: String? = null){
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.frg_mainLogin, fragment)
        if(addBack){ trans.addToBackStack(levelName) }
        trans.commit()
    }
}