package com.example.makeitso.screens.coming_soon

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeitso.R

@Composable
fun NotDone(){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Text(
            text = stringResource(id = R.string.placeholder),
            modifier = Modifier.fillMaxWidth().wrapContentWidth(),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}