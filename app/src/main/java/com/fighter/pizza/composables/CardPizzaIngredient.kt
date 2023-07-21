package com.fighter.pizza.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fighter.pizza.data.entity.Topping
import com.fighter.pizza.screens.pizza.HomeUiState
import com.fighter.pizza.ui.theme.CardToppingColor

@Composable
fun CardPizzaIngredient(
    modifier: Modifier = Modifier,
    topping: HomeUiState.ToppingUiState,
    updateToppingState: (type: Topping, isActive: Boolean) -> Unit,
) {
    val cardColor =
        animateColorAsState(targetValue = if (topping.isActive) CardToppingColor else Color.Transparent)
    Card(
        modifier = modifier
            .size(60.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }) {
                updateToppingState(topping.type, !topping.isActive)
            },
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = cardColor.value)
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                modifier = Modifier.size(48.dp),
                painter = painterResource(id = topping.singleItemImageRes),
                contentDescription = "",
                alignment = Alignment.Center
            )
        }
    }
}

