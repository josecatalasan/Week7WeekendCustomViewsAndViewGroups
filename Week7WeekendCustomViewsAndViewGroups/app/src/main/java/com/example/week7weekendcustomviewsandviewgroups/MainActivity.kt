package com.example.week7weekendcustomviewsandviewgroups

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    1. Create a custom view by extending a View Class
//          -seed of life view, confetti view, firework view
//    2. Create a custom view by extending a AndroidView(Button/Textview) class
//          -dropdown button, custom font textview, color changing text
//    3. Create a custom layout by extending the layout class (should have at least 4 children)
//          -music player view, image manipulator, birthday query view
//
//    - Add more functionality to the custom views
//
//    - Add setters and getters to the views to set/get values in the Activities

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var colorNumber = 1
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
