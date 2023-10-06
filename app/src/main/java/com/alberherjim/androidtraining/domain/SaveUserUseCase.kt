package com.alberherjim.androidtraining.domain

import com.alberherjim.androidtraining.app.ErrorApp
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.right

class SaveUserUseCase(
    private val repository: UserRepository
) {

    operator fun invoke(user:User): Either<ErrorApp, Boolean> {
        return repository.save(user)
    }

}