package com.ayesha.demorickandmortyapp.features.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImagePainter
import coil.compose.rememberImagePainter
import coil.size.Size

@Composable
fun RickAndMortyNetworkImage(
    modifier: Modifier = Modifier,
    imageURL: Any?,
    placeholder : Int =0,
    contentDescription :String? = null,
    contentScale : ContentScale = ContentScale.Inside,
    crossFade:Boolean=false

){
    val painter = rememberImagePainter(data = imageURL,
    builder = {
        crossfade(crossFade)
        size(Size.ORIGINAL)
        error(placeholder)
        fallback(placeholder)
    },
    )
    Box {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = modifier
        )
        if (painter.state is AsyncImagePainter.State.Loading)
            CircularProgressIndicator(Modifier.align(Alignment.Center))
    }

}