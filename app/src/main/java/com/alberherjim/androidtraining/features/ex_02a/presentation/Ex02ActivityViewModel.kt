package com.alberherjim.androidtraining.features.ex_02a.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.features.ex_02a.domain.Dog
import com.alberherjim.androidtraining.features.ex_02a.domain.GetDogUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ex02ActivityViewModel(
    private val getDog : GetDogUseCase
) : ViewModel(){
    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun getDog(){
        viewModelScope.launch(Dispatchers.IO) {
            getDog.invoke().fold(
                {responseError(it)},
                {responseGetDogSucess(it)}
            )
        }
    }

    private fun responseError(errorApp: ErrorApp) {
        _uiState.postValue((UiState(errorApp)))
    }

    private fun responseGetDogSucess(dog: Dog){
        _uiState.postValue(UiState(dog = dog))
    }

    data class UiState(
        val errorApp: ErrorApp? = null,
        val isLoading: Boolean = false,
        val dog: Dog? = null
    )
}