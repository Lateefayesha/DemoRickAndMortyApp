package com.ayesha.demorickandmortyapp.domain.viewState.characters

import androidx.paging.PagingData
import com.ayesha.demorickandmortyapp.data.data.model.dto.CharacterDto
import com.ayesha.demorickandmortyapp.domain.IViewState
import kotlinx.coroutines.flow.Flow
import  com.ayesha.demorickandmortyapp.data.data.model.Result


data class CharactersViewState(
    val isLoading:Boolean=false,
    val pagedData: Flow<PagingData<CharacterDto>>? = null,
    val data : List<Result>?=null
) :IViewState