package com.proyect.ventasexamen.apiCall

import com.proyect.ventasexamen.models.ApiResponse
import com.proyect.ventasexamen.models.loginResponse.LoginResponse
import retrofit2.Call
import retrofit2.http.GET

interface Services {
    companion object{
        const val LOGIN = "Users.json"
        const val SALES = "Sales.json"
    }
    /** Login */
    @GET(LOGIN)
    fun getLogin(): Call<ArrayList<LoginResponse>>

    /** Sales */
    @GET(SALES)
    fun getSales(): Call<ArrayList<ApiResponse>>
}