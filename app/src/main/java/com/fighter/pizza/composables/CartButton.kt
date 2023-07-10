package com.fighter.pizza.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fighter.pizza.ui.theme.Brown

@Composable
fun CartButton(modifier: Modifier = Modifier , painter: Painter , text:String){
    Button(
        modifier = modifier.padding(vertical = 32.dp),
        onClick = {},
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Brown),
    ) {
        Icon(
            painter = painter,
            contentDescription = "",
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
        Text(text = text, fontWeight = FontWeight.Medium)
    }
}