package com.alberherjim.androidtraining.features.ex_02b.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.alberherjim.androidtraining.R
import com.alberherjim.androidtraining.databinding.ActivityEx02Binding
import com.alberherjim.androidtraining.databinding.ActivityGlovoBinding
import com.alberherjim.androidtraining.features.ex_02b.data.OferDataRepository
import com.alberherjim.androidtraining.features.ex_02b.data.local.XmlLocalDataSource
import com.alberherjim.androidtraining.features.ex_02b.data.remote.MockOferRemoteDataSource
import com.alberherjim.androidtraining.features.ex_02b.domain.GetOferUseCase
import com.alberherjim.androidtraining.features.ex_02b.domain.Ofer
import com.alberherjim.androidtraining.features.ex_02b.domain.OferRepository

class EX02bMainActivity : AppCompatActivity() {
    val viewModel: Ex02bActivityViewModel by lazy {
        Ex02bActivityViewModel(GetOferUseCase(OferDataRepository(XmlLocalDataSource(this),MockOferRemoteDataSource())))
    }

    lateinit var viewBinding : ActivityGlovoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView()
        setupObserver()
        setupView()

    }

    private fun bindView() {
        viewBinding = ActivityGlovoBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)
    }

    private fun setupObserver() {
        viewModel.getOfer()
        val observer = Observer<Ex02bActivityViewModel.UiState> {
            it.ofer?.apply {
                bindData(this)
            }
        }
        viewModel.uiState.observe(this, observer)
    }

    private fun setupView() {}

    private fun bindData(ofer: Ofer) {
        viewBinding.apply {
            title.text = ofer.title
            discount.text = ofer.discount
            rate.text = ofer.rate
            time.text = ofer.time
        }
    }




}