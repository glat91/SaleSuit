package com.proyect.ventasexamen.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.proyect.ventasexamen.R
import com.proyect.ventasexamen.ui.MainActivity
import com.proyect.ventasexamen.ui.viewModels.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    companion object{
        /** Fragment Instance */
        val loginInstance = LoginFragment()
    }
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_enterLogin.setOnClickListener {
            val usuario = inp_userLogin.text.toString()
            val contrasenia = inp_passwordLogin.text.toString()
            loginViewModel.checkLogin(usuario, contrasenia, requireContext())
        }
        loginViewModel.loginResponse.observe(viewLifecycleOwner){
            if (it == true){
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }
        }
    }


}