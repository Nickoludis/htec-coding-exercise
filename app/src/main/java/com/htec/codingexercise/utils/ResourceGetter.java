package com.htec.codingexercise.utils;

import android.content.res.Resources;
import android.support.annotation.DimenRes;
import android.support.annotation.RawRes;
import android.support.annotation.StringRes;

import java.io.InputStream;

/**
 * Wrapper around {@link android.content.Context} which exposes {@link Resources} methods.
 */
public interface ResourceGetter {

    /**
     * Converts and returns color as string by provided resource ID.
     *
     * @param color : resource ID
     * @return : Color as a string value
     */
    String getColor(int color);

    String getString(@StringRes int resource);

    String getString(@StringRes int resource, @StringRes int resource1);

    String getString(@StringRes int resource, String... string);

    int getInt(@DimenRes int resource);

    InputStream getRaw(@RawRes int resource);
}
