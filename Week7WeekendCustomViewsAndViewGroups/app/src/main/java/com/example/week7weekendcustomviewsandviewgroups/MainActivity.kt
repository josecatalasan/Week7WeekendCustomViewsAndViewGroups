package com.example.week7weekendcustomviewsandviewgroups

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ctvOne.colors = arrayListOf(Color.DKGRAY, Color.LTGRAY, ctvOne.currentTextColor)

        mediaPlayerView.media = R.raw.arurian_dance
    }

    var colorNumber = -1
    fun onClick(view: View) {
        colorNumber++
        when(colorNumber%4) {
            0->viewOfLife.color = Color.MAGENTA
            1->viewOfLife.color = Color.CYAN
            2->viewOfLife.color = Color.GREEN
            3->viewOfLife.color = Color.BLACK
        }
    }
}
