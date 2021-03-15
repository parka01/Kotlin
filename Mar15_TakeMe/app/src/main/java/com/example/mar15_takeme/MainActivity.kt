package com.example.mar15_takeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var edtUrl : EditText
    lateinit var btnGo : Button
    lateinit var btnBack : Button
    lateinit var web : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        getSupportActionBar()!!.setIcon(R.drawable.web)

        edtUrl = findViewById<EditText>(R.id.edtUrl)
        btnGo = findViewById<Button>(R.id.btnGo)
        btnBack = findViewById<Button>(R.id.btnBack)
        web = findViewById<WebView>(R.id.webView1)

        //웹뷰 위젯은 코틀린 객체로 생성해서 연결해서 만든다.(이것이 웹뷰 클라이언트)
        web.webViewClient = CookWebViewClient()

        var webSet = web.settings
        webSet.builtInZoomControls = true

        btnGo.setOnClickListener() {
            web.loadUrl(edtUrl.text.toString())
        }
        btnBack.setOnClickListener() {
            web.goBack()
        }
    }

    class CookWebViewClient : WebViewClient()
    {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return super.shouldOverrideUrlLoading(view, url)
        }
    }
}