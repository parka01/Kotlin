package com.example.tabhost

import android.app.TabActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
@Suppress("deprecation")
class MainActivity : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabHost = this.tabHost

//        var tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별")
//        tabSpecSong.setContet(R.id.tabSong)
//        tabHost.addTab(tabSpecSong)
//
//        var tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별")
//        tabSpecArtist.setConent(R.id.tabArtist)
//        tabHost.addTab(tabSpecArtist)
//
//        var tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별")
//        tabSpecArtist.setConent(R.id.tabAlbum)
//        tabHost.addTab(tabSpecAlbum)

        var tabSpec1 = tabHost.newTabSpec("TAB1").setIndicator("안드로이드1")
        tabSpec1.setContent(R.id.tab1)
        tabHost.addTab(tabSpec1)

        var tabSpec2 = tabHost.newTabSpec("TAB2").setIndicator("안드로이드2")
        tabSpec1.setContent(R.id.tab2)
        tabHost.addTab(tabSpec2)

        var tabSpec3 = tabHost.newTabSpec("TAB3").setIndicator("안드로이드3")
        tabSpec1.setContent(R.id.tab3)
        tabHost.addTab(tabSpec3)

        var tabSpec4 = tabHost.newTabSpec("TAB4").setIndicator("안드로이드4")
        tabSpec1.setContent(R.id.tab4)
        tabHost.addTab(tabSpec4)

        var tabSpec5 = tabHost.newTabSpec("TAB5").setIndicator("안드로이드5")
        tabSpec1.setContent(R.id.tab5)
        tabHost.addTab(tabSpec5)

        tabHost.currentTab = 0
    }
}