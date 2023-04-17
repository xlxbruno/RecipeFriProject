package com.example.application

import androidx.annotation.DrawableRes

val rice = Content(
    id = 0,
    title = "pizza",
    image = R.drawable.rice,
    ingredients = listOf("Pishori rice, salt, cooking oil, water"),
    method = listOf("1. Add 4 cups of water in the rice cooker." +
            "2. Add a pinch of salt and 2 tablespoons of cooking oil." +
            "3. Add 2 cups pishori rice and stir." +
            "4. Leave to cook for 10-20 mins.")

)

val stew = Content(
    id = 1,
    title = "stew",
    image = R.drawable.stew,
    ingredients = listOf("water, salt, cooking oil, beef, tomato sauce, onions, masala"),
    method = listOf("1. Add 4 cups of water in the rice cooker." +
            "2. Add a pinch of salt and 2 tablespoons of cooking oil." +
            "3. Add 2 cups pishori rice and stir." +
            "4. Leave to cook for 10-20 mins.")

)

val cake = Content(
    id = 2,
    title = "cake",
    image = R.drawable.cake,
    ingredients = listOf("sugar, eggs, milk, flour, vannilla essence"),
    method = listOf("1. Add 4 cups of water in the rice cooker." +
            "2. Add a pinch of salt and 2 tablespoons of cooking oil." +
            "3. Add 2 cups pishori rice and stir." +
            "4. Leave to cook for 10-20 mins.")

)
data class Content(
    val id : Long,
    val title : String,
    @DrawableRes val image : Int,
    val ingredients : List<String>,
    val method : List<String>
)

//list of objects
val recipe  = listOf(rice,stew, cake)