package com.wp.browsetrack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wp.browse_track.BrowseTrackHelper
import com.wp.browse_track.annotation.PageInfo
import kotlinx.android.synthetic.main.activity_main.*

@PageInfo(pageId = "MainActivity", pageName = "首页")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("WP","66")
        btnGoNext.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }
        btnGetBrowseTrack.setOnClickListener {
            BrowseTrackHelper.getUserBrowseTrack().forEach {
                Log.i("BrowseTrack", it.toString())
            }
        }
    }
}