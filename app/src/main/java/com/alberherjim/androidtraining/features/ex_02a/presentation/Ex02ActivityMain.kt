package com.alberherjim.androidtraining.features.ex_02a.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.alberherjim.androidtraining.R
import com.alberherjim.androidtraining.app.ErrorApp
import com.alberherjim.androidtraining.app.extensions.hide
import com.alberherjim.androidtraining.app.extensions.visible
import com.alberherjim.androidtraining.databinding.ActivityGlovoBinding
import com.alberherjim.androidtraining.databinding.ActivityHuellasBinding
import com.alberherjim.androidtraining.features.ex_02a.data.DogDataRepository
import com.alberherjim.androidtraining.features.ex_02a.data.local.XmlLocalDataSource
import com.alberherjim.androidtraining.features.ex_02a.data.remote.MockDogRemoteDataSource
import com.alberherjim.androidtraining.features.ex_02a.domain.Dog
import com.alberherjim.androidtraining.features.ex_02a.domain.GetDogUseCase
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat

class Ex02ActivityMain : AppCompatActivity() {

    val viewModel: Ex02ActivityViewModel by lazy {
        Ex02ActivityViewModel(
            GetDogUseCase(DogDataRepository(XmlLocalDataSource(this), MockDogRemoteDataSource()))
        )
    }

    lateinit var viewBinding : ActivityHuellasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView()
        setupObservers()
        setupView()
        showError(ErrorApp.UnknowwError)

    }



    private fun bindView() {
        viewBinding = ActivityHuellasBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)
    }

    fun setupView() {

    }

    private fun setupObservers() {
        viewModel.getDog()
        val observer = Observer<Ex02ActivityViewModel.UiState> {
            it.errorApp?.let {
                showError(it)
            }
            it.dog?.apply {
                bindData(this)
                showView()
            }
        }
        viewModel.uiState.observe(this, observer)
    }

    
    private fun showError(error:ErrorApp) {
        viewBinding.layoutError.layoutError.visible()
        when(error){
            ErrorApp.UnknowwError -> viewBinding.layoutWihtoutError.hide()
        }
    }

    private fun showView() {
        viewBinding.layoutError.layoutError.hide()
        viewBinding.layoutWihtoutError.visible()
    }


    private fun bindData(dog: Dog) {
        val date = dog.dateBorn
        val dateFormated = SimpleDateFormat("dd/MM/yyyy").format(date)
        viewBinding.apply {
            dogName.text = dog.name
            description.text = (dog.description)
            female.text = (dog.genre)
            birthday.text = (dateFormated)
        }


    }
}