package com.alberherjim.androidtraining.features.ex_02b.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.features.ex_02a.presentation.Ex02ActivityViewModel
import com.alberherjim.androidtraining.features.ex_02b.domain.GetOferUseCase
import com.alberherjim.androidtraining.features.ex_02b.domain.Ofer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ex02bActivityViewModel(
    private val getOfer: GetOferUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun getOfer() {
        viewModelScope.launch(Dispatchers.IO) {
            getOfer.invoke().fold(
                { responseError(it) },
                { responseSucessGetOfer(it) }
            )
        }
    }


    private fun responseError(errorApp: ErrorApp) {}

    private fun responseSucessGetOfer(ofer: Ofer) {
        _uiState.postValue(UiState(ofer = ofer))
    }

    data class UiState(
        val errorApp: ErrorApp? = null,
        val isLoading: Boolean = false,
        val ofer: Ofer? = null
    )

}