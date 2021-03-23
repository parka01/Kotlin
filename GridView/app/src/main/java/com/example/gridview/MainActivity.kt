package com.example.gridview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "그리드뷰 영화 포스터"

        var gv = findViewById<View>(R.id.gView1) as GridView

        var gAdapter = MyGridAdapter(this)

        gv.adapter = gAdapter

    }



    inner class MyGridAdapter(var context: Context) : BaseAdapter() {

        var posterID = arrayOf (
                R.drawable.mov01, R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,
                R.drawable.mov05,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,
                R.drawable.mov09,R.drawable.mov10,R.drawable.mov11,R.drawable.mov12,
                R.drawable.mov13,R.drawable.mov14,R.drawable.mov15,R.drawable.mov16,
                R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,R.drawable.mov20,
                R.drawable.mov21,R.drawable.mov22,R.drawable.mov23,R.drawable.mov24,
                R.drawable.mov25,R.drawable.mov26,R.drawable.mov27,R.drawable.mov28)

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var imageview = ImageView(context)
            imageview.layoutParams = ViewGroup.LayoutParams(200, 300)
            imageview.scaleType = ImageView.ScaleType.FIT_CENTER
            imageview.setPadding(5, 5, 5, 5)

            imageview.setImageResource(posterID[p0])


            imageview.setOnClickListener {
                var dialogView = View.inflate(this@MainActivity, R.layout.dialog, null)
                var dlg = AlertDialog.Builder(this@MainActivity)
                var ivPoster = dialogView.findViewById<ImageView>(R.id.ivPoster)
                ivPoster.setImageResource(posterID[p0])

                dlg.setTitle("큰 포스터")
                dlg.setIcon(R.drawable.ic_launcher)
                dlg.setView(dialogView)
                dlg.setNegativeButton("닫기", null)
                dlg.show()
            }
            return imageview
        }

        override fun getItem(p0: Int): Any {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return posterID.size
        }

    }
}