package com.haeun.boheom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haeun.boheom.feature.landing.Landing
import com.haeun.boheom.feature.main.Main
import com.haeun.boheom.feature.signin.SignIn
import com.haeun.boheom.feature.signup.SignUpId
import com.haeun.boheom.feature.signup.SignUpNickname
import com.haeun.boheom.feature.signup.SignUpPassword
import com.haeun.boheom.feature.signup.SignUpSuccess
import com.haeun.boheom.navigation.AppNavigationItem
import com.haeun.boheom.ui.theme.BoheomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoheomTheme {
                BoheomApp()
            }
        }
    }
}

@Composable
private fun BoheomApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppNavigationItem.SignUpSuccess.route,
    ) {
        composable(AppNavigationItem.Landing.route) {
            Landing(
                moveToSignIn = { navController.navigate(AppNavigationItem.SignIn.route) },
                moveToSignUp = { navController.navigate(AppNavigationItem.SignUpNickname.route) },
            )
        }

        composable(AppNavigationItem.SignIn.route) {
            SignIn(moveToSignUp = { navController.navigate(AppNavigationItem.SignUpNickname.route) })
        }

        composable(AppNavigationItem.SignUpNickname.route) {
            SignUpNickname(moveToSignUpId = { navController.navigate(AppNavigationItem.SignUpId.route) })
        }

        composable(AppNavigationItem.SignUpId.route) {
            SignUpId(moveToSignUpPassword = { navController.navigate(AppNavigationItem.SignUpPassword.route) })
        }

        composable(AppNavigationItem.SignUpPassword.route) {
            SignUpPassword(moveToSignUpSuccess = { navController.navigate(AppNavigationItem.SignUpSuccess.route) })
        }

        composable(AppNavigationItem.SignUpSuccess.route) {
            SignUpSuccess(moveToMain = {navController.navigate(AppNavigationItem.Main.route)})
        }

        composable(AppNavigationItem.Main.route) {
            Main()
        }
    }
}