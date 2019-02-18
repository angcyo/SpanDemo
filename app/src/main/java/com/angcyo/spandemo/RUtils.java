package com.angcyo.spandemo;

import android.app.Application;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;


/**
 * Created by angcyo on 15-12-16 016 15:41 下午.
 */
public class RUtils {
    public static Application getApp() {
        return MainActivity.Companion.getUiApp();
    }

    /**
     * tint颜色
     */
    public static Drawable tintDrawable(@NonNull Drawable drawable, @ColorInt int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }

    /**
     * 改变Drawable的颜色
     */
    public static Drawable filterDrawable(@NonNull Drawable drawable, @ColorInt int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return tintDrawable(drawable, color);
        } else {
            return colorFilter(drawable, color);
        }
    }

    /**
     * 颜色过滤
     */
    public static Drawable colorFilter(@NonNull Drawable drawable, @ColorInt int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable).mutate();
        wrappedDrawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        return wrappedDrawable;

    }

}
