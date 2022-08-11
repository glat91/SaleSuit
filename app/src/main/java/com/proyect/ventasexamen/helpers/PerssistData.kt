package com.proyect.ventasexamen.helpers

import android.content.Context
import android.content.SharedPreferences
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.proyect.ventasexamen.models.sharedPreference.UserPreferences

class PerssistData() {
    companion object{
        const val SHARED_TOKEN = "TOKEN"

        private fun getSecuredPreferences(ctx: Context?): SharedPreferences {
            val keyGenParameterSpec = KeyGenParameterSpec.Builder(
                MasterKey.DEFAULT_MASTER_KEY_ALIAS,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .setKeySize(MasterKey.DEFAULT_AES_GCM_MASTER_KEY_SIZE)
                .build()

            val masterKey = MasterKey.Builder(ctx!!, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                .setKeyGenParameterSpec(keyGenParameterSpec)
                .build()

            return EncryptedSharedPreferences
                .create(
                    ctx,
                    "auth.txt",
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                )
        }
        fun saveModel(id: Int, user: String, nombre: String, dateRegistro: String, correo: String, password: String, cntx: Context){
            val perssistDataModel = UserPreferences(id, user, nombre, dateRegistro, correo, password)
            val s = AuthSharedPreference.getSecuredPreferences(cntx).edit()
            s.putString(SHARED_TOKEN, perssistDataModel.toString())
            s.apply()
            //getPerssistDate(cntx)
        }
        fun getPerssistDate(cntx: Context): String?{
            val shared2 = getSecuredPreferences(cntx)
            val data = shared2.getString(SHARED_TOKEN, "")
            Log.e("dat_____", data.toString())
            if (!data.isNullOrBlank()){
                return data
            }
            return null
        }
        fun deletePerssistData(cntx: Context){
            val d = AuthSharedPreference.getSecuredPreferences(cntx).edit().clear()
            d.apply()
        }
    }
}