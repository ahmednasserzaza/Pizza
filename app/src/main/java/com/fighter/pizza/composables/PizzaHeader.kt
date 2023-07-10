package com.fighter.pizza.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fighter.pizza.R

@Composable
fun PizzaHeader(modifier: Modifier = Modifier, pageTitle: String) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = R.drawable.icon_back), contentDescription = "")
        Text(text = pageTitle, fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Icon(
            painter = painterResource(id = R.drawable.icon_favorite_unselected),
            contentDescription = ""
        )

    }
}