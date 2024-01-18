package com.haeun.boheom.navigation

sealed class AppNavigationItem(val route: String) {
    object SignIn: AppNavigationItem("signIn")
    object SignUpNickname: AppNavigationItem("signUpNickname")
    object SignUpId: AppNavigationItem("signUpId")
    object SignUpPassword: AppNavigationItem("signUpPassword")
    object SignUpSuccess: AppNavigationItem("signUpSuccess")
    object Landing: AppNavigationItem("landing")

}
