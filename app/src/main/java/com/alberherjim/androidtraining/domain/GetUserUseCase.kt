package com.alberherjim.androidtraining.domain

import com.alberherjim.androidtraining.app.ErrorApp
import com.iesam.kotlintrainning.Either

class GetUserUseCase (
    private val repository: UserRepository
){
    operator fun invoke(name:String): Either<ErrorApp, User> {
        return repository.get(name)
    }
}