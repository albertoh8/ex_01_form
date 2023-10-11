package com.alberherjim.androidtraining.features.ex_02a.data

import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.features.ex_02a.data.local.XmlLocalDataSource
import com.alberherjim.androidtraining.features.ex_02a.data.remote.MockDogRemoteDataSource
import com.alberherjim.androidtraining.features.ex_02a.domain.Dog
import com.alberherjim.androidtraining.features.ex_02a.domain.DogRepository
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.right

class DogDataRepository(
    private val localSource: XmlLocalDataSource,
    private val remoteSource: MockDogRemoteDataSource
) : DogRepository {
    override fun getDog(): Either<ErrorApp, Dog> {
        return remoteSource.getDog().get().right()

    }
}