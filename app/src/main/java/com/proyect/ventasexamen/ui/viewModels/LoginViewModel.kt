package com.proyect.ventasexamen.ui.viewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyect.ventasexamen.apiCall.Engine
import com.proyect.ventasexamen.apiCall.Services
import com.proyect.ventasexamen.helpers.PerssistData
import com.proyect.ventasexamen.models.loginResponse.LoginResponse
import com.proyect.ventasexamen.models.sharedPreference.UserPreferences
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class LoginViewModel: ViewModel() {
    private val _loginResponse = MutableLiveData<Boolean>(false)
    val loginResponse = _loginResponse

    fun checkLogin(usuario: String, contrasena: String, cnx: Context){
        viewModelScope.launch {
            val apiEngine = Engine.getEngine().create<Services>()
            apiEngine.getLogin().enqueue(object: Callback<ArrayList<LoginResponse>>{
                override fun onResponse(call: Call<ArrayList<LoginResponse>>, response: Response<ArrayList<LoginResponse>>) {
                    Log.i("LoginResponse___", response.toString())
                    if (response.isSuccessful){
                        val users = response.body()
                        for (user in users!!){
                            if (user.user == usuario && user.contraseña == contrasena){
                                PerssistData.saveModel(user.id, user.user, user.nombre, user.fechaRegistro, user.correo, user.contraseña, cnx)
                                _loginResponse.value = true
                            }
                        }
                    }
                }
                override fun onFailure(call: Call<ArrayList<LoginResponse>>, t: Throwable) {
                    Log.e("LoginResponse___", t.toString())
                }
            })
        }
    }
}