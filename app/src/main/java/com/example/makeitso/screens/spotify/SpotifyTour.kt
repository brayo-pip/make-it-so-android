package com.example.makeitso.screens.spotify

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Tour() {
    Scaffold(
        topBar = {TopAppBar(
            title = {
                Text(text = "Invite Tour")
            },
            backgroundColor = MaterialTheme.colors.primary,
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
                }
            }
        )}
    ) {_ ->
        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(Images) {
                ImageItem(image = it)
            }
        }
    }
}


@Composable
fun ImageItem(
   image: Image
){
    Card(elevation = 4.dp,
        modifier = Modifier.padding(8.dp)
        ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

        Image(painter = painterResource(id = image.resource), contentDescription = image.name)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text=stringResource(id = image.TextResource), fontSize = 16.sp,
            modifier = Modifier
                .wrapContentWidth()
                .padding(8.dp))
    }
    }

}




////@Preview
////@Composable
////fun PreviewLol(){
////    Link()
////}
//
//@Preview
//@Composable
//fun TourPreview() {
//    Tour()
//}