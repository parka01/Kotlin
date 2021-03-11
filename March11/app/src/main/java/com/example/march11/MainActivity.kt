package com.example.march11

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var chrono : Chronometer
    lateinit var btnStart : Button
    lateinit var btnEnd : Button
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton
    lateinit var calView : CalendarView
    lateinit var tPicker : TimePicker
    lateinit var tvYear : TextView
    lateinit var tvMonth : TextView
    lateinit var tvDay : TextView
    lateinit var tvHr : TextView
    lateinit var tvMi : TextView
    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "시간 예약"

        btnStart = findViewById<Button>(R.id.btnStart)
        btnEnd = findViewById<Button>(R.id.btnEnd)

        chrono = findViewById<Chronometer>(R.id.chronometer1)

        rdoCal = findViewById<RadioButton>(R.id.rdoCal)
        rdoTime = findViewById<RadioButton>(R.id.rdoTime)

        tPicker = findViewById<TimePicker>(R.id.timePicker1)
        calView = findViewById<CalendarView>(R.id.calenderView1)

        tvYear = findViewById<TextView>(R.id.tvYear)
        tvMonth = findViewById<TextView>(R.id.tvMonth)
        tvDay = findViewById<TextView>(R.id.tvDay)
        tvHr = findViewById<TextView>(R.id.tvHr)
        tvMi = findViewById<TextView>(R.id.tvMi)

        tPicker.visibility = View.INVISIBLE
        tPicker.visibility = View.INVISIBLE

        rdoCal.setOnClickListener {
            tPicker.visibility = View.INVISIBLE
            calView.visibility = View.VISIBLE
        }
        rdoTime.setOnClickListener {
            tPicker.visibility = View.VISIBLE
            calView.visibility = View.INVISIBLE
        }
        btnStart.setOnClickListener {
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            chrono.setTextColor(Color.RED)
        }
        btnEnd.setOnClickListener {
            chrono.stop()
            chrono.setTextColor(Color.BLUE)

            tvYear.text = Integer.toString(selectYear)
            tvMonth.text = Integer.toString(selectMonth)
            tvDay.text = Integer.toString(selectDay)

            tvHr.text = Integer.toString(tPicker.currentHour)
            tvMi.text = Integer.toString(tPicker.currentMinute)
        }
        calView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectYear = year
            selectMonth = month + 1
            selectDay = dayOfMonth
        }
    }
}