package com.alberherjim.androidtraining.data

import android.content.SharedPreferences
import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.data.local.xml.XmlLocalDataSource
import com.alberherjim.androidtraining.domain.User
import com.alberherjim.androidtraining.domain.UserRepository
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.right

class UserDataRepository(
    val localSource : XmlLocalDataSource
) : UserRepository {

    override fun save(user: User): Either<ErrorApp, Boolean> {
        return localSource.saveUser(user)
    }

    override fun get(name:String): Either<ErrorApp, User> {
        return localSource.getUser(name)
    }

    override fun getAll(): Either<ErrorApp, List<User>> {
        return localSource.getAllUsers()
    }

    override fun delete(): Either<ErrorApp, Boolean> {
        return localSource.delete()
    }


}