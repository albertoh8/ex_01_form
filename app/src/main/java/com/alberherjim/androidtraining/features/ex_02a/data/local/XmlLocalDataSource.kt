package com.alberherjim.androidtraining.features.ex_02a.data.local

import android.content.Context
import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.features.ex_02a.domain.Dog
import com.google.gson.Gson
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.right

class XmlLocalDataSource(
    private val context: Context

) {
    private val sharedPreferences = context.getSharedPreferences("Dogs", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()
    private val gson = Gson()

    fun getDog(): Either<ErrorApp, Dog> {
        val jsonDog = sharedPreferences.getString("", null)
        val dog = jsonDog.let {
            gson.fromJson(jsonDog, Dog::class.java)
        }
        return dog.right()
    }
}