package com.ayesha.demorickandmortyapp.data.data.remote.source

import com.ayesha.demorickandmortyapp.data.data.model.EpisodesResponse
import com.ayesha.demorickandmortyapp.data.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

/**
 * Created by merttoptas on 19.03.2022
 */

interface EpisodesRemoteDataSource {
    suspend fun getAllEpisodes(): Flow<DataState<EpisodesResponse>>
    suspend fun getEpisode(episodeId: Int): Flow<DataState<EpisodesResponse>>
}