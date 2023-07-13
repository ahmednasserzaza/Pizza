package com.fighter.pizza.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun PizzaSlider(
    breads: List<Int>,
    toppings: List<Pair<Int, Boolean>>,
    pagerState: PagerState,
    pizzaSizeState: Char,
    currentPage: Int,
) {
    val imageSizeAnimation = animateFloatAsState(
        targetValue = when (pizzaSizeState) {
            'S' -> 0.8f
            'M' -> 0.9f
            'L' -> 1f
            else -> 0.8f
        }, animationSpec = tween(500)
    )
    val imageToppingAnimation = animateFloatAsState(
        targetValue = when (pizzaSizeState) {
            'S' -> 0.7f
            'M' -> 0.8f
            'L' -> 0.9f
            else -> 0.7f
        }, animationSpec = tween(500)
    )

    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        pageCount = breads.size,
        state = pagerState,
        verticalAlignment = Alignment.CenterVertically
    ) { page ->

        Box(
            modifier = Modifier.aspectRatio(0.85f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(imageSizeAnimation.value),
                painter = painterResource(id = breads[page]),
                contentDescription = "bread type",
            )

            if (currentPage == page) {
                toppings.forEach { (imageRes, isVisible) ->
                    AnimatedVisibility(
                        visible = isVisible,
                        enter = scaleIn(initialScale = 4f),
                        exit = fadeOut(animationSpec = tween(10))
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(imageToppingAnimation.value),
                            painter = painterResource(id = imageRes),
                            contentDescription = "pizza content",
                        )
                    }

                }
            }

        }
    }
}
