package com.example.imageview

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
    }
    private class MyGraphicView(context: Context) : View(context) {

        override fun onDraw(canvas: Canvas)
        {
            super.onDraw(canvas)
            var picture = BitmapFactory.decodeResource(resources, R.drawable.fluff)
            var picX = (this.width - picture.width) / 2f
            var picY = (this.height - picture.height) / 2f
            canvas.drawBitmap(picture, picX, picY, null)
            picture.recycle()
        }
    }
}