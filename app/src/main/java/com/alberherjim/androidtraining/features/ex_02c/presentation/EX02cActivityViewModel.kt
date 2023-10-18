package com.alberherjim.androidtraining.features.ex_02c.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.features.ex_02b.presentation.Ex02bActivityViewModel
import com.alberherjim.androidtraining.features.ex_02c.domain.Film
import com.alberherjim.androidtraining.features.ex_02c.domain.GetFilmUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EX02cActivityViewModel(
    private val getFilm : GetFilmUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun getFilms(){
        viewModelScope.launch(Dispatchers.IO){
            getFilm.invoke().fold(
                {responseError(it)},
                {responseSucessGetFilm(it)}
            )
        }
    }

    private fun responseError(errorApp: ErrorApp) {}

    private fun responseSucessGetFilm(film:List<Film>){
        _uiState.postValue(UiState(film = film))
    }

    data class UiState (
        val errorApp: ErrorApp? = null,
        val isLoading: Boolean = false,
        val film :List<Film>? = null
    )


}