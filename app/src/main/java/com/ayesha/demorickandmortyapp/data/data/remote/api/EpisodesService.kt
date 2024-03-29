package com.ayesha.demorickandmortyapp.data.data.remote.api

import com.ayesha.demorickandmortyapp.data.data.model.EpisodesResponse
import com.ayesha.demorickandmortyapp.data.data.remote.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by merttoptas on 19.03.2022
 */
interface EpisodesService {

    @GET(Constants.EPISODE_LIST)
    suspend fun getAllEpisodes(): Response<EpisodesResponse>

    @GET(Constants.GET_EPISODE)
    suspend fun getEpisode(
        @Path(Constants.PARAM_ID) episodeId: Int
    ): Response<EpisodesResponse>

}