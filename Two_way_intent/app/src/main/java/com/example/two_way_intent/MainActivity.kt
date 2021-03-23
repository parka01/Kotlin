package com.example.two_way_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "메인 액티비티"

        var rdoGroup = findViewById<RadioGroup>(R.id.rdoGroup)

        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)
        btnNewActivity.setOnClickListener {
            var edtNum1 = findViewById<EditText>(R.id.edtNum1)
            var edtNum2 = findViewById<EditText>(R.id.edtNum2)

            var intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("Num1", Integer.parseInt(edtNum1.text.toString()))
            intent.putExtra("Num2", Integer.parseInt(edtNum2.text.toString()))

            when(rdoGroup.checkedRadioButtonId)
            {
                R.id.rdoPlus -> intent.putExtra("Operator", "+")
                R.id.rdoMinus -> intent.putExtra("Operator", "-")
                R.id.rdoMulti -> intent.putExtra("Operator", "*")
                R.id.rdoDiv -> intent.putExtra("Operator", "/")
            }

//            intent.putExtra("Operator", "+")
//            intent.putExtra("Operator", "-")
//            intent.putExtra("Operator", "*")
//            intent.putExtra("Operator", "/")
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            var hap = data!!.getIntExtra("Hap", 0)
            Toast.makeText(applicationContext, "합계: $hap", Toast.LENGTH_LONG).show()
        }
    }
}