package com.alberherjim.androidtraining.features.ex_02b.data.remote

import com.alberherjim.androidtraining.features.ex_02b.domain.Ofer

class MockOferRemoteDataSource {

    fun getOfer(): Ofer {
        return Ofer("Burguer it", "98%","20-30min","15%")
    }
}