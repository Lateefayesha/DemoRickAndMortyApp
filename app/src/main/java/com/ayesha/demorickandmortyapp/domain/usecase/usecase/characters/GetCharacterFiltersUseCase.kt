package com.ayesha.demorickandmortyapp.domain.usecase.usecase.characters

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ayesha.demorickandmortyapp.data.data.model.dto.CharacterDto
import com.ayesha.demorickandmortyapp.domain.base.BaseUseCase
import com.ayesha.demorickandmortyapp.domain.base.IParams
import com.ayesha.demorickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterFiltersUseCase(
    internal val repository: CharacterRepository
) : BaseUseCase<GetCharacterFiltersUseCase.Params, PagingData<CharacterDto>>{

    data class Params(
        val pagingConfig: PagingConfig,
        val options :Map<String,String>
    ):IParams



    override suspend fun invoke(param: Params): Flow<PagingData<CharacterDto>> {
   return Pager(
       config = param.pagingConfig,
       pagingSourceFactory = { CharactersFilterPagingSource(repository, param.options) }
   ).flow

    }




}