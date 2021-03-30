package com.example.singlespinnerbutton
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {

    lateinit var tv1 : TextView
    lateinit var spinner : Spinner
    lateinit var btn : Button

    var data = arrayOf("스피너1-1", "스피너1-2", "스피너1-3", "스피너1-4", "스피너1-5", "스피너1-6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1 = findViewById<TextView>(R.id.tv1)
        spinner = findViewById<Spinner>(R.id.spinner)
        btn = findViewById<Button>(R.id.btn)

        var adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter1

        var listener = SpinnerListener()
        spinner.onItemSelectedListener = listener

        btn.setOnClickListener { view ->
            tv1.text = data[spinner.selectedItemPosition]
        }
    }

    inner class SpinnerListener : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {
        }
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) { // p2가 사용자가 선택한 곳의 인덱스
            tv1.text = "" //해두면 버튼을 눌러야 빈값이 채워지는 형식
            tv1.text = data[p2] //선택한 값이 바로바로 실시간으로 보여진다.
        }
    }
}