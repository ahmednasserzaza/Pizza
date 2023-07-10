package com.fighter.pizza.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaSlider(breads: List<Int>, ingredients: List<Int>, pagerState: PagerState) {

    HorizontalPager(
        modifier = Modifier.fillMaxSize() ,
        pageCount = breads.size,
        state = pagerState,
        verticalAlignment = Alignment.CenterVertically
    ) { page ->
        Box(
            modifier = Modifier.aspectRatio(0.70f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = breads[page]),
                contentDescription = "bread type",
            )
            Image(
                modifier = Modifier.fillMaxSize(0.8f),
                painter = painterResource(id = ingredients[page]),
                contentDescription = "pizza content",
            )

        }
    }

}