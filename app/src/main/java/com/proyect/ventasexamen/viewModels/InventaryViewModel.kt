package com.proyect.ventasexamen.viewModels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyect.ventasexamen.apiCall.Engine
import com.proyect.ventasexamen.apiCall.Services
import com.proyect.ventasexamen.models.inventoryResponse.Product
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class InventaryViewModel: ViewModel() {

    private var _inventoryResponse = MutableLiveData<ArrayList<Product>>()
    var inventory = _inventoryResponse

    fun getInventary(){
        val array = arrayListOf<Product>()
        array.add(Product(1, "Samsung TV 59", "Samsung", "ADGFDF34343", "https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", 10, true))
        array.add(Product(2, "Samsung TV 59", "Samsung", "ADGFDF34343", "https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", 10, true))
        array.add(Product(3, "Samsung TV 59", "Samsung", "ADGFDF34343", "https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", 10, true))
        array.add(Product(4, "Samsung TV 59", "Samsung", "ADGFDF34343", "https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", 10, true))
        array.add(Product(5, "Samsung TV 59", "Samsung", "ADGFDF34343", "https://m.media-amazon.com/images/I/511EQgOXQBL._AC_SX355_.jpg", 10, true))
        _inventoryResponse.value = array
    }
    fun getSalesApi(cnx: Context){
        viewModelScope.launch{
            val engine = Engine.getEngine().create<Services>()
            engine.getInventory().enqueue(object: Callback<ArrayList<Product>> {
                override fun onResponse(call: Call<ArrayList<Product>>, response: Response<ArrayList<Product>>) {
                    if(response.isSuccessful){
                        when(response.code()){
                            200-> {
                                _inventoryResponse.value = response.body()
                                Log.d("Inventary____", response.body().toString())
                            }
                            else->{
                                Toast.makeText(cnx, "Error en el servidor", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
                override fun onFailure(call: Call<ArrayList<Product>>, t: Throwable) {
                    Toast.makeText(cnx, "Error en el servidor", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}