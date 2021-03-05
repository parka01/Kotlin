package com.example.calculator

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        //1단계: "코틀린 뷰 객체" 만들기
        val tv1: TextView
        val tv2: TextView
        val tv3: TextView
        //2단계: XML객체->코틀린 뷰 객체에 연결(바인딩)
        tv1 = findViewById<TextView>(R.id.textView1)
        tv2 = findViewById<TextView>(R.id.textView2)
        tv3 = findViewById<TextView>(R.id.textView3)

        tv1.setText("안녕하세요?")
        tv1.setTextColor(Color.RED)
        tv2.setTextSize(30.0f)
        tv2.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC)
        tv3.setText("가나다라마바사")
        tv3.setSingleLine()

        setContentView(R.layout.ex04_2);
    }
}