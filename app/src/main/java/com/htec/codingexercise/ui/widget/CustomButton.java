package com.htec.codingexercise.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.htec.codingexercise.R;

public class CustomButton extends CustomFontButton {

    private long lastClickTime = 0;

    /**
     * The amount of time in milliseconds to wait before next click.
     */
    private static final long CLICK_DELAY_MS = 1000;

    /**
     * Prevent button from being pressed successively two times in a row in less than {@link CLICK_DELAY_MS} milliseconds.
     *
     * @param listener OnClickListener
     */
    @Override
    public void setOnClickListener(@Nullable final View.OnClickListener listener) {
        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((lastClickTime + CLICK_DELAY_MS) < System.currentTimeMillis()) {
                    lastClickTime = System.currentTimeMillis();
                    listener.onClick(view);
                }
            }
        });
    }

    public enum ButtonColor {

        SELECTOR_1(0),
        SELECTOR_2(1),
        SELECTOR_3(2);

        int id;

        ButtonColor(int id) {
            this.id = id;
        }

        public static ButtonColor fromId(int id) {
            for (ButtonColor f : values()) {
                if (f.id == id) {
                    return f;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    private ButtonColor color = ButtonColor.SELECTOR_1;

    public CustomButton(Context context) {
        super(context);
        initButton(context, null);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initButton(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initButton(context, attrs);
    }

    private void initButton(Context context, AttributeSet attrs) {

        if (attrs != null) {

            TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.LotteryButton);

            try {
                color = ButtonColor.fromId(attributes.getInt(R.styleable.LotteryButton_buttonColor, 0));
            } finally {
                attributes.recycle();
            }
        }

        setTransformationMethod(null);

        setButtonBackground(color);

        // Set font type
//        setTypeface(CustomFonts.FONT_STYLE_9.asTypeface(getContext()));
    }

    public void setFontId(int fontId) {
        setFont(fontId);
    }

    public void setButtonBackground(ButtonColor color) {

        int sdk = android.os.Build.VERSION.SDK_INT;

        switch (color) {

            // Gray
            case SELECTOR_1: {

                setBackground(getResources().getDrawable(R.drawable.button_selector_1));
                setTextColor(getResources().getColorStateList(R.color.button_text_color_selector_1));

            }
            break;

            // Green
            case SELECTOR_2: {

                setBackground(getResources().getDrawable(R.drawable.button_selector_2));
                setTextColor(getResources().getColorStateList(R.color.button_text_color_selector_2));

            }
            break;

            // Red
            case SELECTOR_3: {

                setBackground(getResources().getDrawable(R.drawable.button_selector_3));
                setTextColor(getResources().getColorStateList(R.color.button_text_color_selector_3));

            }
            break;
        }
    }
}