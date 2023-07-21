package com.fighter.pizza.screens.pizza

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fighter.pizza.R
import com.fighter.pizza.data.entity.PizzaSize
import com.fighter.pizza.data.entity.Topping
import com.fighter.pizza.domain.usecase.GetBreadsUseCase
import com.fighter.pizza.domain.usecase.GetToppingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor(
    private val getBreadsUseCase: GetBreadsUseCase,
    private val getToppingsUseCase: GetToppingsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getBreads()
        getToppings()
        Log.e("topping : " , "${state.value.pizzas}")

    }

    fun updateToppingState(type: Topping, isActive: Boolean) {
        _state.update {
            it.copy(
                pizzas = it.pizzas.mapIndexed { index, pizza ->
                    if (index == _state.value.currentPizzaIndex) {
                        pizza.copy(toppings = pizza.toppings.map { topping ->
                            if (topping.type == type) {
                                topping.copy(isActive = isActive)
                            } else {
                                topping
                            }
                        })
                    } else {
                        pizza
                    }
                }
            )
        }
    }

    fun updatePizzaSize(pizzaSize: PizzaSize) {
        _state.update {
            it.copy(pizzas = it.pizzas.mapIndexed { index, pizza ->
                if (index == _state.value.currentPizzaIndex) {
                    pizza.copy(size = pizzaSize)
                } else {
                    pizza
                }
            })
        }
    }

    private fun getToppings() {
        _state.update {
            it.copy(pizzas = it.pizzas.map { pizzaUiState ->
                pizzaUiState.copy(toppings = getToppingsUseCase().toToppingUiState())
            })
        }    }

    private fun getBreads() {
        _state.update { it.copy(pizzas = getBreadsUseCase().toPizzaUiState()) }
    }


    fun updateCurrentPizza(currentPizzaIndex: Int) {
        _state.update { it.copy(currentPizzaIndex = currentPizzaIndex) }
    }


}