package com.haeun.boheom.data.request

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("account_id") val accountId: String,
    @SerializedName("password") val password: String,
    @SerializedName("nickname") val nickname: String,
)