package com.proyect.ventasexamen.models.inventoryResponse

data class Products(
    val id: Int,
    val name: String,
    val brand: String,
    val model: String,
    val image: String,
    val stock: Int,
    val exsistencia: Boolean
)
