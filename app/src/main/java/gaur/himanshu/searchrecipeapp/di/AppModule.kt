package gaur.himanshu.searchrecipeapp.di

import com.search.ui.navigation.SearchFeatureApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gaur.himanshu.searchrecipeapp.navigation.NavigationSubGraphs

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideNavigationSubGraphs(searchFeatureApi: SearchFeatureApi): NavigationSubGraphs{
        return NavigationSubGraphs(searchFeatureApi)
    }
}