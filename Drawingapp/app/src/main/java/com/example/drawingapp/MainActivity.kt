package com.example.drawingapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View

class MainActivity : AppCompatActivity() {
    companion object {
        const val LINE = 1
        const val CIRCLE = 2
        const val RECT = 3
        var curShape = LINE
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
        title = "간단 그림판"
    }
    private class MyGraphicView(context: Context): View(context) {
        var startX = -1
        var startY = -1
        var stopX = -1
        var stopY = -1
        override fun onTouchEvent(event: MotionEvent?): Boolean {
            when (event!!.action) {
                MotionEvent.ACTION_DOWN -> {
                    startX = event.x.toInt()
                    startY = event.y.toInt()
                }
                MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                    stopX = event.x.toInt()
                    stopY = event.y.toInt()
                    this.invalidate()
                }
            }
            return true
        }
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            val paint = Paint()
            paint.isAntiAlias = true
            paint.strokeWidth = 10f
            paint.style = Paint.Style.FILL
            paint.color = Color.BLUE


            when (curShape) {
                LINE -> canvas.drawLine(startX.toFloat(), startY.toFloat(), stopX.toFloat(), stopY.toFloat(), paint)
                CIRCLE -> {
                    var radius = Math.sqrt(Math.pow((stopX - startX).toDouble(), 2.0)
                                + Math.pow((stopY - startY).toDouble(), 2.0))
                    canvas.drawCircle(startX.toFloat(), startY.toFloat(), radius.toFloat(), paint)
                }
            }

            paint.color = Color.MAGENTA
            when (curShape) {
                RECT -> {
                    val rect = Rect(startX, startX, stopX, stopY)
                    canvas.drawRect(rect, paint)
                }
            }

        }
    }
    override fun onCreateOptionsMenu(menu: Menu?) : Boolean {
        super.onCreateOptionsMenu(menu)
        menu!!.add(0, 1, 0, "선 그리기")
        menu!!.add(0, 2, 0, "원 그리기")
        menu!!.add(0, 3, 0, "네모 그리기")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            1 -> {
                curShape = LINE
                return true
            }
            2 -> {
                curShape = CIRCLE
                return true
            }
            3 -> {
                curShape = RECT
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}