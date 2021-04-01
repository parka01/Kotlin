package com.example.ahyoungapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var openNew : Button
    lateinit var rdoPop : RadioButton
    lateinit var rdoChocolate : RadioButton
    lateinit var rdoRecommendation : RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.icon)

        var openNew = findViewById<Button>(R.id.openNew)
        var rdoPop = findViewById<RadioButton>(R.id.rdoPop)
        var rdoChocolate = findViewById<RadioButton>(R.id.rdoChocolate)
        var rdoRecommendation = findViewById<RadioButton>(R.id.rdoRecommendation)

        openNew.setOnClickListener {
            var intent: Intent
            if(rdoRecommendation.isChecked){
                intent = Intent(applicationContext, Recommendation::class.java)
            }
            else if(rdoPop.isChecked){
                intent = Intent(applicationContext, Content2::class.java)
            }
            else
                intent = Intent(applicationContext, Content3::class.java)
            startActivity(intent)
        }
    }
}