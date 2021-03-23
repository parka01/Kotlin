package com.example.two_way_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        title = "Second액티비티"

        var inIntent = intent
        
        var strOp = intent.getStringExtra("Operator")
        var num1 = intent.getIntExtra("Num1", 0)
        var num2 = intent.getIntExtra("Num2", 0)
        
        var hapValue = 0
        
        when (strOp){
            "+" -> hapValue = num1 + num2
            "-" -> hapValue = num1 - num2
            "*" -> hapValue = num1 * num2
            "/" -> hapValue = num1 / num2
        }
            

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", hapValue)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }
}