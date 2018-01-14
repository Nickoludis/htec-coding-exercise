package com.htec.codingexercise.ui.widget;

import android.content.Context;
import android.graphics.Typeface;

import java.io.Serializable;
import java.util.Hashtable;

public enum CustomFonts implements Serializable {

    FONT_STYLE_1("fonts/Roboto-Bold.ttf"),
    FONT_STYLE_2("fonts/Roboto-BoldItalic.ttf"),
    FONT_STYLE_3("fonts/Roboto-Regular.ttf"),
    FONT_STYLE_4("fonts/Roboto-Italic.ttf"),
    FONT_STYLE_5("fonts/Roboto-Black.ttf"),
    FONT_STYLE_6("fonts/Roboto-BlackItalic.ttf"),
    FONT_STYLE_7("fonts/Roboto-Light.ttf"),
    FONT_STYLE_8("fonts/Roboto-LightItalic.ttf"),
    FONT_STYLE_9("fonts/Roboto-Medium.ttf"),
    FONT_STYLE_10("fonts/Roboto-MediumItalic.ttf"),
    FONT_STYLE_11("fonts/Roboto-Thin.ttf"),
    FONT_STYLE_12("fonts/Roboto-ThinItalic.ttf");

    private String fileName;

    private static Hashtable<String, Typeface> cachedTypeFaces = new Hashtable<>();

    CustomFonts(String fileName) {
        this.fileName = fileName;
    }

    public static CustomFonts fromString(String fontName) {
        return CustomFonts.valueOf(fontName);
    }

    public Typeface asTypeface(Context context) {
        Typeface typeface = cachedTypeFaces.get(fileName);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(context.getAssets(), fileName);
            cachedTypeFaces.put(fileName, typeface);
        }
        return typeface;
    }

    public static CustomFonts fromId(int id) {
        for (CustomFonts f : values()) {
            if (f.ordinal() == id) {
                return f;
            }
        }
        throw new IllegalArgumentException();
    }
}
