package com.fighter.pizza.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.fighter.pizza.ui.theme.CardToppingColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardPizzaIngredient(
    modifier: Modifier = Modifier,
    painter: Painter,
    index: Int,
    currentPage: Int,
    onUpdateToppingsState: (Index: Int , currentPage:Int , isSelected:Boolean) -> Unit,
    isSelected: Boolean,
) {
    val cardColor = animateColorAsState(targetValue = if (!isSelected) CardToppingColor else Color.Transparent)
    Card(
        onClick = {
            onUpdateToppingsState(index , currentPage  ,isSelected)
        },
        modifier = modifier.size(60.dp),
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = cardColor.value)
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                modifier = Modifier.size(48.dp),
                painter = painter,
                contentDescription = "",
                alignment = Alignment.Center
            )
        }
    }
}

