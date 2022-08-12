package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnImagens.setOnClickListener(View.OnClickListener {
            // instanciar a activity para fazer navegação para ela
            val intent = Intent(this, RecuperaFotosActivity::class.java)
            startActivity(intent)
        })
    }
}