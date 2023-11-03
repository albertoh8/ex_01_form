package com.alberherjim.androidtraining.features.ex_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alberherjim.androidtraining.R
import com.alberherjim.androidtraining.app.extensions.setUrl
import com.alberherjim.androidtraining.databinding.ActivityEx03GlideBinding
import com.bumptech.glide.Glide

class Ex03GlideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEx03GlideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupView()
    }

    private fun setupBinding() {
        binding = ActivityEx03GlideBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupView() {
        binding.let {
            it.imageUrl.setUrl("https://img.freepik.com/vector-gratis/ilustracion-silueta-perro-gato-diseno-plano_23-2150369485.jpg?w=740&t=st=1697553774~exp=1697554374~hmac=9c79dbae3e37cb83e92f68ba1bb186b2e6a67432edc00becfed4b53aea37182c")
            it.image.setUrl("https://img.freepik.com/foto-gratis/genial-figura-triangular-geometrica-luz-laser-neon-ideal-fondos-fondos-pantalla_181624-9331.jpg?w=1060&t=st=1697553644~exp=1697554244~hmac=0a30727215801ec13468edaa4ed4fecbaa5810853879cc590f46aa4ae8a55bf6")
        }
    }
}