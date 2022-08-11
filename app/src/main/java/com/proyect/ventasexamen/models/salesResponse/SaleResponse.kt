package com.proyect.ventasexamen.models.salesResponse

import com.google.gson.annotations.SerializedName

data class SaleResponse(
    @SerializedName("img") var img: String,
    @SerializedName("pedidos") var pedidos: Int,
    @SerializedName("precio") var precio: Double,
    @SerializedName("title") var title: String,
    @SerializedName("vendidos") var vendidos: Int)
