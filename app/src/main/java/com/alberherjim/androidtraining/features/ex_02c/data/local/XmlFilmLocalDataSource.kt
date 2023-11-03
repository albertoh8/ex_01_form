package com.alberherjim.androidtraining.features.ex_02c.data.local

import android.content.Context
import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.features.ex_02c.domain.Film
import com.google.gson.Gson
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.right

class XmlFilmLocalDataSource(
    private val context: Context

) {
    private val sharedPreferences = context.getSharedPreferences("Films", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()
    private val gson = Gson()

    fun getFil(): Either<ErrorApp, Film> {
        val jsonFilm = sharedPreferences.getString("", null)
        val film = jsonFilm.let {
            gson.fromJson(jsonFilm, Film::class.java)
        }
        return film.right()
    }
}
