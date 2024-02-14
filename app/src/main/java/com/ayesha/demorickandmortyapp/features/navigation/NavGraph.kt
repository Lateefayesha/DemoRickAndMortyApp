package com.ayesha.demorickandmortyapp.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ayesha.demorickandmortyapp.features.component.RickAndMortyBottomAppBar
import com.ayesha.demorickandmortyapp.features.component.RickAndMortyFloatingActionBar
import com.ayesha.demorickandmortyapp.features.component.RickAndMortyScaffold
import com.ayesha.demorickandmortyapp.features.screen.character_details.navigateCharactersDetail
import com.ayesha.demorickandmortyapp.features.screen.characters.navigation.characterNavigationRoute
import com.ayesha.demorickandmortyapp.features.screen.characters.navigation.charactersScreen
import com.ayesha.demorickandmortyapp.utils.Utility.toJson
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(){
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination = navController
        .currentBackStackEntryAsState().value?.destination

    RickAndMortyScaffold(
        bottomBar = {
            BottomNav.values().forEach { navItem ->
                if (navItem.rout == currentRoute) {
                    RickAndMortyBottomAppBar(
                        navController = navController,
                        currentDestination = currentDestination
                    )
                }
            }
        },
        floatingActionButton = {
            BottomNav.values().forEach { navItem ->
                if (navItem.rout == currentRoute) {
                    RickAndMortyFloatingActionBar(
                        navController = navController,
                    )
                }
            }
        },
        backgroundColor = MaterialTheme.colorScheme.background,
    ) {
            innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = characterNavigationRoute,
            Modifier.padding(innerPadding)
        ) {
            charactersScreen { navController.navigateCharactersDetail(it.toJson()) }
//            charactersDetailScreen { navController.navigateUp() }
//            episodesScreen()
//            searchScreen { navController.navigateCharactersDetail(it.toJson()) }
//            settingsScreen()
           // favoritesScreen { navController.navigateCharactersDetail(it.toJson()) }
        }
    }
}
