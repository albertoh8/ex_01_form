package com.alberherjim.androidtraining.features.ex_02c.domain

import com.alberherjim.androidtraining.app.ErrorApp
import com.iesam.kotlintrainning.Either

class GetFilmUseCase(
    private val repository: FilmRepository
) {
    operator fun invoke(): Either<ErrorApp,List<Film>>{
        return repository.getFilm()
    }
}