package com.ayesha.demorickandmortyapp.domain.usecase.usecase.favorite

import com.ayesha.demorickandmortyapp.data.data.model.dto.CharacterDto
import com.ayesha.demorickandmortyapp.data.data.model.dto.extension.toFavoriteDtoList
import com.ayesha.demorickandmortyapp.domain.base.BaseUseCase
import com.ayesha.demorickandmortyapp.domain.base.IParams
import com.ayesha.demorickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetFavoritesUseCase(
    internal val repository: CharacterRepository
) : BaseUseCase<IParams, List<CharacterDto>>{
    override suspend fun invoke(param: IParams): Flow<List<CharacterDto>> {
        return flow{
            val favorites = repository.getFavoriteList()
            emit(favorites.toFavoriteDtoList())
        }
    }

}