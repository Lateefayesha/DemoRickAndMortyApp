package com.ayesha.demorickandmortyapp.features.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ayesha.demorickandmortyapp.R

@Composable
fun RickAndMortyEpisodesCard(
    modifier: Modifier = Modifier,
    name :String,
    date: String,
    episode :String,
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape= RoundedCornerShape(8.dp),
    ){
       ConstraintLayout(
           modifier = modifier.padding(horizontal = 10.dp ,vertical= 10.dp)){
           val (title, textDate, textEpisode, image) = createRefs()
           RickAndMortyText(
               modifier = Modifier.constrainAs(title) {
                 top.linkTo(parent.top)
                 start.linkTo(parent.start)
               },
               text = "Episode Name :$name",
               style = MaterialTheme.typography.titleMedium,
               color = MaterialTheme.colorScheme.onBackground
           )
           RickAndMortyText(
               modifier = Modifier.constrainAs(textDate){
                     top.linkTo(title.bottom)
                   start.linkTo(parent.start)
               },
            text = "Date:$date",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
           )

           RickAndMortyText(
               modifier = Modifier.constrainAs(textEpisode){
                   top.linkTo(textDate.bottom)
                   start.linkTo(parent.start)
               },
               text = "Episode $episode",
               style = MaterialTheme.typography.titleMedium,
               color = MaterialTheme.colorScheme.onBackground,
           )

           Image(
               modifier = Modifier.constrainAs(image){
                   top.linkTo(parent.top, margin = 16.dp)
                   bottom.linkTo(parent.bottom, margin = 24.dp)
                   end.linkTo(parent.end)
               },
               painter = painterResource(id = R.drawable.ic_arrow_tight_icon),
               contentDescription = null,
               contentScale = ContentScale.Inside
           )
       }
    }

}

@Preview(showBackground = true)
@Composable
private fun BodyPreview() {
    RickAndMortyEpisodesCard(
        modifier = Modifier,
        name = "Rick and Morty",
        date = "2020-03-19",
        episode = "S01E01",
    )
}