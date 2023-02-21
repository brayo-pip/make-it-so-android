package com.example.makeitso.screens.spotify

import com.example.makeitso.SPOTIFY_TOUR
import com.example.makeitso.model.service.LogService
import com.example.makeitso.screens.MakeItSoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SpotifyViewModel @Inject constructor(
    logService: LogService
): MakeItSoViewModel(logService) {

    fun onTourClick(popUpScreen: (String) -> Unit) {
        popUpScreen(SPOTIFY_TOUR)
    }

    fun onBackButtonClick(backScreen: () -> Unit) {
        backScreen()
    }
}