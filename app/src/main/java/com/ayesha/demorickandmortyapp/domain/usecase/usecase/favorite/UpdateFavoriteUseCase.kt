package com.ayesha.demorickandmortyapp.domain.usecase.usecase.favorite

import com.ayesha.demorickandmortyapp.data.data.model.dto.CharacterDto
import com.ayesha.demorickandmortyapp.data.data.model.dto.extension.toFavoriteEntity
import com.ayesha.demorickandmortyapp.domain.base.BaseUseCase
import com.ayesha.demorickandmortyapp.domain.base.IParams
import com.ayesha.demorickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UpdateFavoriteUseCase(internal val repository: CharacterRepository) :
BaseUseCase<UpdateFavoriteUseCase.Params, Unit>{
    data class Params(
        val characters : CharacterDto
    ):IParams

    override suspend fun invoke(param: Params): Flow<Unit> {
        return flow {


            val dto = param.characters
            val character = repository.getFavorite(dto.id!!)
            if (character == null) {
                repository.saveFavorite(dto.toFavoriteEntity())
            } else {
                repository.deleteFavoriteById(dto.id ?: 0)
            }
            emit(Unit)
        }
    }
}