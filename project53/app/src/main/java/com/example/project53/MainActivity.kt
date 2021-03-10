package com.example.project53

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //xml을 쓰지 않겠다. kotlin객체로 하겠다.

        //0단계: 레이아웃객체를 만들기전에 옵션값 객체를 먼저 만든다.
        //화면면적
        var params =  LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        //1단계: 레이아웃 객체를 만든다.(예: LinearLayout코틀린 객체)
        var baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL
        baseLayout.setBackgroundColor(Color.rgb(255,255,255))

        setContentView(baseLayout, params)


        //2단계: EidtText 객체를 만든다.
        var e = EditText(this)

        //2단계: 버튼 객체를 만든다.
        var btn = Button(this)
        btn.text = "버튼입니다."
        btn.setBackgroundColor(Color.MAGENTA)
        //2단계: TextView 객체를 만든다.
        var v = TextView(this)

        //3단계: 버튼 객체를 레이아웃 객체에 소속(상속, 부모자식관계) 시킨다.
        baseLayout.addView(e)
        baseLayout.addView(btn)
        baseLayout.addView(v)

        //4단계: 버튼 이벤트를 처리한다.
        v.setOnClickListener {
            //Toast.makeText(this,"버튼",Toast.LENGTH_SHORT).show()
            //v.text = e.text.toString()
            v.setText(e.text.toString())
            //위와 같은 내용이다.

        }


    }
}