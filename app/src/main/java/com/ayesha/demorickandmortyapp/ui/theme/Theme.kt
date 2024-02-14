package com.ayesha.demorickandmortyapp.ui.theme

import android.app.Activity
import android.os.Build
import android.widget.TextView
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = PaleViolet,
    onPrimary = VeryDarkViolet,
    secondary = LightGrayishViolet90,
    onSecondary = VeryDarkGrayishViolet40,
    error = VerySoftRed,
    onError = VeryDarkRed,
    background = VeryDarkBlue,
    onBackground = LightGrayishMagenta,
    surface = VeryDarkBlue,
    onSurface = LightGrayishMagenta,
)

private val LightColorScheme = lightColorScheme(
    primary = DarkModerateViolet,
    onPrimary = White,
    secondary = VeryDarkGrayishViolet,
    onSecondary = LightGrayishViolet,
    error = StrongRed,
    onError = White,
    background = PaleGray,
    onBackground = VeryDarkBlue,
    surface = White,
    onSurface = LightGrayishMagenta,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun DemoRickAndMortyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+

    content: @Composable () -> Unit
) {
    val colors = if(darkTheme){
        DarkColorScheme
    }else{
        LightColorScheme
    }
//    val colorScheme = when {
//        colors && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}