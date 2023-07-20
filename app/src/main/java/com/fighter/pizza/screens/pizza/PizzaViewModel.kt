package com.fighter.pizza.screens.pizza

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fighter.pizza.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(PizzaUiState())
    val state = _state.asStateFlow()

    init {
        getBreads()
        getIngredients()
        getSingleIngredients()
    }


    fun updatePizzaSize(newPizzaSize: Char) {
        _state.update { it.copy(pizzaSize = newPizzaSize) }
    }

    private fun getBreads() {
        _state.update {
            it.copy(
                breads = listOf(
                    R.drawable.bread_1,
                    R.drawable.bread_2,
                    R.drawable.bread_3,
                    R.drawable.bread_4,
                    R.drawable.bread_5,
                )
            )
        }
    }

    private fun getIngredients() {
        _state.update {
            it.copy(
                ingredients = listOf(
                    R.drawable.mashrum,
                    R.drawable.onion,
                    R.drawable.susage,
                    R.drawable.broccoli,
                    R.drawable.basil,
                )
            )
        }
    }

    private fun getSingleIngredients() {
        _state.update {
            it.copy(
                singleIngredient = listOf(
                    R.drawable.mushroom_1,
                    R.drawable.onion_1,
                    R.drawable.sausage_1,
                    R.drawable.broccoli_1,
                    R.drawable.basil_1,
                )
            )
        }
    }

    fun updateIngredientState(ingredientIndex: Int, currentPage: Int, imageVisibility: Boolean) {
        val currentIngredient = _state.value.ingredientState.toMutableList()
        val currentToppingImage = getIngredientImageRes(ingredientIndex)
        val updatedToppings = state.value.toppings.toMutableList()

        currentIngredient[ingredientIndex] = !currentIngredient[ingredientIndex]
        _state.update { currentState ->
            updatedToppings[ingredientIndex] = currentState.toppings[ingredientIndex].copy(
                first = currentToppingImage,
                second = imageVisibility
            )
            if (currentState.currentPage == currentPage){
                currentState.copy(
                    ingredientState = currentIngredient,
                    currentPage = currentPage,
                    toppings = updatedToppings
                )
            }else{
                currentState.copy(
                    currentPage = currentPage,
                )
            }

        }
    }


//    fun updateToppings(currentPage: Int, imageVisibility: Boolean, toppingIndex: Int) {
//        val currentToppingImage = getIngredientImageRes(toppingIndex)
//        _state.update { currentState ->
//            val updatedToppings = state.value.toppings.toMutableList()
//            updatedToppings[toppingIndex] = currentState.toppings[toppingIndex].copy(
//                first = currentToppingImage,
//                second = imageVisibility
//            )
//            currentState.copy(currentPage = currentPage, toppings = updatedToppings)
//        }
//    }

    private fun getIngredientImageRes(index: Int): Int {
        return when (index) {
            0 -> R.drawable.mashrum
            1 -> R.drawable.onion
            2 -> R.drawable.susage
            3 -> R.drawable.broccoli
            4 -> R.drawable.basil
            else -> throw IllegalArgumentException("Invalid ingredient index: $index")
        }
    }


}