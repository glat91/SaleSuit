package com.proyect.ventasexamen.apiCall

import com.proyect.ventasexamen.models.loginResponse.LoginResponse
import retrofit2.Call
import retrofit2.http.GET

interface Services {
    companion object{
        const val LOGIN = "Users.json"
    }
    /** Login */
    @GET(LOGIN)
    fun getLogin(): Call<ArrayList<LoginResponse>>
}