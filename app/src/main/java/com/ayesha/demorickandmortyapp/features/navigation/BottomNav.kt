package com.ayesha.demorickandmortyapp.features.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ayesha.demorickandmortyapp.R
import com.ayesha.demorickandmortyapp.features.favorites.favoritesNavigationRoute
import com.ayesha.demorickandmortyapp.features.screen.characters.navigation.characterNavigationRoute

enum class BottomNav(val rout :String ,
@DrawableRes val iconId:Int,
@StringRes val titleTextId:Int) {
    CHARACTERS(
        characterNavigationRoute,
        R.drawable.ic_outline_people,
        R.string.characters_screen_title,
    ),
//    EPISODES(
//        episodesNavigationRoute,
//        R.drawable.ic_baseline_movie_creation_24,
//        R.string.episodes_screen_title
//    ),
//    FAVORITES(
//        favoritesNavigationRoute,
//        R.drawable.ic_baseline_favorite_24,
//        R.string.favorite_screen_title,
//    ),
//    SEARCH(
//        searchNavigationRoute,
//        R.drawable.ic_baseline_search_24,
//        R.string.search_screen_title,
//    ),
//    SETTINGS(
//        settingsNavigationRoute,
//        R.drawable.ic_baseline_settings,
//        R.string.settings_screen_title
//    )
}