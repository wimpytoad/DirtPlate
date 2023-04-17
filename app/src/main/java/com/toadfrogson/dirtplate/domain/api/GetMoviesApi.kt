package com.toadfrogson.dirtplate.domain.api

import com.toadfrogson.dirtplate.domain.api.apiResponse.ApiResult
import com.toadfrogson.dirtplate.domain.model.movie.raw.MovieListEntity
import com.toadfrogson.dirtplate.domain.model.movie.MovieListType
import com.toadfrogson.dirtplate.domain.model.movie.MovieListType.CULT_CLASSIC
import com.toadfrogson.dirtplate.domain.model.movie.raw.MoviePostersEntity

interface GetMoviesApi {
    suspend fun getSuggestedMoviesRemote(type: MovieListType = CULT_CLASSIC): ApiResult<MovieListEntity>
    suspend fun getMovieImageryRemote(movieId: Int): ApiResult<MoviePostersEntity>
}