package com.alberherjim.androidtraining.domain

import com.alberherjim.androidtraining.app.ErrorApp
import com.iesam.kotlintrainning.Either

interface UserRepository {

    fun save(user:User) : Either<ErrorApp, Boolean>

    fun get(name:String): Either<ErrorApp,User>

    fun getAll(): Either<ErrorApp,List<User>>

}