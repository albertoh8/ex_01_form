package com.alberherjim.androidtraining.domain

import com.alberherjim.androidtraining.app.ErrorApp
import com.iesam.kotlintrainning.Either

class DeleteUsersUseCase (private val repository: UserRepository
    ){
        operator fun invoke(): Either<ErrorApp, Boolean> {
            return repository.delete()
        }
    }