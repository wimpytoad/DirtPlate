package com.toadfrogson.dirtplate.domain.repo

import com.toadfrogson.dirtplate.domain.api.apiResponse.ApiResult
import com.toadfrogson.dirtplate.domain.model.movie.MovieListType
import com.toadfrogson.dirtplate.domain.model.movie.MovieListType.CULT_CLASSIC
import com.toadfrogson.dirtplate.domain.model.movie.raw.MovieEntity
import com.toadfrogson.dirtplate.domain.model.movie.raw.MoviePostersEntity

interface MoviesRepo {
    suspend fun getSuggestedMovies(refresh: Boolean = true, type: MovieListType = CULT_CLASSIC): ApiResult<List<MovieEntity>>
    suspend fun getMovieImagery(refresh: Boolean = true, movieId: Int): ApiResult<MoviePostersEntity>
}