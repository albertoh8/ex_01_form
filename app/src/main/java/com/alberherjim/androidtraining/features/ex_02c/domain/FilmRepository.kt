package com.alberherjim.androidtraining.features.ex_02c.domain

import com.alberherjim.androidtraining.app.ErrorApp
import com.iesam.kotlintrainning.Either

interface FilmRepository {

    fun getFilm():Either<ErrorApp, List<Film>>
}