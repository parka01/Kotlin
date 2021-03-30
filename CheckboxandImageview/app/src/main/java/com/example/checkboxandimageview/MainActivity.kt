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

    lateinit var imgPet : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "애완동물 사진 보기"

        //2단계 - 바인딩
        text2 = findViewById<TextView>(R.id.Text2)

        rdoDog = findViewById<CheckBox>(R.id.RdoDog)
        rdoCat = findViewById<CheckBox>(R.id.RdoCat)
        rdoRabbit = findViewById<CheckBox>(R.id.RdoRabbit)

        imgPet = findViewById<ImageView>(R.id.ImgPet)


        rdoCat.setOnClickListener {
            imgPet.setImageResource(R.drawable.cat)
        }
        rdoDog.setOnClickListener {
            imgPet.setImageResource(R.drawable.dog)
        }
        rdoRabbit.setOnClickListener {
            imgPet.setImageResource(R.drawable.rabbit)
        }

    }
}
