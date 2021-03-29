package com.example.bmiapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    lateinit var height : EditText
    lateinit var weight : EditText
    lateinit var btnShow : Button
    lateinit var textResult : TextView

    var result : Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.icon)

        var type = arrayOf("A", "B", "O", "AB")
        var spinner = findViewById<Spinner>(R.id.bloodType)

        var adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, type)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?){
                textResult.text = "혈액형을 고르세요"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
        }


        height = findViewById<EditText>(R.id.height)
        weight = findViewById<EditText>(R.id.weight)
        textResult = findViewById<TextView>(R.id.textResult)
        btnShow = findViewById<Button>(R.id.btnShow)

        btnShow.setOnClickListener {
            var numH = height.text.toString()
            var numW = weight.text.toString()

            if ((height.text.toString()=="")||(height.text.toString()=="")){
                var dlg = AlertDialog.Builder(this@MainActivity)
                var pop = LayoutInflater.from(this)
                var view = pop.inflate(R.layout.dialog, null)
                dlg.setTitle("키와 체중")
                dlg.set(#000000).
                dlg.setView(view)
//                dlg.setMessage("키와 체중을 넣어주세요!")
                dlg.setPositiveButton("닫기", null)
                dlg.show()
            } else {
            result = numW.toDouble() / ((numH.toDouble()/100)*(numH.toDouble()/100))
            textResult.text = "계산결과: " + result.toString()
            false
            }
        }
    }
}
