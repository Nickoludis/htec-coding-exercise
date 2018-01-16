package com.htec.codingexercise.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.htec.codingexercise.R;
import com.htec.codingexercise.utils.Logger;

public class CustomFontButton extends AppCompatButton {

    public static final String TAG = "CustomFontButton";

    /**
     * In case the font hasn't been set use default value.
     */
    public static final int DEFAULT_FONT = 8; // FONT_STYLE_9

    private Context ctx;

    public CustomFontButton(Context context) {
        super(context);
        this.ctx = context;
        applyFont(context, null);
    }

    public CustomFontButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        applyFont(context, attrs);
    }

    public CustomFontButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.ctx = context;
        applyFont(context, attrs);
    }

    private void applyFont(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
            int fontId = attributes.getInt(R.styleable.CustomFontTextView_customFontFamily, DEFAULT_FONT);
            setFont(fontId);
        }
    }

    public void setFont(int fontId) {
        if (fontId == -1) return;
        try {
            final Typeface customTypeface = CustomFonts.fromId(fontId).asTypeface(ctx);
            if (customTypeface != null) {
                this.setTypeface(customTypeface);
            }
        } catch (RuntimeException e) {
            Logger.e(CustomFontButton.class, "Couldn't create typeface from asset font. Font ID = " + fontId, e);
            throw e;
        }
    }
}
