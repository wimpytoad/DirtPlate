package com.toadfrogson.dirtplate.domain.model

import com.toadfrogson.dirtplate.domain.model.movie.MovieListType

sealed class MovieDBEndpoints {
    data class MovieListEndpoint(val type: MovieListType) : MovieDBEndpoints() {
        override fun toString() = "/3/list/${type.id}"
    }

    data class MovieDetailsEndpoint(val movieId: Int) : MovieDBEndpoints() {
        override fun toString() = "3/movie/$movieId/images"
    }
}