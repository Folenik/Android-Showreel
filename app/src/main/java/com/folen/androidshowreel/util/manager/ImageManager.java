package com.folen.androidshowreel.util.manager;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.folen.androidshowreel.R;

public class ImageManager {

    public static void setupImageWithUrl(Context context, ImageView imageView, String imageUrl) {
        Glide.with(context)
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_sync)
                .into(imageView);
    }
}
