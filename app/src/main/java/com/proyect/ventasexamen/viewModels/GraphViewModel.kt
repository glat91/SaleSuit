package com.proyect.ventasexamen.viewModels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyect.ventasexamen.apiCall.Engine
import com.proyect.ventasexamen.apiCall.Services
import com.proyect.ventasexamen.models.graphRv.GraphRv
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class GraphViewModel: ViewModel() {
    private val _graph = MutableLiveData<ArrayList<GraphRv>>()
    val graph = _graph

    fun getSales(){
        val array = arrayListOf<GraphRv>()
        array.add(GraphRv("06", "Julio", "50000.00"))
        array.add(GraphRv("06", "Julio", "50000.00"))
        array.add(GraphRv("06", "Julio", "50000.00"))
        array.add(GraphRv("06", "Julio", "50000.00"))
        array.add(GraphRv("06", "Julio", "50000.00"))
        array.add(GraphRv("06", "Julio", "50000.00"))
        array.add(GraphRv("06", "Julio", "50000.00"))
        _graph.value = array
    }

    fun getSalesApi(cnx: Context){
        viewModelScope.launch{
            val engine = Engine.getEngine().create<Services>()
            engine.getGrap().enqueue(object: Callback<ArrayList<GraphRv>>{
                override fun onResponse(call: Call<ArrayList<GraphRv>>, response: Response<ArrayList<GraphRv>>) {
                    if(response.isSuccessful){
                        when(response.code()){
                            200-> {
                                _graph.value = response.body()
                                Log.d("Graph____", response.body().toString())
                            }
                            else->{
                                Toast.makeText(cnx, "Error en el servidor", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ArrayList<GraphRv>>, t: Throwable) {
                    Toast.makeText(cnx, "Error en el servidor", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}