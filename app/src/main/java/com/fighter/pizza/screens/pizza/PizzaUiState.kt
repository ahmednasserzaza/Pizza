package com.fighter.pizza.screens.pizza

import androidx.annotation.DrawableRes
import com.fighter.pizza.R
import com.fighter.pizza.data.entity.PizzaEntity
import com.fighter.pizza.data.entity.PizzaSize
import com.fighter.pizza.data.entity.Topping
import com.fighter.pizza.data.entity.ToppingEntity

data class HomeUiState(
    val pizzas: List<PizzaUiState> = emptyList(),
    val currentPizzaIndex: Int = 0,
) {
    data class PizzaUiState(
        @DrawableRes val breadImageRes: Int = R.drawable.bread_1,
        val toppings: List<ToppingUiState> = emptyList(),
        val size: PizzaSize = PizzaSize.Medium,
        val sizeChar: Char = 'M'
    )

    data class ToppingUiState(
        @DrawableRes val singleItemImageRes: Int,
        @DrawableRes val groupImageRes: Int,
        val type: Topping,
        val isActive: Boolean = false
    )
}

fun List<PizzaEntity>.toPizzaUiState(): List<HomeUiState.PizzaUiState> {
    return map {
        HomeUiState.PizzaUiState(
            breadImageRes = it.breadImageRes,
            toppings = it.toppings.toToppingUiState(),
            size = it.size
        )
    }
}


fun List<ToppingEntity>.toToppingUiState(): List<HomeUiState.ToppingUiState> {
    return map {
        HomeUiState.ToppingUiState(
            singleItemImageRes = it.singleItemImageRes,
            groupImageRes = it.groupImageRes,
            type = it.type
        )
    }
}