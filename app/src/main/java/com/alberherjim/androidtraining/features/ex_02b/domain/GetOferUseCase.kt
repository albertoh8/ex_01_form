package com.alberherjim.androidtraining.features.ex_02b.domain

import com.alberherjim.androidtraining.app.ErrorApp
import com.iesam.kotlintrainning.Either

class GetOferUseCase(
    private val repository: OferRepository
){
    operator fun invoke(): Either<ErrorApp, Ofer> {
        return repository.getOfer()
    }

}