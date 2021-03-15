package com.example.answerflip

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
        btnPrev = findViewById<Button>(R.id.btnNext)
        vFlipper = findViewById<Button>(R.id.viewFlipper1)

        vFlipper.flipInterval = 2000

        btnPrev.setOnClickListener {
            vFlipper.startFlipping()

        }
        btnNext.setOnClickListener {
            vFlipper.stopFlipping()

        }
    }
}