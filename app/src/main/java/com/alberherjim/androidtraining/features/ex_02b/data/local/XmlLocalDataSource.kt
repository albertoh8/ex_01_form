package com.alberherjim.androidtraining.features.ex_02b.data.local

import android.content.Context
import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.features.ex_02a.domain.Dog
import com.alberherjim.androidtraining.features.ex_02b.domain.Ofer
import com.google.gson.Gson
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.right

class XmlLocalDataSource (
    private val context: Context

) {
    private val sharedPreferences = context.getSharedPreferences("Ofers", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()
    private val gson = Gson()

    fun getOfer(): Either<ErrorApp, Ofer> {
        val jsonOfer = sharedPreferences.getString("", null)
        val ofer = jsonOfer.let {
            gson.fromJson(jsonOfer, Ofer::class.java)
        }
        return ofer.right()
    }
}