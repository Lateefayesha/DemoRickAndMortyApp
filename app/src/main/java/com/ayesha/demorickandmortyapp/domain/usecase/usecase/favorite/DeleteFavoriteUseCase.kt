package com.ayesha.demorickandmortyapp.domain.usecase.usecase.favorite

import com.ayesha.demorickandmortyapp.domain.base.BaseUseCase
import com.ayesha.demorickandmortyapp.domain.base.IParams
import com.ayesha.demorickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DeleteFavoriteUseCase(
    internal val repository: CharacterRepository
) : BaseUseCase<DeleteFavoriteUseCase.Params, Unit>{
    data class  Params(val characterId:Int?):IParams

    override suspend fun invoke(param: Params): Flow<Unit> {
        param.characterId?.let {
            repository.deleteFavoriteById(param.characterId)
        }?: kotlin.run{
            repository.deleteFavoriteList()
        }
        return flow{emit(Unit)}
    }
}