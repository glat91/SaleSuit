package com.proyect.ventasexamen.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.ui.login.LoginFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
            replaceFragment(LoginFragment.loginInstance)
        return super.onCreateView(name, context, attrs)
    }
    /** Metodo para cambiar de fragment */
    private fun replaceFragment(fragment: Fragment, addBack: Boolean = false, levelName: String? = null){
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.frg_mainLogin, fragment)
        if(addBack){ trans.addToBackStack(levelName) }
        trans.commit()
    }
}