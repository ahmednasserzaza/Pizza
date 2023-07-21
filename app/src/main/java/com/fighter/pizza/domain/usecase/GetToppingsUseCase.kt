package com.fighter.pizza.domain.usecase

import com.fighter.pizza.data.PizzaDatasource
import javax.inject.Inject

class GetToppingsUseCase @Inject constructor(private val pizzaDataSource: PizzaDatasource) {
    operator fun invoke() = pizzaDataSource.toppings
}