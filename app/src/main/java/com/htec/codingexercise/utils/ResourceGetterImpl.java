package com.htec.codingexercise.utils;

import android.content.Context;
import android.support.annotation.IntegerRes;
import android.support.annotation.RawRes;
import android.support.annotation.StringRes;

import java.io.InputStream;


public class ResourceGetterImpl implements ResourceGetter {

    private final Context context;

    public ResourceGetterImpl(Context context) {
        this.context = context;
    }

    @Override
    public String getColor(int color) {
        int intColor = context.getResources().getColor(color);
        return String.format("#%06X", (0xFFFFFF & intColor));
    }

    public String getString(@StringRes int resource) {
        return context.getResources().getString(resource);
    }

    @Override
    public String getString(@StringRes int resource, @StringRes int resource1) {
        return context.getResources().getString(resource, context.getResources().getString(resource1));
    }

    @Override
    public String getString(@StringRes int resource, String... string) {
        return context.getResources().getString(resource, string);
    }

    @Override
    public int getInt(@IntegerRes int resource) {
        return context.getResources().getInteger(resource);
    }

    @Override
    public InputStream getRaw(@RawRes int resource) {
        return context.getResources().openRawResource(resource);
    }
}
