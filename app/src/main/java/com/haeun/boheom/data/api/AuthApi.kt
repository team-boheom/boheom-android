package com.haeun.boheom.data.api

import com.haeun.boheom.data.request.LoginRequest
import com.haeun.boheom.data.request.SignUpRequest
import com.haeun.boheom.data.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("users/signup")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest,
    ): Void

    @POST("login")
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): LoginResponse
}