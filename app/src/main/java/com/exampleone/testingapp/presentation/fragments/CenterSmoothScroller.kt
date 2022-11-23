package com.exampleone.testingapp.presentation.fragments

import android.content.Context
import android.util.DisplayMetrics
import androidx.recyclerview.widget.LinearSmoothScroller

open class CenterSmoothScroller(context: Context): LinearSmoothScroller(context){

    val MILLISECONDS_PER_INCH = 100f;


    override fun calculateDtToFit(
        viewStart: Int,
        viewEnd: Int,
        boxStart: Int,
        boxEnd: Int,
        snapPreference: Int
    ): Int {
        return (boxStart + (boxEnd - boxStart) / 2) - (viewStart + (viewEnd - viewStart) / 2);
    }

    override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics?): Float {
        return MILLISECONDS_PER_INCH / displayMetrics?.densityDpi as Int
    }
}