package com.proyect.ventasexamen.viewModels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyect.ventasexamen.apiCall.Engine
import com.proyect.ventasexamen.apiCall.Services
import com.proyect.ventasexamen.models.salesRv.SalesRv
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class SalesViewModel: ViewModel() {
    private val _sales = MutableLiveData<ArrayList<SalesRv>>()
    val sales = _sales

    fun getSales(){
        val array = arrayListOf<SalesRv>()
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        array.add(SalesRv("Samsung TV 59", 20, 35, 50000.00,"https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", ))
        _sales.value = array
    }

    fun getSalesApi(cnx: Context){
        viewModelScope.launch{
            val engine = Engine.getEngine().create<Services>()
            engine.getSales().enqueue(object: Callback<ArrayList<SalesRv>> {
                override fun onResponse(call: Call<ArrayList<SalesRv>>, response: Response<ArrayList<SalesRv>>) {
                    if(response.isSuccessful){
                        when(response.code()){
                            200-> {
                                _sales.value = response.body()
                                Log.d("Sales____", response.body().toString())
                            }
                            else->{
                                Toast.makeText(cnx, "Error en el servidor", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
                override fun onFailure(call: Call<ArrayList<SalesRv>>, t: Throwable) {
                    Toast.makeText(cnx, "Error en el servidor", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}