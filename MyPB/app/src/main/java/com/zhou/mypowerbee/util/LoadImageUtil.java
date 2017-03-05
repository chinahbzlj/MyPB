package com.example.zhou.mypowerbee.util;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import retrofit2.http.Path;

/**
 * Created by zhou on 17-3-1.
 */

public class LoadImageUtil {
    public static void loadImage(Object o, String imgUrl, ImageView imageView) {
        if (o instanceof Fragment) {
            Fragment tmpFragment = (Fragment) o;
            Glide.with(tmpFragment).load(imgUrl).into(imageView);
        } else if (o instanceof Activity) {
            Activity activity = (Activity) o;
            Glide.with(activity).load(imgUrl).into(imageView);
        }
    }
}
