package com.wp.browse_track

import android.app.Activity
import com.wp.browse_track.annotation.PageInfo

internal val Any.logTag
    get() = this.javaClass.simpleName

internal fun Activity.getPageInfo(): com.wp.browse_track.model.PageInfo {
    val clazz = this::class.java
    val annotation = clazz.getAnnotation(PageInfo::class.java)
    val pageId = if (annotation == null || annotation.pageId.isEmpty()) {
        //没有注解值,pageId为类全路径
        clazz.name
    } else {
        annotation.pageId
    }
    val pageName = if (annotation == null || annotation.pageName.isEmpty()) {
        //没有注解值,pageName为类名
        clazz.simpleName
    } else {
        annotation.pageName
    }
    return com.wp.browse_track.model.PageInfo(pageId, pageName)
}