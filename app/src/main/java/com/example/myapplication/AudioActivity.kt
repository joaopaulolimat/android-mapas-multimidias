package com.example.myapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AudioActivity : AppCompatActivity() {

    // inicializando variável para evitar null pointer
    var cow: MediaPlayer? = null
    var dog: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        // instancia os áudios no MediaPlayer
        cow = MediaPlayer.create(this, R.raw.vaca)
        dog = MediaPlayer.create(this, R.raw.cachorro)
    }

    // função para executar os sons
    fun soundCow(view: View) {
        if(dog != null){
            // pausa um para dar play de outro
            dog!!.stop()
        }
        cow!!.start()
    }

    fun soundDog(view: View) {
        if(cow != null){
            cow!!.stop()
        }
        dog!!.start()
    }
}