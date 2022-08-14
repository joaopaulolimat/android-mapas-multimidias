package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {
    internal var animations = arrayOf(
        "Fade In",
        "Fade Out",
        "Zoom In",
        "Zoom Out",
        "Blink",
        "Rotate",
        "Move",
        "Slide Up",
        "Slide Down",
        "Bounce"
    )

    internal var animationIDs = intArrayOf(
        R.anim.fade_in,
        R.anim.fade_out,
        R.anim.zoom_in,
        R.anim.zoom_out,
        R.anim.blink,
        R.anim.rotate,
        R.anim.move,
        R.anim.slide_up,
        R.anim.slide_down,
        R.anim.bounce
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        // colocar itens na lista
        lv.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, animations)

        // ação de clique dentro dos itens da lista
        lv.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // transformar os XML em Animation, pega a animationIDs de cada item da posição
            val animation = AnimationUtils.loadAnimation(this, animationIDs[position])
            // executa a animação
            tv.startAnimation(animation)
        }
    }
}