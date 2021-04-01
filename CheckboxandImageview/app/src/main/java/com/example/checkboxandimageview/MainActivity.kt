package com.example.checkboxandimageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    //1단계 - 코틀릭 객체 만들기
    lateinit var text2 : TextView
    lateinit var rdoDog : CheckBox
    lateinit var rdoCat : CheckBox
    lateinit var rdoRabbit : CheckBox
    lateinit var imgDog : ImageView
    lateinit var imgRabbit : ImageView
    lateinit var imgCat : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "애완동물 사진 보기"

        //2단계 - 바인딩
        text2 = findViewById<TextView>(R.id.Text2)
        rdoDog = findViewById<CheckBox>(R.id.RdoDog)
        rdoCat = findViewById<CheckBox>(R.id.RdoCat)
        rdoRabbit = findViewById<CheckBox>(R.id.RdoRabbit)
        imgDog = findViewById<ImageView>(R.id.imgDog)
        imgCat = findViewById<ImageView>(R.id.imgCat)
        imgRabbit = findViewById<ImageView>(R.id.imgRabbit)

        rdoDog.setOnClickListener {
            if(rdoDog.isChecked) {
                imgDog.setImageResource(R.drawable.dog)
            }
            else {
                imgDog.setImageResource(0)
            }
        }
        rdoCat.setOnClickListener {
            if(rdoCat.isChecked) {
                imgCat.setImageResource(R.drawable.cat)
            }
            else {
                imgCat.setImageResource(0)
            }
        }
        rdoRabbit.setOnClickListener {
            if(rdoRabbit.isChecked) {
                imgRabbit.setImageResource(R.drawable.rabbit)
            }
            else {
                imgRabbit.setImageResource(0)
            }
        }

    }
}
