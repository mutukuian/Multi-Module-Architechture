package com.search.ui.screens.recipe_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.common.utils.NetworkResult
import com.search.domain.model.RecipeDetails
import com.search.domain.use_cases.GetRecipeDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    private val getRecipeDetailsUseCase: GetRecipeDetailsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(RecipeDetailsList.UiState())
    val uiState: StateFlow<RecipeDetailsList.UiState> get() = _uiState.asStateFlow()

    fun onEvent(event: RecipeDetailsList.Event){
        when(event){
            is RecipeDetailsList.Event.FetchRecipeDetails -> {
                recipeDetails(event.id)
            }
        }
    }

    private fun recipeDetails(id: String) = getRecipeDetailsUseCase.invoke(id)
        .onEach { result ->
            when (result) {
                is NetworkResult.Loading -> {
                    _uiState.update { RecipeDetailsList.UiState(isLoading = true) }
                }

                is NetworkResult.Success -> {
                    _uiState.update { RecipeDetailsList.UiState(data = result.data) }
                }

                is NetworkResult.Error -> {
                    _uiState.update { RecipeDetailsList.UiState(error = result.message.toString()) }
                }
            }
        }.launchIn(viewModelScope)
}

object RecipeDetailsList {
    data class UiState(
        val isLoading: Boolean = false,
        val data: RecipeDetails? = null,
        val error: String? = null
    )

    sealed interface Event{
        data class FetchRecipeDetails(val id:String):Event
    }
}