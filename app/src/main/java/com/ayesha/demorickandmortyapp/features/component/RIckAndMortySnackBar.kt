package com.ayesha.demorickandmortyapp.features.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.tooling.preview.Preview
import com.ayesha.demorickandmortyapp.R

@Composable
fun RickAndMortySnackBar(snackbarHostState: SnackbarHostState,
                          snackBarEnum: SnackBarEnum){

    SnackbarHost(snackbarHostState) { data ->
        Snackbar(
            containerColor = Color(integerResource(id = snackBarEnum.backgroundColor)),
            snackbarData = data,
            shape = MaterialTheme.shapes.medium
        )
    }
}

sealed class SnackBarEnum(val backgroundColor: Int) {
    //TODO("Add your own SnackBarEnum")
    object SUCCESS : SnackBarEnum(R.color.black)
    object ERROR : SnackBarEnum(R.color.black)
}


@Preview
@Composable
private fun BodyPreview(){
    val snackbarHostState = remember { SnackbarHostState() }
    RickAndMortySnackBar(
        snackbarHostState,
        SnackBarEnum.SUCCESS
    )
}