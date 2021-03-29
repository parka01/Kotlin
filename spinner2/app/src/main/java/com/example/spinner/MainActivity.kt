package com.example.spinner

import android.R
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class MainActivity : Activity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dialog = AlertDialog.Builder(this@MainActivity)
        dialog.setView(R.layout.custom_dialog)
        dialog.setTitle("Custom Dialog")
        val tv = dialog.findViewById(R.id.text) as TextView
        tv.text = "Hello. This is a Custom Dialog !"
        val iv: ImageView = dialog.findViewById(R.id.image) as ImageView
        iv.setImageResource(R.drawable.weight)
        dialog.show()
    }
}