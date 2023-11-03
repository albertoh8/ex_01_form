package com.alberherjim.androidtraining.features.ex_01.domain

import com.alberherjim.androidtraining.app.ErrorApp
import com.iesam.kotlintrainning.Either

interface UserRepository {

    fun save(user: User) : Either<ErrorApp, Boolean>

    fun get(name:String): Either<ErrorApp, User>

    fun getAll(): Either<ErrorApp,List<User>>

    fun delete(): Either<ErrorApp,Boolean>

}