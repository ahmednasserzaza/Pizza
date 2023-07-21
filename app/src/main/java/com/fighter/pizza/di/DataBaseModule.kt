package com.fighter.pizza.di

import android.content.Context
import androidx.annotation.DrawableRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataBaseModule @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun getDrawable(@DrawableRes value: Int): Int {
        return value
    }
}