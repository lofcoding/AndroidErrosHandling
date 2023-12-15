package com.loc.androiderroshandling

import arrow.core.Either

interface UserRepository {

    suspend fun getUser(): Either<UserError, User>

}

data class UserError(
    val error: UserErrorType,
    val message: String,
    val t: Throwable? = null,
)

enum class UserErrorType {
    NetworkError, UnknownResponse, UnknownError, UserNotFound, InvalidToken
}