package com.fighter.pizza.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun PlateImage(painter: Painter){
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painter,
        contentDescription = "",
    )
}