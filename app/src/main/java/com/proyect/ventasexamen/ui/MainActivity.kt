package com.proyect.ventasexamen.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
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
        AppCenter.start(
            application, "109aef59-79ee-4fa3-a251-5aa2da8e967b",
            Analytics::class.java, Crashes::class.java
        )

    }


    /** Metodo para cambiar de Activity */
    private fun replaceFragment(fragment: Fragment, addBack: Boolean = false, levelName: String? = null){
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.frg_mainActivity, fragment)
        if(addBack){ trans.addToBackStack(levelName) }
        trans.commit()
    }
}