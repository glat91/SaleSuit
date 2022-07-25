package com.proyect.ventasexamen.models.loginResponse

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("contraseña"    ) var contraseña    : String,
    @SerializedName("correo"        ) var correo        : String,
    @SerializedName("fechaRegistro" ) var fechaRegistro : String,
    @SerializedName("id"            ) var id            : Int,
    @SerializedName("nombre"        ) var nombre        : String,
    @SerializedName("user"          ) var user          : String
)