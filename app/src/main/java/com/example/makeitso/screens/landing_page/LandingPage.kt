package com.example.makeitso.screens.landing_page

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Sms
import androidx.compose.material.icons.filled.Textsms
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.makeitso.R


@Composable
fun LandingPage(
    popUpScreen: (String) -> Unit,
    viewModel: LandingPageViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Choose Service")
                },
                backgroundColor = MaterialTheme.colors.primary,
                actions = {
                    TopAppBarActionButton(
                        imageVector = Icons.Filled.Settings, description = "Settings",
                        onClick = {viewModel.onSettingsIconClick(popUpScreen)}
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(16.dp),
                onClick = { viewModel.onIconClick(context) },
            ) {
                Icon(imageVector = Icons.Filled.Sms, contentDescription = "Talk to developer")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {_ ->
        Box{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                Text(
//                    text = stringResource(R.string.landing), modifier = Modifier
//                        .fillMaxWidth()
//                        .wrapContentWidth(), fontSize = 20.sp, textAlign = TextAlign.Center
//                )
                ServiceWithIcon(
                    icon = R.drawable._91px_spotify_icon_svg,
                    Description = R.string.spotify,
                    { viewModel.onSpotifyClick(popUpScreen) })
                Spacer(modifier = Modifier.height(16.dp))
                ServiceWithIcon(
                    icon = R.drawable.netflix_logo_png_2616,
                    Description = R.string.Netflix,
                    { viewModel.onNotDone(popUpScreen) })
                Spacer(modifier = Modifier.height(16.dp))
                ServiceWithIcon(
                    icon = R.drawable.apple_music_icon_svg,
                    Description = R.string.Apple_Music,
                    { viewModel.onNotDone(popUpScreen) })
                Spacer(modifier = Modifier.height(16.dp))

            }
        }
    }
}

@Composable
fun ServiceWithIcon(
    @DrawableRes icon: Int, @StringRes Description: Int, popUpScreen: () -> Unit,
) {
    Card(
        modifier = Modifier.clickable(
            interactionSource = createMutableInteractionSource() ,
            indication = createIndication(),
            onClick = {popUpScreen()}
        ),
        elevation = 4.dp) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Image(
                    modifier = Modifier
                        .height(64.dp)
                        .width(64.dp),
                    painter = painterResource(icon),
                    contentDescription = stringResource(id = Description)
                )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = stringResource(id = Description))

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
private fun createMutableInteractionSource(): MutableInteractionSource = remember{
    MutableInteractionSource()
}

@Composable
private fun createIndication() = rememberRipple(bounded = true,color = Color(0xFFC0FFEE) )


@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}

