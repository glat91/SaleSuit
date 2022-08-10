package com.proyect.ventasexamen.models.inventoryResponse

data class Product(
    val id: Int,
    val name: String,
    val brand: String,
    val model: String,
    val image: String,
    val stock: Int,
    val exsistencia: Boolean
)
