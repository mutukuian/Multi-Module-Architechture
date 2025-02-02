package com.search.data.repository

import com.search.data.mappers.toDomainRecipe
import com.search.data.mappers.toDomainRecipeDetails
import com.search.data.remote.SearchApiService
import com.search.domain.model.Recipe
import com.search.domain.model.RecipeDetails
import com.search.domain.repository.SearchRepository

class SearchRepoImpl(
    private val searchApiService: SearchApiService
) : SearchRepository {
    override suspend fun getRecipes(s: String): Result<List<Recipe>> {
        return try {
            val response = searchApiService.getRecipes(s)
            if (response.isSuccessful) {
                response.body()?.meals?.let {
                    Result.success(it.toDomainRecipe())
                } ?: Result.failure(Exception("Something went wrong"))
            } else {
                Result.failure(Exception("Something went wrong"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getRecipeDetails(id: String): Result<RecipeDetails> {
        return try {
            val response = searchApiService.getRecipeDetails(id)
            if (response.isSuccessful) {
                response.body()?.meals?.let {
                    if (it.isNotEmpty()) {
                        Result.success(it.first().toDomainRecipeDetails())
                    } else {
                        Result.failure(Exception("No data found"))
                    }
                } ?: Result.failure(Exception("Something went wrong"))
            } else {
                Result.failure(Exception("Something went wrong"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}