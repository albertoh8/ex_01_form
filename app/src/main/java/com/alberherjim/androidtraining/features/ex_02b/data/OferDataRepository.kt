package com.alberherjim.androidtraining.features.ex_02b.data

import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.features.ex_02a.data.local.XmlLocalDataSource
import com.alberherjim.androidtraining.features.ex_02b.data.remote.MockOferRemoteDataSource
import com.alberherjim.androidtraining.features.ex_02b.domain.Ofer
import com.alberherjim.androidtraining.features.ex_02b.domain.OferRepository
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.right

class OferDataRepository(
    private val localSource: com.alberherjim.androidtraining.features.ex_02b.data.local.XmlLocalDataSource,
    private val remoteSource: MockOferRemoteDataSource
)  : OferRepository {
    override fun getOfer(): Either<ErrorApp, Ofer> {
        return remoteSource.getOfer().right()
    }
}