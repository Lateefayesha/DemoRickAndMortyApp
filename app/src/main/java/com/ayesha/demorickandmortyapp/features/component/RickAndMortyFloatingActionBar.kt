package com.ayesha.demorickandmortyapp.features.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.ayesha.demorickandmortyapp.features.favorites.favoritesNavigationRoute
import com.ayesha.demorickandmortyapp.utils.Utility.getAnimateFloat
import kotlinx.coroutines.delay

@Composable
fun RickAndMortyFloatingActionBar(
    navController: NavController,
){
var isClick by remember { mutableStateOf(false) }

   LaunchedEffect(isClick){
       if(isClick){
           delay(800)
           isClick=false
       }
   }

    FloatingActionButton(onClick = {
        isClick =true
        navController.navigate(favoritesNavigationRoute){
            popUpTo(navController.graph.findStartDestination().id){
                saveState =true
            }
        }

    },
        contentColor = Color.White,
        containerColor = Color.White,
        shape = CircleShape,
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier.size(if (isClick)
                getAnimateFloat().value.dp else 24.dp
                )


        )

    }
}