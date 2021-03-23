package com.example.movieposterview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "갤러리 영화 포스터"

        var gallery = findViewById<Gallery>(R.id.gallery1)
        var galAdapter = MyGalleryAdapter(this)
        gallery.adapter = galAdapter
    }


    inner class MyGalleryAdapter(var context: Context) : BaseAdapter() {
        var posterID = arrayOf(
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,
                R.drawable.mov10 )
        var posterTitle = arrayOf(
                "써니", "완득이", "괴물", "라디오스타", "비열한 거리", "왕의 남자", "아일랜드", "웰컴투 동막골", "헬보이", "백투더퓨" )

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var imageview = ImageView(context)
            imageview.layoutParams = Gallery.LayoutParams(200, 300)
            imageview.scaleType = ImageView.ScaleType.FIT_CENTER
            imageview.setPadding(5, 5, 5, 5)
            imageview.setImageResource(posterID[p0])

            imageview.setOnTouchListener { v, event ->
                var ivPoster = findViewById<ImageView>(R.id.ivPoster)
                ivPoster.scaleType = ImageView.ScaleType.FIT_CENTER
                ivPoster.setImageResource(posterID[p0])
                var toast1 = Toast(this@MainActivity)
                var viewToast = View.inflate(this@MainActivity, R.layout.toast1, null)
                var tv1 = viewToast.findViewById<TextView>(R.id.textView1)
                tvToast.text = posterTitle[p0]
                toast1.view = viewToast
                toast1.show()
                false
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