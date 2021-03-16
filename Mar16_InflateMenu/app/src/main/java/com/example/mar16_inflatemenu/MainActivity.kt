package com.example.mar16_inflatemenu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    lateinit var baseLayout: RelativeLayout
    lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "외계인 바꾸기"
        baseLayout = findViewById<RelativeLayout>(R.id.baseLayout)
        image = findViewById<ImageView>(R.id.image)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        var mInflater = menuInflater
        mInflater.inflate(R.menu.menufile, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when (item.itemId)
        {
            R.id.item1 -> {
                image.setBackgroundResource(R.drawable.alien)
                return true
            }
            R.id.item2 -> {
                image.setBackgroundResource(R.drawable.alien2)
                return true
            }
            R.id.item3 -> {
                image.setBackgroundResource(R.drawable.alien3)
                return true
            }
            R.id.rotate -> {
                image.rotation = 45f
                return true
            }
        }
        return false
    }
}