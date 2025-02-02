package com.search.domain.model

data class Recipe(
    val idMeal: String?,
    val strArea: String?,
    val strCategory: String?,
    val strMeal: String?,
    val strMealThumb: String?,
    val strTags: String?,
    val strYoutube: String?,
    val strInstructions: String?,
)

data class RecipeDetails(
    val idMeal: String?,
    val strArea: String?,
    val strCategory: String?,
    val strMeal: String?,
    val strMealThumb: String?,
    val strTags: String?,
    val strYoutube: String?,
    val strInstructions: String?,
//    val ingredientsPair: List<Pair<String, String>>,
)