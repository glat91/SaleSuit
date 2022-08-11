package com.proyect.ventasexamen.apiCall

import com.proyect.ventasexamen.models.graphRv.GraphRv
import com.proyect.ventasexamen.models.inventoryResponse.Product
import com.proyect.ventasexamen.models.loginResponse.LoginResponse
import com.proyect.ventasexamen.models.salesResponse.SaleResponse
import com.proyect.ventasexamen.models.salesRv.SalesRv
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface Services {
    companion object{
        const val LOGIN = "Users.json"
        const val SALES = "SalesRv.json"
        const val INVENTORY = "Products.json"
        const val GRAPH = "GraphRv.json"
    }
    /** Login */
    @GET(LOGIN)
    fun getLogin(): Call<ArrayList<LoginResponse>>

    /** Sales */
    @GET(SALES)
    fun getSales(): Call<ArrayList<SalesRv>>

    @GET(GRAPH)
    fun getGrap(): Call<ArrayList<GraphRv>>
    /*
    @PUT(INVENTORY)
    fun putSale(@Field("img") img: String,
                @Field("pedidos") pedidos: Int,
                @Field("precio") precio: Double,
                @Field("title") title: String,
                @Field("vendidos") vendidos: Int): Call<SaleResponse>
    */
    /** Products */
    @POST(INVENTORY)
    fun getInventory(): Call<ArrayList<Product>>
}