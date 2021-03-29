package com.example.googoodan
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Random;
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.icon)
        lateinit var et1 : EditText
        lateinit var et2 : EditText
        lateinit var et3 : EditText

        lateinit var btnCreate : Button
        lateinit var btnSubmit : Button

        et1 = findViewById<EditText>(R.id.et1)
        et2 = findViewById<EditText>(R.id.et2)
        et3 = findViewById<EditText>(R.id.et3)

        btnCreate = findViewById<Button>(R.id.btnCreate)
        btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnCreate.setOnClickListener {
            var rand1 = Random().nextInt(8)+2
            var rand2 = Random().nextInt(8)+2
                et1.setText(rand1.toString())
                et2.setText(rand2.toString())
        }

        btnSubmit.setOnClickListener {
            var str1 = et1.text.toString()
            var str2 = et2.text.toString()
            var str3 = et3.text.toString()

            if(str1 == "" || str2 == "" || str3 == "")
            {
                Toast.makeText(applicationContext, "빈값입니다!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var a1 = Integer.parseInt(str1)
            var a2 = Integer.parseInt(str2)
            var a3 = Integer.parseInt(str3)
            var a4 = a1*a2

            if(a3 == a4)
            {
                Toast.makeText(applicationContext, "정답입니다!", Toast.LENGTH_SHORT).show()
            } else
            {
                Toast.makeText(applicationContext, "틀렸습니다!", Toast.LENGTH_SHORT).show()
                if(a1 == 1)
                {
                    val arrayAdapter: ArrayAdapter<*>
                    val danOne = arrayOf(
                        "1*1=1", "1*2=2", "1*3=3", "1*4=4", "1*5=5", "1*6=6", "1*7=7", "1*8=8", "1*9=9"
                    )
                    var listing = findViewById<ListView>(R.id.list1)
                    arrayAdapter = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, danOne)
                    listing.adapter = arrayAdapter
                } else if(a1 == 2)
                {
                    val arrayAdapter: ArrayAdapter<*>
                    val danTwo = arrayOf(
                        "2*1=2", "2*2=4", "2*3=6", "2*4=8", "2*5=10", "2*6=12", "2*7=14", "2*8=16", "2*9=18"
                    )
                    var listing = findViewById<ListView>(R.id.list1)
                    arrayAdapter = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, danTwo)
                    listing.adapter = arrayAdapter
                } else if(a1 == 3)
                {
                    val arrayAdapter: ArrayAdapter<*>
                    val danThree = arrayOf(
                        "3*1=3", "3*2=6", "3*3=9", "3*4=12", "3*5=15", "3*6=18", "3*7=21", "3*8=24", "3*9=27"
                    )
                    var listing = findViewById<ListView>(R.id.list1)
                    arrayAdapter = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, danThree)
                    listing.adapter = arrayAdapter
                } else if(a1 == 4)
                {
                    val arrayAdapter: ArrayAdapter<*>
                    val danFour = arrayOf(
                        "4*1=4", "4*2=8", "4*3=12", "4*4=16", "4*5=20", "4*6=24", "4*7=28", "4*8=32", "4*9=36"
                    )
                    var listing = findViewById<ListView>(R.id.list1)
                    arrayAdapter = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, danFour)
                    listing.adapter = arrayAdapter
                } else if(a1 == 5)
                {
                    val arrayAdapter: ArrayAdapter<*>
                    val danFive = arrayOf(
                        "5*1=5", "5*2=10", "5*3=15", "5*4=20", "5*5=25", "5*6=30", "5*7=35", "5*8=40", "5*9=45"
                    )
                    var listing = findViewById<ListView>(R.id.list1)
                    arrayAdapter = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, danFive)
                    listing.adapter = arrayAdapter
                } else if(a1 == 6)
                {
                    val arrayAdapter: ArrayAdapter<*>
                    val danFive = arrayOf(
                        "6*1=6", "6*2=12", "6*3=18", "6*4=24", "6*5=30", "6*6=36", "6*7=42", "6*8=48", "6*9=54"
                    )
                    var listing = findViewById<ListView>(R.id.list1)
                    arrayAdapter = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, danFive)
                    listing.adapter = arrayAdapter
                } else if(a1 == 7)
                {
                    val arrayAdapter: ArrayAdapter<*>
                    val danSeven = arrayOf(
                        "7*1=7", "7*2=14", "7*3=21", "7*4=28", "7*5=35", "7*6=42", "7*7=49", "7*8=56", "7*9=63"
                    )
                    var listing = findViewById<ListView>(R.id.list1)
                    arrayAdapter = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, danSeven)
                    listing.adapter = arrayAdapter
                } else if(a1 == 8)
                {
                    val arrayAdapter: ArrayAdapter<*>
                    val danEight = arrayOf(
                        "8*1=8", "8*2=16", "8*3=24", "8*4=32", "8*5=40", "8*6=48", "8*7=56", "8*8=64", "8*9=72"
                    )
                    var listing = findViewById<ListView>(R.id.list1)
                    arrayAdapter = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, danEight)
                    listing.adapter = arrayAdapter
                } else if(a1 == 9)
                {
                    val arrayAdapter: ArrayAdapter<*>
                    val danNine = arrayOf(
                        "9*1=9", "9*2=18", "9*3=27", "9*4=36", "9*5=45", "9*6=54", "9*7=63", "9*8=72", "9*9=81"
                    )
                    var listing = findViewById<ListView>(R.id.list1)
                    arrayAdapter = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, danNine)
                    listing.adapter = arrayAdapter
                }
            }
        }
    }
}