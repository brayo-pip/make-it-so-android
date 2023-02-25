package com.example.makeitso.screens.coming_soon

import com.example.makeitso.model.service.LogService
import com.example.makeitso.screens.MakeItSoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ComingSoonViewModel @Inject constructor(
    logService: LogService
): MakeItSoViewModel(logService)  {

    fun onBackButtonClick(popUp: () -> Unit) {
        popUp()
    }
}