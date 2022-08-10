package com.proyect.ventasexamen.ui.configuracion

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.helpers.PerssistData
import com.proyect.ventasexamen.ui.LoginActivity
import com.proyect.ventasexamen.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {
    companion object{
        val settingsInstance = SettingsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_closeSessionSettings.setOnClickListener{
            PerssistData.deletePerssistData(requireContext())
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

    }
}