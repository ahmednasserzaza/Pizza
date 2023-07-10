package com.fighter.pizza.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fighter.pizza.R

@Composable
fun CardPizzaIngredient(modifier: Modifier = Modifier, painter: Painter) {
    Card(
        modifier = modifier.size(60.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
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

@Preview
@Composable
fun IngredientsPrev() {
    CardPizzaIngredient(painter = painterResource(id = R.drawable.mushroom_1))
}