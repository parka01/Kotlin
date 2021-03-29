package com.example.imageindialog

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import com.example.my_exam_2_2.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var v : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        v = ActivityMainBinding.inflate(layoutInflater)
        setContentView(v.root)
        v.btncalBody.setOnClickListener {
            var height = v.height.text.toString()
            var weight = v.weight.text.toString()
            if((height == "" || height == null) || (weight == "" || weight == null)) {
                var alertBox = AlertDialog.Builder(this)
                var factory = LayoutInflater.from(this)
                var view = factory.inflate(R.layout.error, null)
                alertBox.setView(view)
                alertBox.setCustomTitle(factory.inflate(R.layout.customtitle, null))
                alertBox.show()
                return@setOnClickListener
            }

            v.height.text.toString().toFloat()
            var chkid = v.RadioGroup.checkedRadioButtonId
            var sex: String
            when(chkid) {
                R.id.fmale -> {
                    sex = "여자"
                }
                R.id.male -> {
                    sex = "남자"
                }
                else -> sex = "성별미정"
            }

            v.tvBloodtype.setText("1.${v.spinnerblood.selectedItem}형" +
                    " " + "${sex}입니다!")
            var calweight = v.weight.text.toString().toFloat()/((v.height.text.toString().toFloat()/100).pow(2))
            v.tvBWM.setText("2.신체질량지수는 ${calweight}입니다!")
            v.imgLinear.removeAllViewsInLayout()

            if(v.chkDrink.isChecked) {
                var img = ImageView(this)
                img.setImageResource(R.drawable.drinking);
                v.imgLinear.addView(img);
            }

            if(v.chkSmock.isChecked) {
                var img = ImageView(this)
                img.setImageResource(R.drawable.ciga);
                v.imgLinear.addView(img);
            }

            if(!v.chkexecsize.isChecked) {
                var img = ImageView(this)
                img.setImageResource(R.drawable.running)
                v.imgLinear.addView(img)
            }
        }
        v.imgLinear.setVerticalGravity(Gravity.CENTER_VERTICAL)
    }
}