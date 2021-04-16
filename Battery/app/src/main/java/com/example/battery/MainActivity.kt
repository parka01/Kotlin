package com.example.battery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var ivBattery : ImageView
    lateinit var edtBattery : EditText
    lateinit var alert : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.icon)
        title = "충전 알리미 앱🛸"

        ivBattery = findViewById<ImageView>(R.id.ivBattery)
        edtBattery = findViewById<EditText>(R.id.edtBattery)
        alert = findViewById<TextView>(R.id.alert)
    }
    var br : BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            var action = intent.action
            if (action == Intent.ACTION_BATTERY_CHANGED) {
                var remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                edtBattery.setText("현재 충전량 : $remain\n")

                if (remain >= 90) {
                    ivBattery.setImageResource(R.drawable.battery_100)
                    alert.text = "완전 안심!"
                }
                else if (remain >= 70) {
                    ivBattery.setImageResource(R.drawable.battery_80)
                    alert.text = "안정권입니다."
                }
                else if (remain >= 50){
                    ivBattery.setImageResource(R.drawable.battery_60)
                    alert.text = "충전기를 미리 찾아두세요!!"
                }
                else if (remain >= 10) {
                    ivBattery.setImageResource(R.drawable.battery_20)
                    alert.text = "위급시를 대비하여 배터리를 아끼세요!! 휴대폰이 다운되기 10분 전"
                }
                else {
                    ivBattery.setImageResource(R.drawable.battery_0)
                    alert.text = "겨울이면 10초이내 꺼질 확률 높음!"
                }

                var plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0)
                when (plug) {
                    0 -> edtBattery.append("전원 연결 : 안됨")
                    BatteryManager.BATTERY_PLUGGED_AC ->
                        edtBattery.append("전원 연결 : 어댑터 연결됨")
                    BatteryManager.BATTERY_PLUGGED_USB ->
                        edtBattery.append("전원 연결 : USB 연결됨")

                }
            }

        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(br)
    }

    override fun onResume() {
        super.onResume()
        var iFilter = IntentFilter()
        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(br, iFilter)
    }
}