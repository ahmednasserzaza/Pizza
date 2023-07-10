package com.fighter.pizza.screens.pizza

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fighter.pizza.R
import com.fighter.pizza.composables.CardPizzaIngredient
import com.fighter.pizza.composables.CardPizzaSize
import com.fighter.pizza.composables.CartButton
import com.fighter.pizza.composables.IngredientHeader
import com.fighter.pizza.composables.PizzaHeader
import com.fighter.pizza.composables.PizzaSlider
import com.fighter.pizza.composables.PlateImage
import com.fighter.pizza.composables.TextPrice
import com.fighter.pizza.ui.theme.Brown

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaScreen(viewModel: PizzaViewModel = hiltViewModel()) {
    val pizzaState by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 0)

    PizzaContent(pizzaState, pagerState)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaContent(pizzaState: PizzaUiState, pagerState: PagerState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        PizzaHeader(pageTitle = stringResource(R.string.page_title))

        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(1 / 3f)
        ) {
            PlateImage(painter = painterResource(id = R.drawable.plate))
            PizzaSlider(
                breads = pizzaState.breads,
                pagerState = pagerState,
                ingredients = pizzaState.ingredients
            )
        }

        TextPrice(price = "$17")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement =
            Arrangement.spacedBy(16.dp, alignment = Alignment.CenterHorizontally)
        ) {
            CardPizzaSize(size = stringResource(R.string.small))
            CardPizzaSize(size = stringResource(R.string.medium))
            CardPizzaSize(size = stringResource(R.string.large))
        }

        IngredientHeader(text = stringResource(R.string.customize_your_pizza))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(pizzaState.singleIngredient) {
                CardPizzaIngredient(painter = painterResource(id = it))
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        CartButton(
            painter = painterResource(id = R.drawable.icon_cart),
            text = stringResource(R.string.add_to_cart)
        )

    }

}


@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun PizzaPreview() {
    PizzaScreen()
}