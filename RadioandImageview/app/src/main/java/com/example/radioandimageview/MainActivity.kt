package com.example.radioandimageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    //1단계 - 코틀릭 객체 만들기
    lateinit var text2 : TextView

    lateinit var rGroup1 : RadioGroup
    lateinit var rdoDog : RadioButton
    lateinit var rdoCat : RadioButton
    lateinit var rdoRabbit : RadioButton

    lateinit var imgPet : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "애완동물 사진 보기"

        //2단계 - 바인딩
        text2 = findViewById<TextView>(R.id.Text2)

        rGroup1 = findViewById<RadioGroup>(R.id.Rgroup1)
        rdoDog = findViewById<RadioButton>(R.id.RdoDog)
        rdoCat = findViewById<RadioButton>(R.id.RdoCat)
        rdoRabbit = findViewById<RadioButton>(R.id.RdoRabbit)

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
