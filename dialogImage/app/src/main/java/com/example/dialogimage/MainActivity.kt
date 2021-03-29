package com.example.dialogimage

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        class CustomDialogClass(context: Context) : Dialog(context) {

            init {
                setCancelable(false)
            }

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setContentView(R.layout.custom_dialog)

            }
        }
    }
}