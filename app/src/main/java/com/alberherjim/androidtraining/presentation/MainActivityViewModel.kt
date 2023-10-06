package com.alberherjim.androidtraining.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.domain.DeleteUsersUseCase
import com.alberherjim.androidtraining.domain.GetUserUseCase
import com.alberherjim.androidtraining.domain.SaveUserUseCase
import com.alberherjim.androidtraining.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import perfetto.protos.UiState

class MainActivityViewModel(
    private val saveUsers: SaveUserUseCase,
    private val getUser: GetUserUseCase,
    private val deleteUsers : DeleteUsersUseCase
): ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState


    fun saveUser(user: User){
        viewModelScope.launch {
            saveUsers.invoke(user).fold(
                { responseError(it) },
                { responseSuccess(it) }
            )
        }
    }
    fun getUser(name:String)  {
        viewModelScope.launch(Dispatchers.IO) {
            getUser.invoke(name).fold(
                { responseError(it)},
                { responseGetUserSuccess(it)}
            )
        }
    }

    fun deleteUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            deleteUsers.invoke()
        }
    }

    private fun responseError(errorApp: ErrorApp) {}
    private fun responseGetUserSuccess(user: User) {
        _uiState.postValue(UiState(user = user))
    }
    private fun responseSuccess(isOk: Boolean) {}
    data class UiState(
        val errorApp: ErrorApp? = null,
        val isLoading: Boolean = false,
        val user: User? = null
    )


}