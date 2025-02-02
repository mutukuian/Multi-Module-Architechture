package com.search.domain.repository

import com.search.domain.model.Recipe
import com.search.domain.model.RecipeDetails

interface SearchRepository {

    suspend fun getRecipes(s:String):Result<List<Recipe>>

    suspend fun getRecipeDetails(id:String):Result<RecipeDetails>

}