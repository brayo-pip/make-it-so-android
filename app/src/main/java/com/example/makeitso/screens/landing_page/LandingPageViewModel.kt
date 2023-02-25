package com.example.makeitso.screens.landing_page

import com.example.makeitso.NOT_DONE
import com.example.makeitso.SETTINGS_SCREEN
import com.example.makeitso.SPOTIFY_LINK
import com.example.makeitso.model.service.LogService
import com.example.makeitso.screens.MakeItSoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingPageViewModel @Inject constructor(
    logService: LogService
): MakeItSoViewModel(logService)  {

    fun onBackButtonClick(popUpScreen: (String) ->Unit) {
        //TODO
    }
    fun onSettingsIconClick(popUpScreen: (String) -> Unit) {
        popUpScreen(SETTINGS_SCREEN)
    }
    fun onSpotifyClick(popUpScreen: (String) -> Unit) {
        popUpScreen(SPOTIFY_LINK)
    }
    fun onNotDone(popUpScreen: (String) -> Unit) {
        popUpScreen(NOT_DONE)
    }

}
