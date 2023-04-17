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
            "4. Leave to cook for 10-20 mins."),
    video = "https://www.youtube.com/watch?v=Xx7sxWI9FNI&pp=ygUJbWFrZSByaWNl"

)

val stew = Content(
    id = 1,
    title = "stew",
    image = R.drawable.stew,
    ingredients = listOf("water, salt, cooking oil, beef, tomato sauce, onions, masala"),
    method = listOf("1. Add oil, diced onions to pot and add sauce after onions turn golden brown." +
            "2. Add a pinch of salt and tablespoon of masala." +
            "3. Add chopped beef and let simmer for atleast 5 mins." +
            "4. Add water and leave to cook." +
            "5. Serve with white rice and cold orange juice"),
    video = "https://youtu.be/nLeYPk_-lYs"

)

val cake = Content(
    id = 2,
    title = "cake",
    image = R.drawable.cake,
    ingredients = listOf("sugar, eggs, milk, flour,butter"),
    method = listOf("1.Pre heat oven." +
            "2. Stir dry ingedients together." +
            "3. Combine butter and sugar." +
            "4. Add eggs on at a time."+
            "5. Alternate adding dry and wet ingredients"+
            "6. Pour batter into pans and bake"),
    video = "https://www.youtube.com/watch?v=yrzOQ2Ssqnw&pp=ygUJYmFrZSBjYWtl"

)
data class Content(
    val id : Long,
    val title : String,
    @DrawableRes val image : Int,
    val ingredients : List<String>,
    val method : List<String>,
    val video : String
)

//list of objects
val recipe  = listOf(rice,stew, cake)