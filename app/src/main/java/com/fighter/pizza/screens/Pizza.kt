package com.fighter.pizza.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PizzaScreen(){

    PizzaContent()
}

@Composable
fun PizzaContent(){

}

@Preview(showBackground = true , widthDp = 360 , heightDp = 800)
@Composable
fun PizzaPreview() {
    PizzaScreen()
}