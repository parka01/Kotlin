package com.example.mar19intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var openNew = findViewById<Button>(R.id.openNew)
        var rdoPop = findViewById<RadioButton>(R.id.rdoPop)

        openNew.setOnClickListener {
            var intent: Intent
            if(rdoPop.isChecked)
            {   //1.인텐트 객체를 생성한다. (From A -> to B)
                intent = Intent(applicationContext, Content2::class.java)
            }
            else
                intent = Intent(applicationContext, Content3::class.java)
            //2.startActivity()메소드를 통해서 동작작
            startActivity(intent)
        }
    }
}