package com.htec.codingexercise.dialog;

import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IdRes;

import com.htec.codingexercise.ui.widget.CustomButton;

public class DialogButton implements Parcelable {
    public final DialogText text;
    public final
    @IdRes
    int id;
    public final int background;
    public final boolean dismiss;
    public final Messenger onClickListener;

    public DialogButton(DialogText text, int id, boolean dismiss, Messenger onClickListener, CustomButton.ButtonColor background) {
        this.text = text;
        this.id = id;
        this.dismiss = dismiss;
        this.onClickListener = onClickListener;
        this.background = background == null ? -1 : background.ordinal();
    }

    public DialogButton(DialogText text, int id, boolean dissmis, Messenger onClickListener) {
        this(text, id, dissmis, onClickListener, null);
    }

    protected DialogButton(Parcel in) {
        text = in.readParcelable(DialogText.class.getClassLoader());
        id = in.readInt();
        background = in.readInt();
        dismiss = in.readByte() != 0;
        onClickListener = in.readParcelable(Messenger.class.getClassLoader());
    }

    public static final Creator<DialogButton> CREATOR = new Creator<DialogButton>() {
        @Override
        public DialogButton createFromParcel(Parcel in) {
            return new DialogButton(in);
        }

        @Override
        public DialogButton[] newArray(int size) {
            return new DialogButton[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(text, i);
        parcel.writeInt(id);
        parcel.writeInt(background);
        parcel.writeByte((byte) (dismiss ? 1 : 0));
        parcel.writeParcelable(onClickListener, i);
    }
}




