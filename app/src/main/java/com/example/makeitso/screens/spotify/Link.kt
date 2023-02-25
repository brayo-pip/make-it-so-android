package com.example.makeitso.screens.spotify

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.makeitso.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SpotifyLink(
    popUp: () -> Unit,
    popUpScreen: (String) -> Unit,
    viewModel: SpotifyViewModel = hiltViewModel()
){

    // Creating an annotated string
    val annotatedLinkString = buildAnnotatedString {

        // creating a string to display in the Text
        val str = stringResource(R.string.accept_invite)

        // word and span to be hyperlinked
        val startIndex = str.indexOf("link")
        val endIndex = startIndex + 4

        append(str)
        addStyle(
            style = SpanStyle(
                fontSize = 24.sp,
                color = MaterialTheme.colors.onSurface
            ),
            start = 0, end = str.length-1
        )

        addStyle(
            style = SpanStyle(
                color = Color(0xFF10ED37),
                textDecoration = TextDecoration.Underline,
            ), start = startIndex, end = endIndex
        )

        // attach a string annotation that
        // stores a URL to the text "link"
        addStringAnnotation(
            tag = "URL",
            annotation = "https://www.spotify.com/ke-en/family/join/invite/3bb9xb6Za62A41Y/",
            start = startIndex,
            end = endIndex
        )

    }

    // UriHandler parse and opens URI inside
    // AnnotatedString Item in Browse
    val uriHandler = LocalUriHandler.current

   Scaffold(
       topBar = {
           TopAppBar(
           title = {
               Text(text = "Invite Link")
           },
           backgroundColor = MaterialTheme.colors.primary,
               navigationIcon = {
                   IconButton(onClick = { viewModel.onBackButtonClick(popUp) }) {
                       Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
                   }
               },
           )
       }
   ) {_ ->
       Column(
           Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ) {

           ClickableText(
               text = annotatedLinkString,
               onClick = {
                   annotatedLinkString
                       .getStringAnnotations("URL", it, it)
                       .firstOrNull()?.let { stringAnnotation ->
                           uriHandler.openUri(stringAnnotation.item)
                       }
               }
           )

           Spacer(modifier = Modifier.height(16.dp))

           Text(
               text = stringResource(id = R.string.tutorial), fontSize = 24.sp,
               textAlign = TextAlign.Center
           )

           Spacer(modifier = Modifier.height(16.dp))

           Button(onClick = { viewModel.onTourClick(popUpScreen) }) {
               Text(text = "Tutorial", fontSize = 24.sp, textAlign = TextAlign.Center)
           }

       }

   }
}

//@Preview
//@Composable
//fun Link(){
//    SpotifyLink()
//}
