package com.example.ahyoungapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Recommendation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation)

        var btnCoffee = findViewById<Button>(R.id.btnCoffee)
        var btnBotanical = findViewById<Button>(R.id.btnBotanical)
        var btnPark = findViewById<Button>(R.id.btnPark)
        var btnPizza = findViewById<Button>(R.id.btnPizza)
        var btnBeer = findViewById<Button>(R.id.btnBeer)
        var btnShopping = findViewById<Button>(R.id.btnShopping)
        var btnBurger = findViewById<Button>(R.id.btnBurger)

        btnCoffee.setOnClickListener {
            var uri = Uri.parse("geo:59.3294862,18.0655937?q=" + Uri.encode("Bagdad Café Stockholm"))
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        btnBotanical.setOnClickListener {
            var uri = Uri.parse("geo:59.3688308,18.0433558?q=" + Uri.encode("Victoriahuset"))
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        btnPark.setOnClickListener {
            var uri = Uri.parse("geo:59.3502119,17.8549832?q=" + Uri.encode("Kanaans trädgårdscafe"))
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        btnPizza.setOnClickListener {
            var uri = Uri.parse("geo:59.3378889,18.0798637?q=" + Uri.encode("Meno Male Östermalm 47"))
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        btnBeer.setOnClickListener {
            var uri = Uri.parse("geo:59.314595,18.0699439?q=" + Uri.encode("Carmen Tjärhovsgatan"))
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        btnShopping.setOnClickListener {
            var uri = Uri.parse("geo:59.314595,18.0699439?q=" + Uri.encode("Mall of Scandinavia"))
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        btnBurger.setOnClickListener {
            var uri = Uri.parse("geo:59.3348269,18.0612893?q=" + Uri.encode("MAX Kungsgatan"))
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}