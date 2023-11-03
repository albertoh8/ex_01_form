package com.alberherjim.androidtraining.features.ex_02c.data

import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.features.ex_02c.data.local.XmlFilmLocalDataSource
import com.alberherjim.androidtraining.features.ex_02c.data.remote.MockFilmDataSource
import com.alberherjim.androidtraining.features.ex_02c.domain.Film
import com.alberherjim.androidtraining.features.ex_02c.domain.FilmRepository
import com.iesam.kotlintrainning.Either
import com.iesam.kotlintrainning.right

class FilmDataRepository(
    private val localSource : XmlFilmLocalDataSource,
    private val remoteSource: MockFilmDataSource

) : FilmRepository {
    override fun getFilm(): Either<ErrorApp, List<Film>> {
        return remoteSource.getFilm().right()
    }
}