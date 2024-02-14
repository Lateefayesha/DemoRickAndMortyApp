package com.ayesha.demorickandmortyapp.features.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.os.trace
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions
import com.ayesha.demorickandmortyapp.R
import com.ayesha.demorickandmortyapp.features.favorites.navigateToFavorites
import com.ayesha.demorickandmortyapp.features.navigation.BottomNav
import com.ayesha.demorickandmortyapp.features.screen.characters.navigation.navigateCharacter

@Composable
fun RickAndMortyBottomAppBar(
    navController: NavController,
    currentDestination: NavDestination?,
){
    BottomAppBar(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp
                )
            ),
//        cutoutShape = CircleShape,
        tonalElevation = 10.dp,
        containerColor = MaterialTheme.colorScheme.onSecondary
    ) {
        BottomNav.values().forEach { screen ->
            val selected = currentDestination.isBottomNavDestinationInHierarchy(screen)
            val primaryColor = MaterialTheme.colorScheme.primary
            val secondaryColor = MaterialTheme.colorScheme.secondary

            BottomNavigationItem(
                alwaysShowLabel = true,
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.secondary,
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = screen.iconId),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },

                label = {
                    RickAndMortyText(
                        text = if (screen.titleTextId == R.string.favorite_screen_title) "" else stringResource(
                            id = screen.titleTextId
                        ),
                        color = if (selected) primaryColor else secondaryColor,
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                },
                selected = selected,
                onClick = {
                    navigateToBottomNavDestination(screen, navController)
                }
            )
        }
    }
}

fun navigateToBottomNavDestination(bottomNav: BottomNav, navController: NavController) {
    trace("Navigation: ${bottomNav.name}") {
        val bottomNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (bottomNav) {
            BottomNav.CHARACTERS -> navController.navigateCharacter(bottomNavOptions)
//            BottomNav.EPISODES -> navController.navigateToEpisodes(bottomNavOptions)
//            BottomNav.FAVORITES -> navController.navigateToFavorites(bottomNavOptions)
//            BottomNav.SEARCH -> navController.navigateToSearch(bottomNavOptions)
//            BottomNav.SETTINGS -> navController.navigateToSettings(bottomNavOptions)
        }
    }
}

private fun NavDestination?.isBottomNavDestinationInHierarchy(destination: BottomNav) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
