package com.htec.codingexercise.dialog;

import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;

import java.util.ArrayList;


/**
 * Holds all important dialog parameters such as button and text arguments.
 */
public class DialogDescription implements Parcelable {
    public final boolean cancelable;
    public final Messenger onCancelListener;
    public final Messenger onDismissListener;
    public final @LayoutRes
    int id;
    public final DialogText title;
    public final ArrayList<DialogText> content;
    public final ArrayList<DialogButton> buttons;
    public final String tag;

    public DialogDescription(boolean cancelable, Messenger onCancelListener, Messenger onDismissListener, int id, DialogText title, ArrayList<DialogText> content, ArrayList<DialogButton> buttons, String tag) {
        this.cancelable = cancelable;
        this.onCancelListener = onCancelListener;
        this.onDismissListener = onDismissListener;
        this.id = id;
        this.title = title;
        this.content = content;
        this.buttons = buttons;
        this.tag = tag;
    }

    protected DialogDescription(Parcel in) {
        cancelable = in.readByte() != 0x00;
        onCancelListener = (Messenger) in.readValue(Messenger.class.getClassLoader());
        onDismissListener = (Messenger) in.readValue(Messenger.class.getClassLoader());
        id = in.readInt();
        tag = in.readString();
        title = (DialogText) in.readValue(DialogText.class.getClassLoader());
        if (in.readByte() == 0x01) {
            content = new ArrayList<DialogText>();
            in.readList(content, DialogText.class.getClassLoader());
        } else {
            content = null;
        }
        if (in.readByte() == 0x01) {
            buttons = new ArrayList<DialogButton>();
            in.readList(buttons, DialogButton.class.getClassLoader());
        } else {
            buttons = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (cancelable ? 0x01 : 0x00));
        dest.writeValue(onCancelListener);
        dest.writeValue(onDismissListener);
        dest.writeInt(id);
        dest.writeString(tag);
        dest.writeValue(title);
        if (content == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(content);
        }
        if (buttons == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(buttons);
        }
    }

    @SuppressWarnings("unused")
    public static final Creator<DialogDescription> CREATOR = new Creator<DialogDescription>() {
        @Override
        public DialogDescription createFromParcel(Parcel in) {
            return new DialogDescription(in);
        }

        @Override
        public DialogDescription[] newArray(int size) {
            return new DialogDescription[size];
        }
    };
}
