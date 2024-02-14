package com.ayesha.demorickandmortyapp

import android.app.Application
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

@Stable
@HiltAndroidApp
class RickAndMortyApp : Application() {
    var isDark = mutableStateOf(false)

    /**
     * Function Theme Used at setting page for change theme
     */
    fun toggleTheme(){
        isDark.value = !isDark.value
    }
}