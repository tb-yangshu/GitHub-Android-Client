package com.gac.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * image util
 * Created by spencer on 10/21/16.
 */
public final class ImageUtil {

    private ImageUtil() {
        // no instance.
    }

    /**
     * load image no other params
     *
     * @param context   context
     * @param source    image source
     * @param imageView into ImageView
     */
    public static void loadImage(Context context, Object source, ImageView imageView) {
        Glide.with(context)
                .load(source)
                .asBitmap()
                .centerCrop()
                .into(imageView);
    }

    /**
     * load image no other params
     *
     * @param context     context
     * @param source      image source
     * @param imageView   into ImageView
     * @param placeholder placeholder resource
     */
    public static void loadImage(Context context,
                                 Object source, ImageView imageView, @DrawableRes int placeholder) {
        Glide.with(context)
                .load(source)
                .asBitmap()
                .centerCrop()
                .placeholder(placeholder)
                .into(imageView);
    }

    /**
     * load image no other params
     *
     * @param context     context
     * @param source      image source
     * @param imageView   into ImageView
     * @param placeholder placeholder drawable
     */
    public static void loadImage(Context context,
                                 Object source, ImageView imageView, Drawable placeholder) {
        Glide.with(context)
                .load(source)
                .asBitmap()
                .centerCrop()
                .placeholder(placeholder)
                .into(imageView);
    }

    /**
     * load round image no other params
     *
     * @param context   context
     * @param source    image source
     * @param imageView into ImageView
     */
    public static void loadRoundImage(Context context,
                                      Object source, ImageView imageView) {
        Glide.with(context)
                .load(source)
                .asBitmap()
                .centerCrop()
                .into(new RoundImageViewTarget(imageView));
    }

    private static class RoundImageViewTarget extends BitmapImageViewTarget {

        RoundImageViewTarget(ImageView view) {
            super(view);
        }

        @Override
        protected void setResource(Bitmap resource) {
            RoundedBitmapDrawable circularBitmapDrawable =
                    RoundedBitmapDrawableFactory.create(getView().getResources(), resource);
            circularBitmapDrawable.setCircular(true);
            getView().setImageDrawable(circularBitmapDrawable);
        }
    }
}
