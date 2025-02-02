package com.common.navigation

sealed class NavigationRoutes(val route: String){
    data object RecipeList:NavigationRoutes("/recipe_list")
    data object RecipeDetails:NavigationRoutes("/recipe_details/{id}"){
        fun sendId(id:String) = "/recipe_details/${id}"
    }
}

sealed class NavigationSubGraphRoutes(val route: String){
    data object Search:NavigationSubGraphRoutes("/search")

}