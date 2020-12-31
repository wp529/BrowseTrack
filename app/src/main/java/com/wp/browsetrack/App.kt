package com.wp.browsetrack

import android.app.Application
import com.wp.browse_track.BrowseTrackHelper

/**
 * create by WangPing
 * on 2020/12/31
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        BrowseTrackHelper.init(this)
    }
}