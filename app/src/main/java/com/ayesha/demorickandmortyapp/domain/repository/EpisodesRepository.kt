package com.ayesha.demorickandmortyapp.domain.repository

import com.ayesha.demorickandmortyapp.data.data.model.EpisodesResponse
import com.ayesha.demorickandmortyapp.data.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    fun getAllEpisodes(): Flow<DataState<EpisodesResponse>>
    fun getEpisode(episodesId:Int):Flow<DataState<EpisodesResponse>>



}