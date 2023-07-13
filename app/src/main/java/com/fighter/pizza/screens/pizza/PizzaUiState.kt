package com.fighter.pizza.screens.pizza

data class PizzaUiState(
    val breads: List<Int> = emptyList(),
    val ingredients: List<Int> = emptyList(),
    val singleIngredient: List<Int> = emptyList(),
    val ingredientImages: List<Int?> = emptyList(),
    val ingredientState: List<Boolean> = List(5) { true },
    val pizzaSize: Char = 'M',
    val currentPage: Int = 0,
    val toppings: List<Pair<Int , Boolean>> = List(5 ){Pair(0 , false)},
)