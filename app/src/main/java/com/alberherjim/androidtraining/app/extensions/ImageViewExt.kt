package com.alberherjim.androidtraining.app.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setUrl(imageUrl:String) {
    Glide
        .with(this.context)
        .load(imageUrl)
        .into(this)
}
