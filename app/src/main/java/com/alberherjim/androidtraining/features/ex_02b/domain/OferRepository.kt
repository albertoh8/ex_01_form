package com.alberherjim.androidtraining.features.ex_02b.domain

import com.alberherjim.androidtraining.app.ErrorApp
import com.iesam.kotlintrainning.Either

interface OferRepository {

    fun getOfer(): Either<ErrorApp,Ofer>
}