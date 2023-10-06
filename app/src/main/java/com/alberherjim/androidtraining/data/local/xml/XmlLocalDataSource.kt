package com.alberherjim.androidtraining.data.local.xml

import android.content.Context
import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.domain.User
import com.google.gson.Gson
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.left
import com.iesam.kotlintrainning.right
import java.lang.Exception

class XmlLocalDataSource(
    private val context: Context

)  {
    private val sharedPreferences = context.getSharedPreferences("Usuarios", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()
    private val gson = Gson()




    fun getUser(name:String): Either<ErrorApp,User> {
        val jsonUser = sharedPreferences.getString(name, null)
        val user = jsonUser.let {
            gson.fromJson(jsonUser, User::class.java)
        }
        return user.right()
    }


//    fun getUsers(): Either<ErrorApp,User> {
//        return try {
//            User(
//                sharedPreferences.getString("name", "")!!,
//                sharedPreferences.getString("surname", "")!!,
//                sharedPreferences.getString("email", "")!!
//            ).right()
//        } catch (ex : Exception) {
//            return ErrorApp.UnknowwError.left()
//        }
//    }

    fun saveUser(user: User): Either<ErrorApp, Boolean> {
        try {
            val jsonSavUser = gson.toJson(user, User::class.java)
            editor.putString(user.name, jsonSavUser)
            editor.apply()

        }catch (ex : Exception) {
            return ErrorApp.UnknowwError.left()
        }
        return true.right()

    }

    fun getAllUsers(): Either<ErrorApp, List<User>> {
        return sharedPreferences.all.map {
            gson.fromJson(it.value as String, User::class.java)
        }.right()

    }
}