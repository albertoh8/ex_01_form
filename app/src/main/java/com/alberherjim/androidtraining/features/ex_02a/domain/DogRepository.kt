package com.alberherjim.androidtraining.features.ex_02a.domain

import com.alberherjim.androidtraining.app.ErrorApp
import com.iesam.kotlintrainning.Either

interface DogRepository {
    fun getDog(): Either<ErrorApp, Dog>
}