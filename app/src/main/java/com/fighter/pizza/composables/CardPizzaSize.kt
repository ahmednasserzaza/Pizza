package com.fighter.pizza.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fighter.pizza.data.entity.PizzaSize
import com.fighter.pizza.screens.pizza.HomeUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardPizzaSize(
    modifier: Modifier = Modifier,
    size: String,
    updatePizzaSize: (PizzaSize) -> Unit,
    sizeChar: Char,
) {
    val cardElevation = animateDpAsState(targetValue = if (sizeChar.toString() == size) 6.dp else 0.dp  )
    Card(
        onClick = {
            when (size) {
                "S" -> {
                    updatePizzaSize(PizzaSize.Small)
                }
                "M" -> {
                    updatePizzaSize(PizzaSize.Medium)
                }
                "L" -> {
                    updatePizzaSize(PizzaSize.Large)
                }
            }
        },
        modifier = modifier
            .size(48.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = cardElevation.value)
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                modifier = Modifier,
                text = size,
                fontSize = 20.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}