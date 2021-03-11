package com.example.calculator2

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit internal var edit1 : EditText
    lateinit internal var edit2 : EditText
    lateinit internal var btnAdd : Button
    lateinit internal var btnSub : Button
    lateinit internal var btnMul : Button
    lateinit internal var btnDiv : Button
    lateinit internal var textResult : TextView
    lateinit internal var num1 : String
    lateinit internal var num2 : String
    internal var result : Int? = null
    internal var numButtons = ArrayList<Button>(10)
    internal var numBtnIDs = arrayOf(R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
                         R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6,
                         R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9)
    internal var I : Int = 0 //증가값 용도

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "테이블레이아웃 계산기"

        edit1 = findViewById<EditText>(R.id.Edit1)
        edit1 = findViewById<EditText>(R.id.Edit2)
        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        textResult = findViewById<TextView>(R.id.TextResult)

        btnAdd.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) + Integer.parseInt(num2)
            textResult.text = "계산 결과: " + result.toString()
            false
        }
        btnSub.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            textResult.text = "계산 결과: " + result.toString()
            false
        }
        btnMul.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            textResult.text = "계산 결과: " + result.toString()
            false
        }
        btnDiv.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) / Integer.parseInt(num2)
            textResult.text = "계산 결과: " + result.toString()
            false
        }
    }
}