package com.example.march09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //1단계: 코틀린 객체를 만든다.멤버 변수 자리. 지역변수자리onCreate아래 넣어도 된다.
    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button
    lateinit var btnMod : Button
    lateinit var textResult: TextView
    lateinit var num1 : String
    lateinit var num2 : String
    var result : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.calculate)
        title = "초간단 계산기"
        //2단계: xml객체를 코틀린 객체에 바인딩(연결)한다.

        edit1 = findViewById<EditText>(R.id.Edit1) //R.id.Edit1의 Edit1은 xml의 아이디 값이다.
        edit2 = findViewById<EditText>(R.id.Edit2)
        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        btnMod = findViewById<Button>(R.id.BtnMod)

        textResult = findViewById<TextView>(R.id.TextResult)
        //3단계: 연결된 코틀린객체(예:버튼)에 이벤트 처리를 한다.
        btnAdd.setOnTouchListener { view, motionEvent ->
            var str1 = edit1.text.toString()
            var str2 = edit2.text.toString()
            var num1 = str1.toInt()
            var num2 = str2.toInt()
            var result = num1+num2

            textResult.setText(""+result)
            //textResult.setText(result.toString())


            false
        }

        btnSub.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            textResult.text = "계산 결과: "+ result.toString()
            false
        }

        btnMul.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            textResult.text = "계산 결과: "+ result.toString()
            false
        }

        btnDiv.setOnTouchListener { view, motionEvent ->
            var str1 : String = edit1.text.toString()
            var str2 = edit2.text.toString()

            //if(str1.equals(""))
            if(str1 == ""|| str2 == ""){
                //안된다. 둘 중에 하나라도 공백이면
                Toast.makeText(this,"값을 입력해주세요!",Toast.LENGTH_SHORT).show()
            }
            if(str2 == "0")
            {
                //안된다. 둘 중에 하나라도 공백이면
                Toast.makeText(this,"0으로 나눌 수 없습니다!",Toast.LENGTH_SHORT).show()
            }
            else {

                var num1 = str1.toDouble()
                var num2 = str2.toDouble()
                var result = num1 / num2
                result = (result + 100).toInt()/100.0
                //나머지소수부분 버려주는 것.

                textResult.setText(result.toString())
            }

            false
        }
        //나머지 버튼에 대해서, setOn용*Click*Listener를 사용
        btnMod.setOnClickListener {
            var str1 : String = edit1.text.toString()
            var str2 = edit2.text.toString()

            //if(str1.equals(""))
            if(str1 == ""|| str2 == ""){
                //안된다. 둘 중에 하나라도 공백이면
                Toast.makeText(this,"값을 입력해주세요!",Toast.LENGTH_SHORT).show()
            }
            else {

                var num1 = str1.toInt()
                var num2 = str2.toInt()
                var result = num1 % num2

                textResult.setText(result.toString())
            }

            false
        }

    }
}