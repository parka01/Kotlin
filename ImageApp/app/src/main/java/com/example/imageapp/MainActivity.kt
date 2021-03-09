package com.example.imageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    //1.코틀린 객체 만들기
    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoOreo : RadioButton
    lateinit var rdoPie : RadioButton
    lateinit var rdoQ : RadioButton
    //lateinit var btnOK : Button
    lateinit var imgPet : ImageView

    lateinit var swAgree : Switch
    lateinit var btnClose : Button
    lateinit var btnHome : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.image_app)

        //2. 연결하기(바인딩)
        title = "안드로이드 사진 보기"

        text1 = findViewById<TextView>(R.id.Text1)
        text2 = findViewById<TextView>(R.id.Text2)
        rGroup1 = findViewById<RadioGroup>(R.id.Rgroup1)
        rdoOreo = findViewById<RadioButton>(R.id.RdoOreo)
        rdoPie = findViewById<RadioButton>(R.id.RdoPie)
        rdoQ = findViewById<RadioButton>(R.id.RdoQ)

        swAgree = findViewById<Switch>(R.id.swAgree)
        btnClose = findViewById<Button>(R.id.BtnClose)
        btnHome = findViewById<Button>(R.id.BtnHome)
        //btnOK = findVewById<Button>(R.id.BtnOk)
        imgPet = findViewById<ImageView>(R.id.ImgPet)


        //3.이벤트 처리
        swAgree.setOnCheckedChangeListener { compoundButton, b ->
            //체크가 되어있으면
            if (swAgree.isChecked == true){
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                imgPet.visibility = android.view.View.VISIBLE
                btnClose.visibility = android.view.View.VISIBLE
                btnHome.visibility = android.view.View.VISIBLE
            } else { //그렇지 않으면
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                imgPet.visibility = android.view.View.INVISIBLE
                btnClose.visibility = android.view.View.INVISIBLE
                btnHome.visibility = android.view.View.INVISIBLE
            }
        }
        rdoOreo.setOnClickListener{
            imgPet.setImageResource(R.drawable.oreo)
        }
        rdoPie.setOnClickListener{
            imgPet.setImageResource(R.drawable.pie)
        }
        rdoQ.setOnClickListener{
            imgPet.setImageResource(R.drawable.q)
        }

        btnClose.setOnClickListener {
            finish() //액티비티 종료
       }
        btnHome.setOnClickListener {
            text2.visibility = android.view.View.INVISIBLE
            rGroup1.visibility = android.view.View.INVISIBLE
            imgPet.visibility = android.view.View.INVISIBLE
            btnClose.visibility = android.view.View.INVISIBLE
            btnHome.visibility = android.view.View.INVISIBLE

            swAgree.isChecked = false //스위치를 비활성 상태로 돌린다.
            rGroup1.clearCheck()//라디오 버튼에 선택되어진것을 초기화.
            //imgPet.setImageResource(R.drawable.ic_launcher_background)
            //다른빈그림넣기
            imgPet.setImageResource(0)
            //이미지 없애버리기
        }
//        btnOK.setOnClickListener {
//            when (rGroup1.checkedRadioButtonId){
//                R.id.RdoOreo -> imgPet.setImageResource(R.drawable.oreo)
//                R.id.RdoPie -> imgPet.setImageResource(R.drawable.pie)
//                R.id.RdoQ -> imgPet.setImageResource(R.drawable.q)
//                else -> Toast.makeText(applicationContext,"동물 먼저 선택하세요", Toast.LENGTH_SHORT).show()
//            }
//        }
    }
}