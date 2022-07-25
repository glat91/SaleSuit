package com.proyect.ventasexamen.models.sharedPreference

data class UserPreferences(
    val userId: Int,
    val user: String,
    val nombre: String,
    val dateRegistro: String,
    val correo: String,
    val password: String
)
