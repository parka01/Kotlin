package com.example.drawer2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ViewFlipper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnPrev : Button
        var btnNext : Button
        var vFlipper : ViewFlipper

        btnPrev = findViewById<Button>(R.id.btnPrev)
        btnNext = findViewById<Button>(R.id.btnNext)
        vFlipper = findViewById<ViewFlipper>(R.id.vieWFlipper)

        btnPrev.setOnClickListener {
            vFlipper.showPrevious()
        }
        btnNext.setOnClickListener {
            vFlipper.showNext()
        }
    }
}