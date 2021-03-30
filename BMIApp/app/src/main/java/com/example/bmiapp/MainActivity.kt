package com.example.bmiapp

import android.content.Context
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    lateinit var height : EditText
    lateinit var weight : EditText

    lateinit var rgGender : RadioGroup
    lateinit var rdoFemale : RadioButton
    lateinit var rdoMale : RadioButton

    //스피너는 아래

    lateinit var ckDrink : CheckBox
    lateinit var ckSmoke : CheckBox
    lateinit var ckWorkout : CheckBox

    lateinit var btnShow : Button
    lateinit var type : TextView
    lateinit var textResult : TextView


    var result : Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.icon)

        var bType = arrayOf("A", "B", "O", "AB")
        var spinner = findViewById<Spinner>(R.id.bloodType)
        var adapter: ArrayAdapter<String>
        var blood = bType.toString()
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bType)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?){
                textResult.text = "혈액형을 고르세요"
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                type.text = p2
            }
        }

        height = findViewById<EditText>(R.id.height)
        weight = findViewById<EditText>(R.id.weight)

        rgGender = findViewById<RadioGroup>(R.id.rgGender)
        rdoFemale = findViewById<RadioButton>(R.id.rdoFemale)
        rdoMale = findViewById<RadioButton>(R.id.rdoMale)

        btnShow = findViewById<Button>(R.id.btnShow)

        type = findViewById<TextView>(R.id.type)
        textResult = findViewById<TextView>(R.id.textResult)


        btnShow.setOnClickListener {




            var numH = height.text.toString()
            var numW = weight.text.toString()

            if ((height.text.toString()=="")||(height.text.toString()=="")){
                textResult.text = "2.신체질량지수는 ???입니다!"
                var dlg = AlertDialog.Builder(this@MainActivity)
                var pop = LayoutInflater.from(this)
                var view = pop.inflate(R.layout.dialog, null)
                dlg.setTitle(Html.fromHtml("<font color='#80D7FF'>키와 체중</font>"))
                dlg.setView(view)
//                dlg.setMessage("키와 체중을 넣어주세요!")
//                dlg.setPositiveButton("닫기", null)
                dlg.show()
            }
            else {
            result = numW.toDouble() / ((numH.toDouble()/100)*(numH.toDouble()/100))
            textResult.text = "2. 신체질량지수는 " + result.toString() + "입니다!"
            }

            var result = ""

            if(rgGender.checkedRadioButtonId != -1){
                result +="1. "
                if(rdoFemale.isChecked)
                    result += "여자입니다!"
                else if(rdoMale.isChecked)
                    result += "남자입니다!"

                type.text = result
            }
            if(rgGender.checkedRadioButtonId == -1){
                result +="1. ?입니다!"
                type.text = result
            }
        }
    }
}
