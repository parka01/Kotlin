package com.example.mar19intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Content3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content3)
        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }
    }
}