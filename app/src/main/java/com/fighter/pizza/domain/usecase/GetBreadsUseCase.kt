package com.fighter.pizza.domain.usecase

import com.fighter.pizza.data.PizzaDatasource
import javax.inject.Inject

class GetBreadsUseCase  @Inject constructor(private val pizzaDataSource: PizzaDatasource) {
    operator fun invoke() = pizzaDataSource.breads
}