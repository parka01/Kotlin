package com.example.alertdialog1


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
            var versionArray = arrayOf("오레오", "파이", "큐(10)")
            var checkArray = booleanArrayOf(true, false, false)
            var dlg = AlertDialog.Builder(this@MainActivity)
            var checkedArray: Array<String> = arrayOf()

            dlg.setTitle("좋아하는 버전은??")
            dlg.setIcon(R.mipmap.ic_launcher)
            dlg.setMultiChoiceItems(versionArray, checkArray)
            {
                dialog, which, isChecked ->
                button1.text = versionArray[which]
            }

            if(checkArray = true){
                fun add(input: String){}
                checkedArray += iput
            } else {
                break
            }

            //dlg.setPositiveButton("확인", null)//기본확인버튼
            dlg.setPositiveButton("닫기", null)
            dlg.show()
        }




    }
}