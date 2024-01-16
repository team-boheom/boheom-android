package com.haeun.boheom.navigation

sealed class AppNavigationItem(val route: String) {
    object SignIn: AppNavigationItem("signIn")
    object SignUp: AppNavigationItem("signUp")
    object Landing: AppNavigationItem("landing")
}
