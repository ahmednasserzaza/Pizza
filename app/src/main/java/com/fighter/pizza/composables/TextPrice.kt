package com.fighter.pizza.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextPrice(price: String) {
    Text(
        modifier = Modifier.padding(top = 24.dp),
        text = price,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium
    )
}