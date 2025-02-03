package com.search.ui.navigation

import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.common.navigation.FeatureApi
import com.common.navigation.NavigationRoutes
import com.common.navigation.NavigationSubGraphRoutes
import com.search.ui.screens.recipe_list.RecipeListScreen

interface SearchFeatureApi : FeatureApi

class SearchFeatureApiImpl : SearchFeatureApi {
    override fun registerGraph(
        navGraphBuilder: androidx.navigation.NavGraphBuilder,
        navHostController: androidx.navigation.NavHostController
    ) {
        navGraphBuilder.navigation(
            startDestination = NavigationRoutes.RecipeList.route,
            route = NavigationSubGraphRoutes.Search.route
        ) {
            composable(route = NavigationRoutes.RecipeList.route) {
                RecipeListScreen(onClick = {})
            }
            composable(route = NavigationRoutes.RecipeDetails.route) {

            }
        }
    }
}