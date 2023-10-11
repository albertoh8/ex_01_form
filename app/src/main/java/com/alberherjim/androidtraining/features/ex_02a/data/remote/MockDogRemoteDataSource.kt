package com.alberherjim.androidtraining.features.ex_02a.data.remote

import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.features.ex_02a.domain.Dog
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.right
import java.util.Date

class MockDogRemoteDataSource {

    fun getDog(): Either<ErrorApp, Dog>{
        return Dog("Remi", "Un diamante por pulir", "Hembra", Date()).right()
    }
}