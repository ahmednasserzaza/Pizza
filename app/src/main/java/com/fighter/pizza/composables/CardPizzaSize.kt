package com.fighter.pizza.composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardPizzaSize(
    onClickSize: (Char) -> Unit,
    modifier: Modifier = Modifier,
    currentSize: Char,
    sizeState: Char
) {
    val cardElevation = animateDpAsState(targetValue = if (currentSize == sizeState) 6.dp else 0.dp)
    Card(
        onClick = { onClickSize(currentSize) },
        modifier = modifier
            .size(48.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = cardElevation.value)
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                modifier = Modifier,
                text = currentSize.toString(),
                fontSize = 20.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}