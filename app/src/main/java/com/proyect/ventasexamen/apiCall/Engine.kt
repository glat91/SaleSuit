package com.proyect.ventasexamen.apiCall

import android.content.Context
import com.google.gson.GsonBuilder
import com.proyect.ventasexamen.helpers.PerssistData
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object Engine {
    private val baseUrl = "https://salesuit-ff2cd-default-rtdb.firebaseio.com/"
    private const val TIME_OUT: Long = 3000

    fun getEngine(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        val client = OkHttpClient.Builder()
            .callTimeout(TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
        return retrofit
    }
}