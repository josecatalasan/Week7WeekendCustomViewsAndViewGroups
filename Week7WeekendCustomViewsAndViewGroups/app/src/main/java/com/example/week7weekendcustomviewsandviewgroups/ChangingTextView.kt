package com.example.week7weekendcustomviewsandviewgroups

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi

class ChangingTextView : TextView, View.OnClickListener, View.OnLongClickListener {

    private var stylePicker = -1
    private val styles = arrayOf(Typeface.BOLD, Typeface.ITALIC, Typeface.BOLD_ITALIC, Typeface.NORMAL)
    private var colorPicker = -1
    var colors = arrayListOf(Color.BLACK,Color.BLUE,Color.CYAN,Color.GREEN,Color.MAGENTA,Color.RED,Color.YELLOW, currentTextColor)

    constructor(context: Context?):this(context, null)

    constructor(context: Context?, attrs: AttributeSet?):this(context,attrs,0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int):super(context,attrs,defStyleAttr){
        //val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.FruitOfLifeView)
        //typedArray?.recycle()
        setOnClickListener(this)
        setOnLongClickListener(this)

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context,attrs,defStyleAttr,defStyleRes)

    override fun onClick(view: View?) {
        colorPicker = (colorPicker + 1) % colors.size
        setTextColor(colors[colorPicker])
    }

    override fun onLongClick(view: View?): Boolean {
        stylePicker = (stylePicker+1) % styles.size
        typeface = Typeface.create(typeface, styles[stylePicker])
        return true
    }
}