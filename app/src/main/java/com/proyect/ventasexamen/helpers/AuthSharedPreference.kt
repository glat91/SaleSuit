package com.proyect.ventasexamen.helpers

import android.content.Context
import android.content.SharedPreferences
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.preference.PreferenceManager
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class AuthSharedPreference {

    companion object {
        val PREF_USER_NAME = "username"

        /**
         * Obtiene la instancia de SharedPreferences.
         */
        private fun getSharedPreferences(ctx: Context?): SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(ctx)
        }

        /**
         * Obtiene la instancia de SecuredPreferences.
         */
        fun getSecuredPreferences(ctx: Context?): SharedPreferences {
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
                    ctx!!,
                    "auth.txt",
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                )
        }

        /**
         * Guarda una llave/valor en SharedPreferences.
         */
        private fun saveSharedValue(key: String, value: String?, ctx: Context?) {
            val editor = getSharedPreferences(ctx).edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

}