package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "스피너 테스트"

        var movie = arrayOf("쿵푸팬더", "짱구는 못말려", "아저씨",
                                            "아바타", "대부", "국가대표", "토이스토리3",
                                        "마당을 나온 암탉", "죽은 시인의 사회", "서유기")
        var posterID = arrayOf(R.drawable.mov21, R.drawable.mov22, R.drawable.mov23, R.drawable.mov24,
                            R.drawable.mov25, R.drawable.mov26, R.drawable.mov27, R.drawable.mov28)
        var spinner = findViewById<Spinner>(R.id.spinner1)

        var adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, movie)

        spinner.adapter = adapter


        //1.리스너 인터페이스 상속 받아서 MyListener구현
//        var myLis = object: AdapterView.OnItemSelectedListener {
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//            }
//
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//               var iv1 = findViewById<ImageView>(R.id.iv1)
//                iv1.scaleType = ImageView.ScaleType.FIT_CENTER
//                iv1.setPadding(5,5,5,5)
//                iv1.setImageResource(posterID[p2])
//            }
//        }
//        spinner.setOnItemClickListener(myLis)
//        spinner.setOnItemClickListener { adapterView, view, i, l ->  }
//          spinner.onItemSelectedListener = myLis




//        //2.익명 객체(리스너)
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               var iv1 = findViewById<ImageView>(R.id.iv1)
                iv1.scaleType = ImageView.ScaleType.FIT_CENTER
                iv1.setPadding(5,5,5,5)
                iv1.setImageResource(posterID[p2])
            }
        }







        //3.액티비티가 리스너를 가진다.

//        spinner.setOnItemClickListener { adapterView, view, i, l ->
//            //스피너의 아이템을 클릭했을 떄 할 일
//        }




    }
}