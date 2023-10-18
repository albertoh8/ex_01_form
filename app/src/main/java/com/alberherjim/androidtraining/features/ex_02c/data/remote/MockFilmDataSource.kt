package com.alberherjim.androidtraining.features.ex_02c.data.remote

import com.alberherjim.androidtraining.features.ex_02c.domain.Film

class MockFilmDataSource {

    fun getFilm() : List<Film>{
        val films : List<Film> = listOf(
            Film("Jungle Cruise", "1.03GB", "2h 9min"),
            Film("Jungle Cruise", "1.03GB", "2h 9min"),
            Film("Jungle Cruise", "1.03GB", "2h 9min")
        )
        return films
    }
}