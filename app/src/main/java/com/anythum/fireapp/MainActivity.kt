package com.anythum.fireapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anythum.fireapp.ui.screens.AppViewModel
import com.anythum.fireapp.ui.screens.GoogleAuthUiClient
import com.anythum.fireapp.ui.screens.LoginScreen
import com.anythum.fireapp.ui.theme.FireAppTheme
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val googleSingInClint = GoogleAuthUiClient(
            context = this,
            oneTapClient = Identity.getSignInClient(this)
        )
        enableEdgeToEdge()
        setContent {
            FireAppTheme {
                val vm: AppViewModel = viewModel()
                val nc = rememberNavController()
                val state = vm.appState.collectAsState().value
                NavHost(
                    navController = nc,
                    startDestination = com.anythum.fireapp.Screen.Login.route
                ) {
                    composable(route = com.anythum.fireapp.Screen.Login.route) {
                        val launcher = rememberLauncherForActivityResult(
                            contract = ActivityResultContracts.StartIntentSenderForResult()
                        ) { result ->
                            if (result.resultCode == RESULT_OK) {
                                lifecycleScope.launch {
                                    val singInResult = googleSingInClint.signInWithIntent(
                                        intent = result.data ?: return@launch
                                    )
                                    vm.onSignInResult(singInResult)
                                }
                            }
                        }
                        LoginScreen(modifier = Modifier, state = state) {

                        }
                    }
                    composable(route = com.anythum.fireapp.Screen.Home.route) {
                        // HomeScreen()
                    }
                }


            }
        }
    }
}

enum class Screen(val route: String) {
    Login("login"),
    Home("home")

}
