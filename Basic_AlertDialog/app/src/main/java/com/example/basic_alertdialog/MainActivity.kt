package com.example.basic_alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("제목입니다")
            dlg.setMessage("이곳이 내용입니다")
            dlg.setIcon(R.mipmap.ic_launcher)
            //dlg.setPositiveButton("확인", null)//기본확인버튼
            dlg.setPositiveButton("확인")
            {dialog, which ->
                Toast.makeText(this@MainActivity,
                "확인을 눌렀네요", Toast.LENGTH_SHORT).show()
            }
            dlg.show()
        }
    }
}