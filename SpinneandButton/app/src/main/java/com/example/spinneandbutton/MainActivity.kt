package com.example.spinneandbutton
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {

    lateinit var tv1 : TextView
    lateinit var spinner : Spinner
    lateinit var spinner2 : Spinner
    lateinit var btn : Button

    var data1 = arrayOf("스피너1-1", "스피너1-2", "스피너1-3", "스피너1-4", "스피너1-5", "스피너1-6")
    var data2 = arrayOf("스피너2-1", "스피너2-2", "스피너2-3", "스피너2-4", "스피너2-5", "스피너2-6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1 = findViewById<TextView>(R.id.tv1)
        spinner = findViewById<Spinner>(R.id.spinner)
        spinner2 = findViewById<Spinner>(R.id.spinner2)
        btn = findViewById<Button>(R.id.btn)

        var adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)
        var adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data2)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter1
        spinner2.adapter = adapter2

        var listener = SpinnerListener()

        spinner.onItemSelectedListener = listener

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tv1.text = data2[p2]
            }

        }

        btn.setOnClickListener { view ->
            tv1.text = data1[spinner.selectedItemPosition]+"\n"
            tv1.append(data2[spinner2.selectedItemPosition])
        }
    }

    inner class SpinnerListener : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {

        }

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) { // p2가 사용자가 선택한 곳의 인덱스
            tv1.text = data1[p2]
        }
    }
}