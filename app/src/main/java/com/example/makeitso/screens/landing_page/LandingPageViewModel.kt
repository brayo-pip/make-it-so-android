package com.example.makeitso.screens.landing_page

//import android.content.Context
//import android.content.Intent
//import android.widget.Toast
//import androidx.core.content.ContextCompat.startActivity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import com.example.makeitso.NOT_DONE
import com.example.makeitso.SETTINGS_SCREEN
import com.example.makeitso.SPOTIFY_LINK
import com.example.makeitso.model.service.LogService
import com.example.makeitso.screens.MakeItSoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import androidx.compose.ui.platform.LocalContext


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
    fun onIconClick(context: Context){
        val number = "+254713415995"
        val url = "https://api.whatsapp.com/send?phone=$number"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
//        val sendIntent = Intent()
//        sendIntent.action = Intent.ACTION_SEND
//        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
//        sendIntent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
        intent.setPackage("com.whatsapp")
        try {
            startActivity(context, intent, null)
        }catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace();
        }
    }

    fun onNotDone(popUpScreen: (String) -> Unit) {
        popUpScreen(NOT_DONE)
    }

}
