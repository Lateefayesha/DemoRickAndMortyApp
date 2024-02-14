package com.ayesha.demorickandmortyapp.features.screen.characters

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.ayesha.demorickandmortyapp.data.data.model.dto.CharacterDto
import com.ayesha.demorickandmortyapp.domain.IViewEvent
import com.ayesha.demorickandmortyapp.domain.usecase.usecase.characters.GetCharactersUseCase
import com.ayesha.demorickandmortyapp.domain.usecase.usecase.favorite.UpdateFavoriteUseCase
import com.ayesha.demorickandmortyapp.domain.viewState.characters.CharactersViewState
import com.ayesha.demorickandmortyapp.features.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
private val updateFavoriteUseCase :UpdateFavoriteUseCase):
    BaseViewModel<CharactersViewState, CharacterViewEvent>(){

    private val config = PagingConfig (pageSize =20)
    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {

        viewModelScope.launch {
            setState { currentState.copy(isLoading = true) }
            val params = GetCharactersUseCase.Params(config, hashMapOf())
            val pageFlow = getCharactersUseCase(params).cachedIn(scope= viewModelScope)
            delay(1000)
            setState { currentState.copy(isLoading = false, pagedData = pageFlow) }
        }
    }
    private fun updateFavorite(dto:CharacterDto)= viewModelScope.launch {
        val params = UpdateFavoriteUseCase.Params(dto)
        call(updateFavoriteUseCase(params))
    }



    override fun onTriggerEvent(event: CharacterViewEvent) {
        viewModelScope.launch {
            when(event){
                is CharacterViewEvent.updateFavorite->updateFavorite(event.dto)
            }
        }
    }

    override fun createInitialState(): CharactersViewState {
        TODO("Not yet implemented")
    }

}

sealed class CharacterViewEvent : IViewEvent{
    class updateFavorite(val dto:CharacterDto): CharacterViewEvent()
}