package com.ayesha.demorickandmortyapp.data.data.remote.source

import com.ayesha.demorickandmortyapp.data.data.model.CharacterInfoResponse
import com.ayesha.demorickandmortyapp.data.data.model.CharacterResponse
import com.ayesha.demorickandmortyapp.data.data.model.FavoriteEntity
import com.ayesha.demorickandmortyapp.data.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

/**
 * Created by merttoptas on 12.03.2022
 */

interface CharacterRemoteDataSource {
    suspend fun getAllCharacters(page: Int, options: Map<String, String>): Response<CharacterResponse>
    suspend fun getFilterCharacters(page: Int, options: Map<String, String>): Response<CharacterResponse>
    suspend fun getCharacter(characterId: Int): Flow<DataState<CharacterInfoResponse>>
    suspend fun getCharacter(url: String): Flow<DataState<CharacterInfoResponse>>
    suspend fun getFavoriteList(): List<FavoriteEntity>
    suspend fun getFavorite(favoriteId: Int): FavoriteEntity? = null
    suspend fun deleteFavoriteById(favoriteId: Int): Unit
    suspend fun deleteFavoriteList(): Unit
    suspend fun saveFavorite(entity: FavoriteEntity): Unit
    suspend fun saveFavoriteList(entityList: List<FavoriteEntity>): Unit

}