package gaur.himanshu.searchrecipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.common.navigation.NavigationSubGraphRoutes

@Composable
fun RecipeNavigation(modifier: Modifier = Modifier,navigationSubGraphs: NavigationSubGraphs){
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = NavigationSubGraphRoutes.Search.route
    ) {
        navigationSubGraphs.searchFeatureApi.registerGraph(this, navHostController)
    }
}