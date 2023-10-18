package com.alberherjim.androidtraining.features.ex_02c.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alberherjim.androidtraining.databinding.ActivityDisneyBinding
import com.alberherjim.androidtraining.features.ex_02c.data.FilmDataRepository
import com.alberherjim.androidtraining.features.ex_02c.data.local.XmlFilmLocalDataSource
import com.alberherjim.androidtraining.features.ex_02c.data.remote.MockFilmDataSource
import com.alberherjim.androidtraining.features.ex_02c.domain.GetFilmUseCase

class EX02cMainActivity : AppCompatActivity() {

    val viewModel : EX02cActivityViewModel by lazy {
        EX02cActivityViewModel(GetFilmUseCase(FilmDataRepository(XmlFilmLocalDataSource(this), MockFilmDataSource())))
    }
    lateinit var binding: ActivityDisneyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView()
        setupVIew()
        setupObserver()
    }
    private fun bindView() {
        binding = ActivityDisneyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setupVIew() {
        TODO("Not yet implemented")
    }

    private fun setupObserver() {
        TODO("Not yet implemented")
    }


}