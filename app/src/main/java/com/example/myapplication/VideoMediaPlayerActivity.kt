package com.example.myapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video_media_player.*

class VideoMediaPlayerActivity : AppCompatActivity() {

    private var uri: Uri? = null
    private var isContinuosly = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_media_player)

        // construtor que devolve controles de media do video inserido
        val mediaController = MediaController(this)

        // define qual componente receberá a mídia
        mediaController.setAnchorView(vv)

        val uriPath = "https://archive.org/download/WildlifeSampleVideo/Wildlife.mp4"

        uri = Uri.parse(uriPath)

        // listener que observa quando vídeo completa, se o isConstinuosly é true, o vídeo fica em looping
        vv!!.setOnCompletionListener {
            if (isContinuosly) {
                vv!!.start()
            }
        }

        // botão pausar
        btnStop!!.setOnClickListener { vv!!.pause() }

        // botão play
        btnPlay!!.setOnClickListener { vv!!.start() }

        // botão que pausa o loop do vídeo
        btnOnce!!.setOnClickListener {
            isContinuosly = false
            // deixa a barra de progresso visível
            progress!!.visibility = View.VISIBLE
            // define o media controller da VideoView
            vv!!.setMediaController(mediaController)
            // define a uri do video
            vv!!.setVideoURI(uri)
            // da foco no VideoView
            vv!!.requestFocus()
            // play no vídeo
            vv!!.start()
        }

        // inicia o vídeo em loop
        btnConti!!.setOnClickListener {
            isContinuosly = true
            progress!!.visibility = View.VISIBLE
            vv!!.setMediaController(mediaController)
            vv!!.setVideoURI(uri)
            vv!!.requestFocus()
            vv!!.start()
        }

        // listener para disparar um evento quando o vídeo está pronto para ser reproduzido
        vv!!.setOnPreparedListener { progress!!.visibility = View.VISIBLE }
    }
}