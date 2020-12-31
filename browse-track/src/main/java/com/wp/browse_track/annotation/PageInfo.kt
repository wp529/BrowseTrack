package com.wp.browse_track.annotation

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class PageInfo(
    val pageId: String,
    val pageName: String
)