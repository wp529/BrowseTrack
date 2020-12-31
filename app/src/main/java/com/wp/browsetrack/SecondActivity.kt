package com.wp.browsetrack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wp.browse_track.BrowseTrackHelper
import com.wp.browse_track.annotation.PageInfo
import kotlinx.android.synthetic.main.activity_test.*

@PageInfo(pageId = "SecondActivity", pageName = "第二个页面")
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        btnGoNext.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
        btnGetBrowseTrack.setOnClickListener {
            BrowseTrackHelper.getUserBrowseTrack().forEach {
                Log.i("BrowseTrack", it.toString())
            }
        }
    }
}