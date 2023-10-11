package com.alberherjim.androidtraining.features.ex_02a.domain

import com.alberherjim.androidtraining.app.ErrorApp
import com.iesam.kotlintrainning.Either

class GetDogUseCase(
    private val repository: DogRepository
){
    operator fun invoke(): Either<ErrorApp, Dog> {
        return repository.getDog()
    }
}