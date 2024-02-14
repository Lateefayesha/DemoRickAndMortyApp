package com.ayesha.demorickandmortyapp.features.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RickAndMortyButton(
    modifier: Modifier = Modifier,
    text : String,
    onCLick:()->Unit,
    colors: ButtonColors= ButtonDefaults.outlinedButtonColors(),
    borderColors: Color,
    enabled:Boolean = true,
){
    Button(
        onClick = {onCLick()},
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = enabled,
        colors = colors,
        shape = RoundedCornerShape(20),
        border = BorderStroke(
            width = 1.dp,
            color = borderColors
        ),
        content = {
            RickAndMortyText(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
        }
    )

}

@Preview
@Composable
private fun BodyPreview() {
    RickAndMortyButton(
        enabled = true,
        modifier = Modifier,
        onCLick = { } ,
        borderColors = MaterialTheme.colorScheme.primary,
        text = "Minima Button"
    )
}