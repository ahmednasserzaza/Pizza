package com.fighter.pizza.screens.pizza

import androidx.lifecycle.ViewModel
import com.fighter.pizza.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.math.sin

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

}