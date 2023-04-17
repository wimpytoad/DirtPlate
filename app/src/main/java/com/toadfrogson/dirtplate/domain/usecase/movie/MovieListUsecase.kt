package com.toadfrogson.dirtplate.domain.usecase.movie

import com.toadfrogson.dirtplate.domain.api.apiResponse.ApiResult.Failure
import com.toadfrogson.dirtplate.domain.api.apiResponse.ApiResult.Success
import com.toadfrogson.dirtplate.domain.model.movie.MovieListType
import com.toadfrogson.dirtplate.domain.model.movie.MovieListType.CULT_CLASSIC
import com.toadfrogson.dirtplate.domain.model.movie.raw.MovieEntity
import com.toadfrogson.dirtplate.domain.repo.MoviesRepo
import com.toadfrogson.dirtplate.domain.usecase.UseCase
import com.toadfrogson.dirtplate.domain.usecase.UseCaseError
import com.toadfrogson.dirtplate.domain.usecase.UseCaseResult
import javax.inject.Inject

interface MovieListUseCase : UseCase<MovieListUseCase.Params, UseCaseResult<List<MovieEntity>>> {
    override suspend operator fun invoke(
        params: Params
    ): UseCaseResult<List<MovieEntity>>

    data class Params(
        val refreshContent: Boolean = true,
        val listType: MovieListType = CULT_CLASSIC
    )
}

class MovieListUseCaseImpl @Inject constructor(private val repo: MoviesRepo) : MovieListUseCase {
    override suspend operator fun invoke(
        params: MovieListUseCase.Params
    ): UseCaseResult<List<MovieEntity>> {
        return when (val repoResponse =
            repo.getSuggestedMovies(refresh = params.refreshContent, type = params.listType)) {
            is Success -> UseCaseResult.Success(repoResponse.data)
            is Failure -> UseCaseResult.Failure(UseCaseError())
        }
    }
}