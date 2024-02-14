package com.ayesha.demorickandmortyapp.features.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RickAndMortyTopBar(
    modifier: Modifier = Modifier,
    text : String,
    title : @Composable () -> Unit =  {
        RickAndMortyText(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.secondary,
            style =  MaterialTheme.typography.titleSmall
        )
    },
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = MaterialTheme.colorScheme.background,
    elevation: Dp = 0.dp


)
{
   SmallTopAppBar(
       title = title,
       modifier = modifier,
       navigationIcon = navigationIcon!!,
       actions = actions,
       colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = backgroundColor)
   )

}

/**
 *  backgroundColor = backgroundColor,
contentColor = contentColor,
elevation = elevation
 Not Added in material 3

 */