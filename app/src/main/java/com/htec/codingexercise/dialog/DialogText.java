package com.htec.codingexercise.dialog;

import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;

import com.htec.codingexercise.ui.widget.CustomFonts;

public class DialogText implements Parcelable {
    public final String text;
    public final @IdRes
    int id;
    public final @ColorRes
    int fontColor;
    public final int fontSize;
    public final boolean dismiss;
    public final CustomFonts fontFamily;
    public final Messenger onClickListener;


    public DialogText(String text, @IdRes int id, @ColorRes int fontColor, int fontSize, CustomFonts fontFamily, Messenger onClickListener, boolean dismiss) {
        this.text = text;
        this.id = id;
        this.fontColor = fontColor;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.onClickListener = onClickListener;
        this.dismiss = dismiss;
    }

    public DialogText(String text, @IdRes int id, @ColorRes int fontColor, int fontSize, CustomFonts fontFamily, Messenger onClickListener) {
        this(text, id, fontColor, fontSize, fontFamily, onClickListener, false);
    }

    public DialogText(String text, @IdRes int id, @ColorRes int fontColor, int fontSize, CustomFonts fontFamily) {
        this(text, id, fontColor, fontSize, fontFamily, null);
    }

    public DialogText(String text, @IdRes int id, @ColorRes int fontColor, int fontSize) {
        this(text, id, fontColor, fontSize, null);
    }

    public DialogText(String text, @IdRes int id, @ColorRes int fontColor) {
        this(text, id, fontColor, -1);
    }

    public DialogText(String text, @IdRes int id) {
        this(text, id, -1);
    }


    protected DialogText(Parcel in) {
        text = in.readString();
        id = in.readInt();
        fontColor = in.readInt();
        fontSize = in.readInt();
        fontFamily = (CustomFonts) in.readSerializable();
        dismiss = in.readByte() != 0;
        onClickListener = in.readParcelable(Messenger.class.getClassLoader());
    }

    public static final Creator<DialogText> CREATOR = new Creator<DialogText>() {
        @Override
        public DialogText createFromParcel(Parcel in) {
            return new DialogText(in);
        }

        @Override
        public DialogText[] newArray(int size) {
            return new DialogText[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(text);
        parcel.writeInt(id);
        parcel.writeInt(fontColor);
        parcel.writeInt(fontSize);
        parcel.writeSerializable(fontFamily);
        parcel.writeByte((byte) (dismiss ? 1 : 0));
        parcel.writeParcelable(onClickListener, i);
    }
}