package com.fighter.pizza.data

import com.fighter.pizza.R
import com.fighter.pizza.data.entity.PizzaEntity
import com.fighter.pizza.data.entity.Topping
import com.fighter.pizza.data.entity.ToppingEntity
import com.fighter.pizza.di.DataBaseModule
import javax.inject.Inject

class PizzaDatasource @Inject constructor(resourcesProvider: DataBaseModule) {

    val toppings =
        listOf(
            ToppingEntity(
                singleItemImageRes = resourcesProvider.getDrawable(R.drawable.basil_1),
                groupImageRes = resourcesProvider.getDrawable(R.drawable.basil),
                type = Topping.BASIL,
            ),
            ToppingEntity(
                singleItemImageRes = resourcesProvider.getDrawable(R.drawable.onion_1),
                groupImageRes = resourcesProvider.getDrawable(R.drawable.onion),
                type = Topping.ONION,
            ),
            ToppingEntity(
                singleItemImageRes = resourcesProvider.getDrawable(R.drawable.broccoli_1),
                groupImageRes = resourcesProvider.getDrawable(R.drawable.broccoli),
                type = Topping.BROCCOLI,
            ),
            ToppingEntity(
                singleItemImageRes = resourcesProvider.getDrawable(R.drawable.mushroom_1),
                groupImageRes = resourcesProvider.getDrawable(R.drawable.mashrum),
                type = Topping.MUSHROOM,
            ),
            ToppingEntity(
                singleItemImageRes = resourcesProvider.getDrawable(R.drawable.sausage_1),
                groupImageRes = resourcesProvider.getDrawable(R.drawable.susage),
                type = Topping.SAUSAGE,
            ),
        )

    val breads = listOf(
        PizzaEntity(breadImageRes = R.drawable.bread_1),
        PizzaEntity(breadImageRes = R.drawable.bread_2),
        PizzaEntity(breadImageRes = R.drawable.bread_3),
        PizzaEntity(breadImageRes = R.drawable.bread_4),
        PizzaEntity(breadImageRes = R.drawable.bread_5)
    )

}