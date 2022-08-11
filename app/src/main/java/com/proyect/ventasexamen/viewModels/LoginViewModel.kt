package com.proyect.ventasexamen.viewModels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyect.ventasexamen.apiCall.Engine
import com.proyect.ventasexamen.apiCall.Services
import com.proyect.ventasexamen.helpers.PerssistData
import com.proyect.ventasexamen.models.loginResponse.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class LoginViewModel: ViewModel() {
    companion object{
        var loginStatus = ""
    }
    private val _loginResponse = MutableLiveData<Boolean>(false)
    val loginResponse = _loginResponse

    fun checkLogin(usuario: String, contrasena: String, cnx: Context){
        viewModelScope.launch {
            val apiEngine = Engine.getEngine().create<Services>()
            apiEngine.getLogin().enqueue(object: Callback<ArrayList<LoginResponse>>{
                override fun onResponse(call: Call<ArrayList<LoginResponse>>, response: Response<ArrayList<LoginResponse>>) {
                    Log.i("LoginResponse___", response.body().toString())
                    if (response.isSuccessful){
                        val users = response.body()
                        for (user in users!!){
                            if (user.user == usuario && user.contraseña == contrasena){
                                PerssistData.saveModel(user.id, user.user, user.nombre, user.fechaRegistro, user.correo, user.contraseña, cnx)
                                _loginResponse.value = true
                                loginStatus = "Datos correctos"
                            }
                        }
                        if (!_loginResponse.value!!){
                            loginStatus = "Datos incorrectos favor de intentar de nuevo"
                            Toast.makeText(cnx, "Datos incorrectos favor de intentar de nuevo", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                override fun onFailure(call: Call<ArrayList<LoginResponse>>, t: Throwable) {
                    Log.e("LoginResponse___", t.toString())
                    loginStatus = t.message.toString()
                    Toast.makeText(cnx, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}