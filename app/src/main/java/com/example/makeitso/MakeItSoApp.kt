/*
Copyright 2022 Google LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.example.makeitso

import android.content.res.Resources
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.makeitso.common.snackbar.SnackbarManager
import com.example.makeitso.screens.coming_soon.NotDone
import com.example.makeitso.screens.landing_page.LandingPage
import com.example.makeitso.screens.login.LoginScreen
import com.example.makeitso.screens.settings.SettingsScreen
import com.example.makeitso.screens.sign_up.SignUpScreen
import com.example.makeitso.screens.splash.SplashScreen
import com.example.makeitso.screens.spotify.SpotifyLink
import com.example.makeitso.screens.spotify.Tour
import com.example.makeitso.theme.MakeItSoTheme
import kotlinx.coroutines.CoroutineScope

@Composable
@ExperimentalMaterialApi
fun MakeItSoApp() {
  MakeItSoTheme {
    Surface(color = MaterialTheme.colors.background) {
      val appState = rememberAppState()

      Scaffold(
        snackbarHost = {
          SnackbarHost(
            hostState = it,
            modifier = Modifier.padding(8.dp),
            snackbar = { snackbarData ->
              Snackbar(snackbarData, contentColor = MaterialTheme.colors.onPrimary)
            }
          )
        },
        scaffoldState = appState.scaffoldState
      ) { innerPaddingModifier ->
        NavHost(
          navController = appState.navController,
          startDestination = SPLASH_SCREEN,
          modifier = Modifier.padding(innerPaddingModifier)
        ) {
          makeItSoGraph(appState)
        }
      }
    }
  }
}

@Composable
fun rememberAppState(
  scaffoldState: ScaffoldState = rememberScaffoldState(),
  navController: NavHostController = rememberNavController(),
  snackbarManager: SnackbarManager = SnackbarManager,
  resources: Resources = resources(),
  coroutineScope: CoroutineScope = rememberCoroutineScope()
) =
  remember(scaffoldState, navController, snackbarManager, resources, coroutineScope) {
    MakeItSoAppState(scaffoldState, navController, snackbarManager, resources, coroutineScope)
  }

@Composable
@ReadOnlyComposable
fun resources(): Resources {
  LocalConfiguration.current
  return LocalContext.current.resources
}

@ExperimentalMaterialApi
fun NavGraphBuilder.makeItSoGraph(appState: MakeItSoAppState) {
  composable(SPLASH_SCREEN) {
    SplashScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
  }

  composable(SETTINGS_SCREEN) {
    SettingsScreen(
      restartApp = { route -> appState.clearAndNavigate(route) },
      openScreen = { route -> appState.navigate(route) }
    )
  }

  composable(LOGIN_SCREEN) {
    LoginScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
  }

  composable(SIGN_UP_SCREEN) {
    SignUpScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
  }

  composable(SPOTIFY_TOUR) {
    Tour()
  }

  composable(NOT_DONE) {
    NotDone( popUpScreen = {route -> appState.navigate(route)}, popUp = {appState.popUp()})
  }

  composable(LANDING_PAGE) {
    LandingPage(popUpScreen = { route -> appState.navigate(route)})
  }
  composable(SPOTIFY_LINK) {
    SpotifyLink(popUp = {appState.popUp()}, popUpScreen = { route -> appState.navigate(route)})
  }
}
