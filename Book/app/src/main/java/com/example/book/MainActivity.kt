package com.example.book

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity()
{
    lateinit var chrono : Chronometer
    //    lateinit var btnStart : Button
//    lateinit var btnEnd : Button
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton
    //    lateinit var calView : CalendarView
    lateinit var dPicker : DatePicker

    lateinit var tPicker : TimePicker
    lateinit var tvYear : TextView
    lateinit var tvMonth : TextView
    lateinit var tvDay : TextView
    lateinit var tvHour : TextView
    lateinit var tvMinute : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "시간 예약"

        // 버튼
//        btnStart = findViewById<Button>(R.id.btnStart)
//        btnEnd = findViewById<Button>(R.id.btnEnd)

        // 크로노미터
        chrono = findViewById<Chronometer>(R.id.chronometer1)

        // 라디오버튼 2개
        rdoCal = findViewById<RadioButton>(R.id.rdoCal)
        rdoTime = findViewById<RadioButton>(R.id.rdoTime)

        // FrameLayout의 2개 위젯
        tPicker = findViewById<TimePicker>(R.id.timePicker1)
//        calView = findViewById<CalendarView>(R.id.calendarView1)
        dPicker = findViewById<DatePicker>(R.id.dPicker1)

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        tvYear = findViewById<TextView>(R.id.tvYear)
        tvMonth = findViewById<TextView>(R.id.tvMonth)
        tvDay = findViewById<TextView>(R.id.tvDay)
        tvHour = findViewById<TextView>(R.id.tvHour)
        tvMinute = findViewById<TextView>(R.id.tvMinute)

        tPicker.visibility = View.INVISIBLE
//        calView.visibility = View.INVISIBLE
        dPicker.visibility = View.INVISIBLE
        //추가
        rdoTime.visibility = View.INVISIBLE
        rdoCal.visibility = View.INVISIBLE

//        btnStart.setOnClickListener {
//            chrono.base = SystemClock.elapsedRealtime()
//            chrono.start()
//            chrono.setTextColor(Color.RED)
//        }

        chrono.setOnClickListener {
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            chrono.setTextColor(Color.RED)

            rdoCal.visibility = View.VISIBLE
            rdoTime.visibility = View.VISIBLE
        }

        rdoCal.setOnClickListener {
//            calView.visibility = View.VISIBLE
            dPicker.visibility = View.VISIBLE
            tPicker.visibility = View.INVISIBLE
        }
        rdoTime.setOnClickListener {
//            calView.visibility = View.INVISIBLE
            dPicker.visibility = View.INVISIBLE
            tPicker.visibility = View.VISIBLE
        }

//        var nYear = 0
//        var nMonth = 0
//        var nDay = 0;

        //데이트 피커는 changedListener를 사용할 필요가 없다
//        calView.setOnDateChangeListener { calendarView, i1, i2, i3 ->
//            nYear = i1
//            nMonth = i2 + 1
//            nDay = i3
//        }


//        btnEnd.setOnClickListener {
//            chrono.stop()
//            chrono.setTextColor(Color.BLUE)
//
//            //1.날짜 (년월일) - 캘린더뷰
////            tvYear.text = Integer.toString(nYear)
////            tvMonth.text = Integer.toString(nMonth)
////            tvDay.text = Integer.toString(nDay)
//            tvYear.text = Integer.toString(dPicker.year)
//            tvMonth.text = Integer.toString(dPicker.month+1)
//            tvDay.text = Integer.toString(dPicker.dayOfMonth)
//
//
//            //2.시간 (시분) -타임피커
//            //tvHour.text = ""+tPicker.currentHour
//            //tvHour.text = tPicker.currentHour.toString()
//            tvHour.text = Integer.toString(tPicker.currentHour)
//            tvMinute.text = Integer.toString(tPicker.currentMinute)
//
//        }

        tvYear.setOnLongClickListener {

            chrono.stop()
            chrono.setTextColor(Color.BLUE)
//            chrono.setTextColor(Color.BLUE)
//
//            //1.날짜 (년월일) - 캘린더뷰
////            tvYear.text = Integer.toString(nYear)
////            tvMonth.text = Integer.toString(nMonth)
////            tvDay.text = Integer.toString(nDay)
            tvYear.text = Integer.toString(dPicker.year)
            tvMonth.text = Integer.toString(dPicker.month+1)
            tvDay.text = Integer.toString(dPicker.dayOfMonth)
//
//
//            //2.시간 (시분) -타임피커
//            //tvHour.text = ""+tPicker.currentHour
//            //tvHour.text = tPicker.currentHour.toString()
            tvHour.text = Integer.toString(tPicker.currentHour)
            tvMinute.text = Integer.toString(tPicker.currentMinute)

            tPicker.visibility = View.INVISIBLE
//        calView.visibility = View.INVISIBLE
            dPicker.visibility = View.INVISIBLE
            //추가
            rdoTime.visibility = View.INVISIBLE
            rdoCal.visibility = View.INVISIBLE
            false
        }
    }
}