package com.ayesha.demorickandmortyapp.features.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun RickAndMortyCharacterShimmer(
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
        .fillMaxWidth()
        .height(100.dp),
    shape = RoundedCornerShape(8.dp)
        ){
        Row(modifier= Modifier
            .shimmer()
            .size(100.dp)
            .padding(vertical = 10.dp))
        {
            Box(
                Modifier
                    .padding(start = 10.dp)
                    .fillMaxWidth()
                    .width(80.dp)
                    .clip(shape = RoundedCornerShape(15))
                    .background(color = Color.LightGray)


            ){

            }

            Column(
                modifier= Modifier
                    .padding(start = 10.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                RickAndMortyText(
                    modifier= Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray),
                    text = "",
                    style= MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )

                RickAndMortyText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray),
                    text = "",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary,
                )
                Row(verticalAlignment = Alignment.CenterVertically){
                    Card( modifier = Modifier.size(12.dp),
                        colors= CardDefaults.cardColors(),
                        shape = RoundedCornerShape(50)
                    ) {}
                    Spacer(modifier = Modifier.width(5.dp))
                    RickAndMortyText(
                    modifier = Modifier.fillMaxWidth()
                        .background(color = Color.LightGray),
                        text = "",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.secondary,
                    )
                }

            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun BodyPreview() {
    RickAndMortyCharacterShimmer(
        modifier = Modifier,
    )
}