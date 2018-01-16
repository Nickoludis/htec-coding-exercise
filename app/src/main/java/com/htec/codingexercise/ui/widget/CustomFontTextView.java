package com.htec.codingexercise.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.htec.codingexercise.R;
import com.htec.codingexercise.utils.Logger;

/**
 * This class extends {@link TextView} to allow user to load custom fonts directly from XML resource file.
 * The font is referenced by adding this property to the {@link CustomFontTextView} instance:<br/>
 * {@code android:fontFamily="font_file_name"}<br/>
 * The font file needs to be located in the project's {@code assets/} folder or the class won't be able to load it.
 */
public class CustomFontTextView extends AppCompatTextView {

    private Context ctx;

    public CustomFontTextView(Context context) {
        super(context);
        this.ctx = context;
        applyFont(context, null);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        applyFont(context, attrs);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.ctx = context;
        applyFont(context, attrs);
    }

    private void applyFont(Context context, AttributeSet attrs) {

        // Automatically scale the size of textView in accordance with screen size.
        TextViewCompat.setAutoSizeTextTypeWithDefaults(this, AUTO_SIZE_TEXT_TYPE_UNIFORM);

        if (attrs != null) {
            TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
            int fontId = attributes.getInt(R.styleable.CustomFontTextView_customFontFamily, -1);
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
            Logger.e(CustomFontTextView.class, "Couldn't create typeface from asset font. Font ID = " + fontId, e);
            throw e;
        }
    }
}
