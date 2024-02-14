package com.ayesha.demorickandmortyapp.features.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun RickAndMortyAlertDialog(
    isDisplayed: Boolean,
    onClickDelete: () -> Unit,
    onBackPressed: () -> Unit,
){
    if (isDisplayed) {
        Dialog(
            onDismissRequest = { }
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .clip(shape = RoundedCornerShape(20.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    RickAndMortyText(
                        text = "Favorite Delete",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    RickAndMortyText(
                        text = "Do you approve to delete this favorite?",
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        RickAndMortyButton(
                            onCLick = { onClickDelete() },
                            borderColors = MaterialTheme.colorScheme.error,
                            text = "Delete",
                            modifier = Modifier
                                .height(40.dp)
                                .weight(0.5f),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        RickAndMortyButton(
                            onCLick = { onBackPressed() },
                            borderColors = MaterialTheme.colorScheme.secondary,
                            text = "Cancel",
                            modifier = Modifier
                                .height(40.dp)
                                .weight(0.5f),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                        )
                    }
                }
            }
        }
    }
}