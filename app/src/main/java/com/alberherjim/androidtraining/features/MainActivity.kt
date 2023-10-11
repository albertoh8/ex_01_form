package com.alberherjim.androidtraining.features

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.alberherjim.androidtraining.R
import com.alberherjim.androidtraining.features.ex_01.presentation.Ex01FormActivity
import com.alberherjim.androidtraining.features.ex_02a.presentation.Ex02ActivityMain
import com.alberherjim.androidtraining.features.ex_02b.presentation.EX02bMainActivity
import com.alberherjim.androidtraining.features.ex_02c.presentation.EX02cMainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView(){
        findViewById<Button>(R.id.action_ex01_form).setOnClickListener {
            startActivity(Intent(this, Ex01FormActivity::class.java))
        }
        findViewById<Button>(R.id.action_ex02a).setOnClickListener {
            startActivity(Intent(this, Ex02ActivityMain::class.java))
        }
        findViewById<Button>(R.id.action_ex02b).setOnClickListener {
            startActivity(Intent(this, EX02bMainActivity::class.java))
        }
        findViewById<Button>(R.id.action_ex02c).setOnClickListener {
            startActivity(Intent(this, EX02cMainActivity::class.java))
        }
    }
}