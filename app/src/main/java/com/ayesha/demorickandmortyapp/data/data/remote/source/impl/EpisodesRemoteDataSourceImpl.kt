package com.ayesha.demorickandmortyapp.data.data.remote.source.impl

import com.ayesha.demorickandmortyapp.data.data.model.EpisodesResponse
import com.ayesha.demorickandmortyapp.data.data.remote.api.EpisodesService
import com.ayesha.demorickandmortyapp.data.data.remote.source.EpisodesRemoteDataSource
import com.ayesha.demorickandmortyapp.data.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by merttoptas on 19.03.2022
 */

class EpisodesRemoteDataSourceImpl @Inject constructor(private val episodesService: EpisodesService) :
    BaseRemoteDataSource(), EpisodesRemoteDataSource {

    override suspend fun getAllEpisodes(): Flow<DataState<EpisodesResponse>> = getResult {
        episodesService.getAllEpisodes()
    }

    override suspend fun getEpisode(episodeId: Int): Flow<DataState<EpisodesResponse>> = getResult {
        episodesService.getEpisode(episodeId = episodeId)
    }
}
