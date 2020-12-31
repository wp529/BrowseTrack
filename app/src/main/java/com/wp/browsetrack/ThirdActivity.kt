package com.wp.browsetrack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wp.browse_track.BrowseTrackHelper
import com.wp.browse_track.annotation.PageInfo
import kotlinx.android.synthetic.main.activity_test.*

@PageInfo(pageId = "ThirdActivity", pageName = "第三个页面")
class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        btnGetBrowseTrack.setOnClickListener {
            BrowseTrackHelper.getUserBrowseTrack().forEach {
                Log.i("BrowseTrack", it.toString())
            }
        }
    }
}