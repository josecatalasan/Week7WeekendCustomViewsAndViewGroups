package com.example.week7weekendcustomviewsandviewgroups

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class FruitOfLifeView : View {

    var radius : Int = 0
        set(value) {
            field = value
            invalidate()
        }
    var color : Int = 0
        set(value) {
            field = value
            invalidate()
        }
    var xPosition : Int = 0
        set(value) {
            field = value
            invalidate()
        }
    var yPosition : Int = 0
        set(value) {
            field = value
            invalidate()
        }
    var lineWidth : Int = 0
        set(value) {
            field = value
            invalidate()
        }

    private val paint = Paint()

    constructor(context: Context):this(context, null)

    constructor(context: Context, attrs: AttributeSet?):this(context,attrs,0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int):super(context,attrs,defStyleAttr){
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.FruitOfLifeView)
        radius = typedArray.getInt(R.styleable.FruitOfLifeView_radius, 100)
        color = typedArray.getInt(R.styleable.FruitOfLifeView_fruitColor, Color.BLACK)
        xPosition = typedArray.getInt(R.styleable.FruitOfLifeView_xPosition, 500)
        yPosition = typedArray.getInt(R.styleable.FruitOfLifeView_yPosition, 500)
        lineWidth = typedArray.getInt(R.styleable.FruitOfLifeView_lineWidth, 10)
        typedArray.recycle()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context,attrs,defStyleAttr,defStyleRes)

    override fun onDraw(canvas: Canvas?) {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = lineWidth.toFloat()
        paint.color = color

        if(radius > 500){
            radius = 500
        }

        //draw all the circles
        drawFruitOfLife(canvas, xPosition.toFloat(), yPosition.toFloat(), radius.toFloat(), paint)
        super.onDraw(canvas)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    private fun drawFruitOfLife(canvas: Canvas?, x : Float, y : Float, r : Float, p : Paint){
        val radian = (PI / 180).toFloat()
        val cos = cos(330f*radian)*r
        val sin = sin(330f*radian)*r

        //center
        drawColumn(canvas, x, y-2*r, r, p, 5)
        //right mid column
        drawColumn(canvas, x+cos, y+sin-r, r, p, 4)
        //right column
        drawColumn(canvas, x+2*cos, y+2*sin, r, p, 3)
        //left mid column
        drawColumn(canvas, x-cos, y-sin-2*r, r, p, 4)
        //left column
        drawColumn(canvas, x-2*cos, y-2*sin-2*r, r, p, 3)

    }

    private fun drawColumn(canvas: Canvas?, x : Float, y : Float, r : Float, p : Paint, count : Int){
        for(i in 0 until count){
            canvas?.drawCircle(x, y + i*r, r, p)
        }
    }

}