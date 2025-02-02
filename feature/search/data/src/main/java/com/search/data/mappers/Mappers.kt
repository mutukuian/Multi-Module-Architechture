package com.search.data.mappers

import com.search.data.model.RecipeDTO
import com.search.domain.model.Recipe
import com.search.domain.model.RecipeDetails

fun List<RecipeDTO>.toDomainRecipe(): List<Recipe>  = map{
    Recipe(
        idMeal = it.idMeal,
        strArea = it.strArea,
        strCategory = it.strCategory,
        strMeal = it.strMeal,
        strMealThumb = it.strMealThumb,
        strTags = it.strTags?:"",
        strYoutube = it.strYoutube?:"",
        strInstructions = it.strInstructions,
    )
}


fun RecipeDTO.toDomainRecipeDetails(): RecipeDetails {
    return RecipeDetails(
        idMeal = idMeal,
        strArea = strArea,
        strCategory = strCategory,
        strMeal = strMeal,
        strMealThumb = strMealThumb,
        strTags = strTags?:"",
        strYoutube = strYoutube?:"",
        strInstructions = strInstructions,
    )
}