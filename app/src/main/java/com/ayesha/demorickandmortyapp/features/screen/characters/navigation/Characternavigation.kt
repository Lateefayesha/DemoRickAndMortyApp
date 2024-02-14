@file:OptIn(ExperimentalAnimationApi::class)

package com.ayesha.demorickandmortyapp.features.screen.characters.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable


import com.ayesha.demorickandmortyapp.data.data.model.dto.CharacterDto
import com.ayesha.demorickandmortyapp.features.screen.characters.CharactersScreen


const val characterNavigationRoute = "characters_route"

fun NavController.navigateCharacter(
    navOptions: NavOptions?=null
){
    this.navigate(characterNavigationRoute,navOptions)

}
fun NavGraphBuilder.charactersScreen(navigateToDetail: (CharacterDto?) -> Unit) {
    composable(characterNavigationRoute) {
        CharactersScreen(
            hiltViewModel(),
            navigateToDetail = {
                navigateToDetail.invoke(it)
            }
        )
    }
}
