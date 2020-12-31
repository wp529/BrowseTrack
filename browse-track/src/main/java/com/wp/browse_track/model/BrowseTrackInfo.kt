package com.wp.browse_track.model

import java.text.SimpleDateFormat
import java.util.*


data class BrowseTrackInfo(
    val currentPageId: String,
    val currentPageName: String,
    val startPageTime: Long,
    val isReturn: Boolean,
    var browseTime: Long
) {
    override fun toString(): String {
        return if (isReturn) {
            "用户在${SimpleDateFormat(
                "yyyy/MM/dd hh:mm:ss",
                Locale.CHINA
            ).format(startPageTime)}回到了$currentPageName,${
            if (browseTime == -1L) {
                "还没有离开"
            } else {
                "回来后又呆了${browseTime}秒"
            }
            }"
        } else {
            "用户在${SimpleDateFormat(
                "yyyy/MM/dd hh:mm:ss",
                Locale.CHINA
            ).format(startPageTime)}进入了$currentPageName,${
            if (browseTime == -1L) {
                "还没有离开"
            } else {
                "进来后呆了${browseTime}秒"
            }
            }"
        }
    }
}