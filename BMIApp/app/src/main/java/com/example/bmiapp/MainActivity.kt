package com.example.bmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    //--------------------구성요소선언--------------------
    lateinit var height : EditText
    lateinit var weight : EditText
    lateinit var rgGender : RadioGroup
    lateinit var rdoFemale : RadioButton
    lateinit var rdoMale : RadioButton
    lateinit var spinnerBlood : Spinner
    lateinit var ckDrink : CheckBox
    lateinit var ckSmoke : CheckBox
    lateinit var ckWorkout : CheckBox
    lateinit var btnShow : Button
    lateinit var type1 : TextView
    lateinit var type2 : TextView
    lateinit var textResult : TextView
    lateinit var imgSmoke : ImageView
    lateinit var imgDrink : ImageView
    lateinit var imgWorkout : ImageView

    var bloodType = arrayOf("A", "B", "O", "AB")
    var result : Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.icon)

        //--------------------변수이름만들기--------------------
        height = findViewById<EditText>(R.id.height)
        weight = findViewById<EditText>(R.id.weight)
        rgGender = findViewById<RadioGroup>(R.id.rgGender)
        rdoFemale = findViewById<RadioButton>(R.id.rdoFemale)
        rdoMale = findViewById<RadioButton>(R.id.rdoMale)
        spinnerBlood = findViewById<Spinner>(R.id.spinnerBlood)
        btnShow = findViewById<Button>(R.id.btnShow)
        type1 = findViewById<TextView>(R.id.type1)
        type2 = findViewById<TextView>(R.id.type2)
        textResult = findViewById<TextView>(R.id.textResult)

        ckDrink = findViewById<CheckBox>(R.id.ckDrink)
        ckSmoke = findViewById<CheckBox>(R.id.ckSmoke)
        ckWorkout = findViewById<CheckBox>(R.id.ckWorkout)
        imgSmoke = findViewById<ImageView>(R.id.imgSmoke)
        imgDrink = findViewById<ImageView>(R.id.imgDrink)
        imgWorkout = findViewById<ImageView>(R.id.imgWorkout)

        //--------------------혈액형스피너--------------------
        var adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, bloodType)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerBlood.adapter = adapter1
        var listener = SpinnerListener()
        spinnerBlood.onItemSelectedListener = listener

        //--------------------버튼을 눌렀을때 일어나는 모든 일--------------------
        btnShow.setOnClickListener {
            //type1.text = "1. " + bloodType[spinnerBlood.selectedItemPosition] + "형 "

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

            //--------------------라디오버튼--------------------
            var result = ""
            if(rgGender.checkedRadioButtonId == -1){
                result +="1. ?형 ?입니다!"
                type2.text = result
            }
            if(rgGender.checkedRadioButtonId != -1){
                result += ""
                if(rdoFemale.isChecked){
                    result += "여자입니다!"
                }
                else if(rdoMale.isChecked) {
                    result += "남자입니다!"
                }
                type1.text = "1. " + bloodType[spinnerBlood.selectedItemPosition] + "형 "
                type2.text = result
            }
        }
        //--------------------체크박스 이미지 띄우기--------------------
        ckSmoke.setOnClickListener {
            if(ckSmoke.isChecked) {
                imgSmoke.setImageResource(R.drawable.ciga)
            }
            else {
                imgSmoke.setImageResource(0)
            }
        }
        ckDrink.setOnClickListener {
            if(ckDrink.isChecked) {
                imgDrink.setImageResource(R.drawable.drinking)
            }
            else {
                imgDrink.setImageResource(0)
            }
        }
        ckWorkout.setOnClickListener {
            if(ckWorkout.isChecked) {
                imgWorkout.setImageResource(0)
            }
            else {
                imgWorkout.setImageResource(R.drawable.running)
            }
        }
    }
    inner class SpinnerListener : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {
        }
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        }
    }
}
