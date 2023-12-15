package com.loc.androiderroshandling

import arrow.core.Either
import arrow.core.raise.either
import kotlinx.coroutines.delay

class UserRepositoryImpl : UserRepository {
    override suspend fun getUser(): Either<UserError, User> = either {
        Either.catch {
            val response = UserApi.getUser(getToken().bind())
            if (response.isSuccessful) {
                response.user
            } else {
                raise(UserError(error = UserErrorType.NetworkError, message = ""))
            }
        }.mapLeft { UserError(UserErrorType.UnknownResponse, "", it) }.bind()
    }

    private fun getToken(): Either<UserError, String> = either {
        raise(UserError(UserErrorType.UnknownError, ""))
    }
}

class UserApi {
    companion object {
        suspend fun getUser(token: String): UserResponse {
            delay(1500)
            throw Exception()
//            return UserResponse(
//                isSuccessful = true,
//                user = User("", "", "")
//            )
        }
    }
}

data class UserResponse(
    val isSuccessful: Boolean,
    val user: User
)