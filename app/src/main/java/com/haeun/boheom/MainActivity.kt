package com.haeun.boheom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haeun.boheom.feature.landing.Landing
import com.haeun.boheom.feature.signin.SignIn
import com.haeun.boheom.feature.signup.SignUp
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
        startDestination = AppNavigationItem.Landing.route,
    ) {
        composable(AppNavigationItem.Landing.route) {
            Landing(
                moveToSignIn = { navController.navigate(AppNavigationItem.SignIn.route) },
                moveToSignUp = { navController.navigate(AppNavigationItem.SignUp.route) },
            )
        }

        composable(AppNavigationItem.SignIn.route) {
            SignIn(
                moveToSignUp = { navController.navigate(AppNavigationItem.SignUp.route) }
            )
        }

        composable(AppNavigationItem.SignUp.route) {
            SignUp()
        }
    }
}