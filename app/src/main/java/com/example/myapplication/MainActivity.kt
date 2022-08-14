package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // adicionar ação no evento de click no botão
        btnImagens.setOnClickListener {
            // instanciar a activity para fazer navegação para ela
            val intent = Intent(this, RecuperaFotosActivity::class.java)
            startActivity(intent)
        }

        btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        btnAudio.setOnClickListener {
            val intent = Intent(this, AudioActivity::class.java)
            startActivity(intent)
        }

        btnVideo.setOnClickListener {
            val intent = Intent(this, VideoMediaPlayerActivity::class.java)
            startActivity(intent)
        }

        btnAnimation.setOnClickListener {
            val intent = Intent(this, AnimationActivity::class.java)
            startActivity(intent)
        }
    }
}