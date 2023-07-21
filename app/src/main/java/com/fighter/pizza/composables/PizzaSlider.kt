package com.fighter.pizza.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fighter.pizza.data.entity.PizzaSize
import com.fighter.pizza.screens.pizza.HomeUiState

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun PizzaSlider(
    state: HomeUiState,
) {
    val pagerState = rememberPagerState()
    val imageSizeAnimation = animateFloatAsState(
        targetValue = when (state.pizzas[state.currentPizzaIndex].size) {
            is PizzaSize.Small -> 0.8f
            is PizzaSize.Medium -> 0.9f
            is PizzaSize.Large -> 1f
        }, animationSpec = tween(500)
    )
    val imageToppingAnimation = animateFloatAsState(
        targetValue = when (state.pizzas[state.currentPizzaIndex].size) {
            is PizzaSize.Small -> 0.7f
            is PizzaSize.Medium -> 0.8f
            is PizzaSize.Large -> 0.9f
        }, animationSpec = tween(500)
    )

    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        pageCount = state.pizzas.size,
        state = pagerState,
        verticalAlignment = Alignment.CenterVertically
    ) { page ->

        Box(
            modifier = Modifier.aspectRatio(0.85f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(imageSizeAnimation.value),
                painter = painterResource(id = state.pizzas[page].breadImageRes),
                contentDescription = "bread type",
            )
            if (!pagerState.isScrollInProgress) {
                state.pizzas[state.currentPizzaIndex].toppings.reversed().forEach {
                    AnimatedVisibility(
                        visible = it.isActive && page == pagerState.currentPage,
                        enter = scaleIn(initialScale = 2f) + fadeIn(),
                        exit = fadeOut()
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(imageToppingAnimation.value),
                            painter = painterResource(id = it.groupImageRes),
                            contentDescription = null,
                        )
                    }
                }
            } else {
                state.pizzas[page].toppings.reversed().filter { it.isActive }
                    .forEach {
                        Image(
                            modifier = Modifier.fillMaxSize(imageToppingAnimation.value),
                            painter = painterResource(id = it.groupImageRes),
                            contentDescription = null,
                        )
                    }
            }

//                toppings.forEach { (imageRes, isVisible) ->
//                    AnimatedVisibility(
//                        visible = isVisible,
//                        enter = scaleIn(initialScale = 4f),
//                        exit = fadeOut(animationSpec = tween(10))
//                    ) {
//                        Image(
//                            modifier = Modifier.fillMaxSize(imageToppingAnimation.value),
//                            painter = painterResource(id = imageRes),
//                            contentDescription = "pizza content",
//                        )
//                    }
//
//                }

        }
    }
}
