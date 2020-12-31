package com.wp.browse_track

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import com.wp.browse_track.model.BrowseTrackInfo
import kotlin.collections.ArrayList

/**
 * create by WangPing
 * on 2020/12/31
 */
object BrowseTrackHelper {
    //已存在的页面
    private val existPageList: ArrayList<Any> = ArrayList()
    private val pageMap: MutableMap<Activity, BrowseTrackInfo> = HashMap()
    private val browseTrackList: ArrayList<BrowseTrackInfo> = ArrayList()
    fun init(context: Context) {
        val app = (context.applicationContext as? Application)
        if (app == null) {
            Log.e(this.logTag, "传递进来的context不是Application,无法正常使用")
        } else {
            registerActivityLifecycleCallbacks(app)
        }
    }

    private fun registerActivityLifecycleCallbacks(app: Application) {
        app.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacksAdapter() {
            override fun onActivityResumed(activity: Activity) {
                val pageInfo = activity.getPageInfo()
                val isReturn = existPageList.contains(activity)
                val trackInfo = BrowseTrackInfo(
                    currentPageId = pageInfo.pageId,
                    currentPageName = pageInfo.pageName,
                    startPageTime = System.currentTimeMillis(),
                    isReturn = isReturn,
                    browseTime = -1L
                )
                browseTrackList.add(trackInfo)
                if (!isReturn) {
                    existPageList.add(activity)
                }
                pageMap[activity] = trackInfo
            }

            override fun onActivityPaused(activity: Activity) {
                val browseTrackInfo = pageMap[activity]
                browseTrackInfo?.let {
                    it.browseTime = (System.currentTimeMillis() - it.startPageTime) / 1000L
                }
            }

            override fun onActivityDestroyed(activity: Activity) {
                existPageList.remove(activity)
                pageMap.remove(activity)
            }
        })
    }

    fun getUserBrowseTrack(): List<BrowseTrackInfo> {
        return browseTrackList.toList()
    }
}