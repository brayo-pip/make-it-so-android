package com.example.makeitso.screens.spotify

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.makeitso.R

data class Image(
    val name: String,
   @DrawableRes val resource: Int,
    @StringRes val TextResource: Int
)


val Images = listOf(
    Image(name = "Invite", R.drawable.invite, R.string.invite_text),
    Image(name= "Pick Account", R.drawable.confirm_account,R.string.account_text),
    Image(name="Pick Location", R.drawable.pick_location,R.string.location_text),
    Image(name = "Confirm Region", R.drawable.confirm_location,R.string.region_text),
    Image(name = "Welcome", R.drawable.welcome,R.string.welcome_text),

)