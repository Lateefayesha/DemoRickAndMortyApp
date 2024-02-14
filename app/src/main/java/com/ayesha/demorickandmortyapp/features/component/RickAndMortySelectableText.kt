package com.ayesha.demorickandmortyapp.features.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ayesha.demorickandmortyapp.R

@Composable
fun RickAndMortySelectableText(
    modifier: Modifier,
    text: String = "",
    isSelected: Boolean?,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    onClick: () -> Unit = {}

) {
    val bgColor = if (isSelected == true) colorResource(id = R.color.teal_700)
    else colorResource(id = R.color.black)
    val textColor = if (isSelected == true)
        Color.White else MaterialTheme.colorScheme.primary
    RickAndMortyText(
        text = text,
        color = textColor,
        style = style,
        modifier = modifier
            .clickable { onClick() }
            .background(
                color = bgColor,
                shape = RoundedCornerShape(14.dp)

            )
            .height(50.dp)
            .wrapContentSize()
    )

}

@Composable
@Preview
private fun bodyPreview() {
    RickAndMortySelectableText(modifier = Modifier.fillMaxWidth(),
        isSelected = false,
        text = "Text",
        onClick = {})
}



