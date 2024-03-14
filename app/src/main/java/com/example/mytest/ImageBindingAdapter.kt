package com.example.mytest

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageBindingAdapter(imageView: AppCompatImageView, url: String?){
    url?.let {
        Glide.with(imageView.context)
            .load(it)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imageView)
    }

}