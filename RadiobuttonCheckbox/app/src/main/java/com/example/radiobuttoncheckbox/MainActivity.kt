package com.example.radiobuttoncheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Need all the variables. 1. Create Variable using lateinit var variable name
        lateinit var rgProtein : RadioGroup

        lateinit var rdoBeef : RadioButton
        lateinit var rdoPork : RadioButton
        lateinit var rdoTofu : RadioButton

        lateinit var ckCheese : CheckBox
        lateinit var ckGuaca : CheckBox
        lateinit var ckQueso : CheckBox

        lateinit var btnOrder : Button

        lateinit var textView1 : TextView

        //2. Initialize variables
        rgProtein = findViewById(R.id.rgProtein) as RadioGroup

        rdoBeef = findViewById(R.id.rdoBeef) as RadioButton
        rdoPork = findViewById(R.id.rdoPork) as RadioButton
        rdoTofu = findViewById(R.id.rdoTofu) as RadioButton

        ckCheese = findViewById(R.id.ckCheese) as CheckBox
        ckGuaca = findViewById(R.id.ckGuaca) as CheckBox
        ckQueso = findViewById(R.id.ckQueso) as CheckBox

        btnOrder = findViewById(R.id.btnOrder) as Button

        textView1 = findViewById(R.id.textView1) as TextView

        btnOrder.setOnClickListener (View.OnClickListener {
            //create variable to store result.
            var result = ""
            if(rgProtein.checkedRadioButtonId != -1){
                result +="Selected protein: "
                if(rdoBeef.isChecked)
                    result += "beef\n"
                else if(rdoPork.isChecked)
                    result += "pork\n"
                else if(rdoTofu.isChecked)
                    result += "tofu\n"
            }
            result += "Burrito Bowl: "

            if(ckCheese.isChecked)
                result += "cheese\n"
            if(ckGuaca.isChecked)
                result += "guacamole\n"
            if(ckQueso.isChecked)
                result += "queso\n"

            textView1.text = result

        })

    }
}