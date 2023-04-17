package com.toadfrogson.dirtplate.domain.api.apiResponse

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    var message: String,
    val code: Int
)