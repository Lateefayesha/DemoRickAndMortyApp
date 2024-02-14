package com.ayesha.demorickandmortyapp.features.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun RickAndMortyEpisodesShimmer(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(8.dp),

        ) {
        Row(
            modifier = Modifier
                    .shimmer().padding(vertical = 10.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 24.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround

            ) {
                RickAndMortyText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray),
                    text = "",
                    style = MaterialTheme.typography.titleMedium,
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

                RickAndMortyText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray),
                    text = "",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary,
                )

                Box(
                    contentAlignment = Alignment.CenterEnd,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(24.dp)
                        .background(color = Color.LightGray)
                ) {
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .width(24.dp)
                            .background(color = Color.LightGray)
                    ) {
                    }
                }
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
private fun BodyPreview() {
    RickAndMortyEpisodesShimmer(
        modifier = Modifier,
    )
}