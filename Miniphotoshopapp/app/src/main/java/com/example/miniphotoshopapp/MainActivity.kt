package com.example.miniphotoshopapp

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var ibZoomin: ImageButton
    lateinit var ibZoomout: ImageButton
    lateinit var ibRotate: ImageButton
    lateinit var ibEnhance: ImageButton
    lateinit var ibReduce: ImageButton
    lateinit var ibBw: ImageButton
    lateinit var graphicView: MyGraphicView

    companion object {
        var sX = 1f
        var sY = 1f
        var angle = 0f
        var color = 1f
        var satur = 1f
        var blur = false
        var embos = false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Simple edit app"

        var pictureLayout = findViewById<LinearLayout>(R.id.pictureLayout)
        graphicView = MyGraphicView(this)
        pictureLayout.addView(graphicView)

        clickIcons()
    }

    class MyGraphicView(context: Context) : View(context) {
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            var picture = BitmapFactory.decodeResource(resources, R.drawable.cheese)
            var picX = (this.width - picture.width) / 2f
            var picY = (this.height - picture.height) / 2f
            var cenX = this.width /2f
            var cenY = this.height /2f

            canvas.scale(sX, sY, cenX, cenY)
            canvas.rotate(angle, cenX, cenY)
            val paint = Paint()
            val array = floatArrayOf(color, 0f, 0f, 0f, 0f,
                                        0f, color, 0f, 0f, 0f,
                                        0f, 0f, color, 0f, 0f,
                                        0f, 0f, 0f, 1f, 0f)
            val cm = ColorMatrix(array)
            paint.colorFilter = ColorMatrixColorFilter(cm)
            canvas.drawBitmap(picture, picX, picY, paint)
            if (satur == 0f) cm.setSaturation(satur)
        }
    }

    private fun clickIcons() {
        ibZoomin = findViewById<ImageButton>(R.id.ibZoomin)
        ibZoomin.setOnClickListener{
            sX = sX + 0.2f
            sY = sY + 0.2f
            graphicView.invalidate()
        }
        ibZoomout = findViewById<ImageButton>(R.id.ibZoomout)
        ibZoomout.setOnClickListener{
            sX = sX - 0.2f
            sY = sY - 0.2f
            graphicView.invalidate()
        }
        ibRotate = findViewById<View>(R.id.ibRotate) as ImageButton
        ibRotate.setOnClickListener {
            angle = angle +20
            graphicView.invalidate()
        }
        ibEnhance = findViewById<View>(R.id.ibEnhance) as ImageButton
        ibEnhance.setOnClickListener {
            color = color + 0.2f
            graphicView.invalidate()
        }
        ibReduce = findViewById<View>(R.id.ibReduce) as ImageButton
        ibReduce.setOnClickListener {
            color = color - 0.2f
            graphicView.invalidate()
        }
        ibBw = findViewById<ImageButton>(R.id.ibBw)
        ibBw.setOnClickListener {
            if(satur == 0f)
                satur = 1f
            else
                satur = 0f
            graphicView.invalidate()
        }
    }
}